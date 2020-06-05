package cl.icap.cursofullstack.modulo51.model.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.icap.cursofullstack.modulo51.model.dto.EmployeesDTO;

@Repository
@Transactional
public class EmployeesDAOImpl implements EmployeesDAO {

	private String insert="INSERT INTO Employees VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private String select="SELECT * FROM Employees WHERE employee_id=?";
	private String update="UPDATE Employees SET employee_id=?, first_name=?,last_name=?, email=?, phone_number=?, hire_date=?, job_id=?, salary=?, commission_pct=?, manager_id=?, department_id=? WHERE employee_id=?";
	private String delete="DELETE Employees WHERE employee_id=?";
	private String list="SELECT * FROM Employees";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public EmployeesDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insert(EmployeesDTO employeesDTO) {
		int rows = 0;
		Object args[] = {
				employeesDTO.getEmployee_id(),
				employeesDTO.getFirst_name(),
				employeesDTO.getLast_name(),
				employeesDTO.getEmail(),
				employeesDTO.getPhone_number(),
				employeesDTO.getHire_date(),
				employeesDTO.getJob_id(),
				employeesDTO.getSalary(),
				employeesDTO.getCommission_pct(),
				employeesDTO.getManager_id(),
				employeesDTO.getDepartment_id()
		};
		
		try {
			rows = jdbcTemplate.update(insert, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public EmployeesDTO get(int employee_id) {
		Object args[] = {employee_id};
		EmployeesDTO employeesDTO;
		try {
			employeesDTO = jdbcTemplate.queryForObject(select, args, BeanPropertyRowMapper.newInstance(EmployeesDTO.class));
		} catch (Exception e) {
			employeesDTO = null;
			e.printStackTrace();
		}
		
		return employeesDTO;
	}

	@Override
	public int update(EmployeesDTO employeesDTO) {
		int rows = 0;
		Object args[] = {
				employeesDTO.getEmployee_id(),
				employeesDTO.getFirst_name(),
				employeesDTO.getLast_name(),
				employeesDTO.getEmail(),
				employeesDTO.getPhone_number(),
				employeesDTO.getHire_date(),
				employeesDTO.getJob_id(),
				employeesDTO.getSalary(),
				employeesDTO.getCommission_pct(),
				employeesDTO.getManager_id(),
				employeesDTO.getDepartment_id(),
				employeesDTO.getEmployee_id(),
		};
		
		try {
			rows = jdbcTemplate.update(update, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int delete(int employee_id) {
		int rows = 0;
		Object args[] = {employee_id};
		try {
			rows = jdbcTemplate.update(delete, args);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return rows;
	}

	@Override
	public List<EmployeesDTO> list() {
		List<EmployeesDTO> listEmployees = jdbcTemplate.query(list, BeanPropertyRowMapper.newInstance(EmployeesDTO.class));
		return listEmployees;
	}

}
