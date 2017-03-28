package org.sample.data.controller;

import org.sample.data.dto.EmployeeDto;
import org.sample.data.model.Employee;
import org.sample.data.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/employee")
@Controller
public class EmployeeController {

	private EmployeeService empService;
	
	@RequestMapping(value="/create")
	public @ResponseBody ResponseEntity<Employee> create(EmployeeDto empDto){
		Employee emp=empService.create(empDto);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@RequestMapping(value="/get")
	public @ResponseBody ResponseEntity<EmployeeDto> get(long id){
		EmployeeDto empDto=empService.get(id);
		return new ResponseEntity<EmployeeDto>(empDto, HttpStatus.OK);
	}
}
