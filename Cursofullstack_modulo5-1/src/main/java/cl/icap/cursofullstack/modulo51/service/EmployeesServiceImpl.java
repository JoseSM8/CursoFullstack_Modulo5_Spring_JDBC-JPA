package cl.icap.cursofullstack.modulo51.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.icap.cursofullstack.modulo51.model.dao.EmployeesDAO;
import cl.icap.cursofullstack.modulo51.model.dto.EmployeesDTO;

@Service
public class EmployeesServiceImpl implements EmployeesService {
	
	@Autowired
	EmployeesDAO employeesDAO;
	
	public EmployeesServiceImpl() {
		
	}

	public List<EmployeesDTO> list(){
		return employeesDAO.list();
	}

	@Override
	public int insert(EmployeesDTO employeesDTO) {
		return employeesDAO.insert(employeesDTO);
	}

	@Override
	public EmployeesDTO get(int employee_id) {
		return employeesDAO.get(employee_id);
	}

	@Override
	public int update(EmployeesDTO employeesDTO) {
		return employeesDAO.update(employeesDTO);
	}

	@Override
	public int delete(int employee_id) {
		return employeesDAO.delete(employee_id);
	}
}
