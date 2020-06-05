package cl.icap.cursofullstack.modulo51.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cl.icap.cursofullstack.modulo51.model.dto.EmployeesDTO;
import cl.icap.cursofullstack.modulo51.service.EmployeesService;

@Controller
@RequestMapping(value="/employees")
public class EmployeesController {

	@Autowired
	EmployeesService employeesService;
	
	@RequestMapping(value="/list")
	public @ResponseBody List<EmployeesDTO> ajaxList(HttpServletRequest req, HttpServletResponse res) {
		return employeesService.list();
	}
	
	@RequestMapping(value="/get")
	public @ResponseBody EmployeesDTO ajaxGet(HttpServletRequest req, HttpServletResponse res) {
		return employeesService.get(Integer.parseInt(req.getParameter("employee_id")));
	}
	
	@RequestMapping(value="/insert")
	public @ResponseBody int ajaxInsert(HttpServletRequest req, HttpServletResponse res) {
		int rows = 0;
		String requestData;
		try {
			requestData = req.getReader().lines().collect(Collectors.joining());
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			EmployeesDTO employeesDTO = gson.fromJson(requestData, EmployeesDTO.class);
			rows = employeesService.insert(employeesDTO);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	@RequestMapping(value="/update")
	public @ResponseBody int ajaxUpdate(HttpServletRequest req, HttpServletResponse res) {
		int rows = 0;
		String requestData;
		try {
			requestData = req.getReader().lines().collect(Collectors.joining());
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			EmployeesDTO employeesDTO = gson.fromJson(requestData, EmployeesDTO.class);
			rows = employeesService.update(employeesDTO);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	@RequestMapping(value="/delete")
	public @ResponseBody int ajaxDelete(HttpServletRequest req, HttpServletResponse res) {
		int rows = 0;
		try {
			rows = employeesService.delete(Integer.parseInt(req.getParameter("employee_id")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}

}
