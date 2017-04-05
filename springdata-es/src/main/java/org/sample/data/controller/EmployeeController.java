package org.sample.data.controller;

import org.sample.data.dto.EmployeeDto;
import org.sample.data.model.Employee;
import org.sample.data.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/employee")
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public @ResponseBody ResponseEntity<Employee> create(@RequestBody EmployeeDto empDto){
		Employee emp=empService.create(empDto);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET,produces="application/json",consumes="application/json")
	public @ResponseBody ResponseEntity<EmployeeDto> get(@PathVariable("id") long id){
		EmployeeDto empDto=empService.get(id);
		return new ResponseEntity<EmployeeDto>(empDto, HttpStatus.OK);
	}
}
