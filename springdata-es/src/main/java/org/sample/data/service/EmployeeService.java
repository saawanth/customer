package org.sample.data.service;

import org.sample.data.dto.EmployeeDto;
import org.sample.data.model.Employee;

public interface EmployeeService {

	public Employee create(EmployeeDto empDto);

	public EmployeeDto get(long id);

}
