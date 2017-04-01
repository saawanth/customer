package org.sample.data.service;

import org.sample.data.dao.EmployeeRepository;
import org.sample.data.dto.EmployeeDto;
import org.sample.data.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepository;
	@Override
	public Employee create(EmployeeDto empDto) {
		if(empDto!=null){
		Employee emp=new Employee();
		emp.setId(empDto.getId());
		emp.setAddress(empDto.getAddress());
		emp.setDesignation(empDto.getDesignation());
		emp.setName(empDto.getName());
		emp.setSalary(empDto.getSalary());
		emp=empRepository.save(emp);
		return emp;
		}
		else{
			return null;
		}
	}

	@Override
	public EmployeeDto get(long id) {
		Employee emp=empRepository.findOne(id);
		EmployeeDto empDto=new EmployeeDto();
		if(emp!=null){
			empDto.setId(emp.getId());
			empDto.setAddress(emp.getAddress());
			empDto.setDesignation(emp.getDesignation());
			empDto.setName(emp.getName());
			empDto.setSalary(emp.getSalary());
			return empDto;
		}
		return null;
	}

}
