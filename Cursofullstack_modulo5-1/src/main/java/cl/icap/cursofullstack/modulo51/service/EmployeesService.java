package cl.icap.cursofullstack.modulo51.service;

import java.util.List;

import cl.icap.cursofullstack.modulo51.model.dto.EmployeesDTO;

public interface EmployeesService {

	public int insert(EmployeesDTO employeesDTO);
	public EmployeesDTO get(int employee_id);
	public int update(EmployeesDTO employeesDTO);
	public int delete(int employee_id);
	public List<EmployeesDTO> list();
	
}
