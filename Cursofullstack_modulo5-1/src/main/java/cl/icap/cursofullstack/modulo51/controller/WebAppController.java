package cl.icap.cursofullstack.modulo51.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebAppController{
	
	@RequestMapping("/")
    public String getHome() {
        return "index";
    }
    
	@RequestMapping("/employees_page")
    public String getEmployees() {
    	return "employees";
    }

}
