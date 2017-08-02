package com.serv.springjdbc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.serv.springjdbc.beans.Emp;
import com.serv.springjdbc.dao.EmpDao;;
@Controller
public class EmpController {
    @Autowired
	EmpDao dao;//will inject dao from xml file
    
    /*It displays a form to input data, here "command" is a reserved request attribute
     *which is used to display object data into form
     */
	@RequestMapping("/empform")
	public ModelAndView showform(){
		return new ModelAndView("empform", "command", new Emp());
	}
	/*It saves object into database. The @ModelAttribute puts request data
	 *  into model object. You need to mention RequestMethod.POST method 
	 *  because default request is GET*/
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") Emp emp){
		System.out.println(dao.save(emp));
		return new ModelAndView("redirect:/viewemp");//will redirect to viewemp request mapping
	}
	/* It provides list of employees in model object */
	@RequestMapping("/viewemp")
	public ModelAndView viewemp(){
		List<Emp> list=dao.getEmployees();
		return new ModelAndView("viewemp","list",list);
	}
	/* It displays object data into form for the given id. 
	 * The @PathVariable puts URL data into variable.*/
	@RequestMapping(value="/editemp/{id}")
	public ModelAndView edit(@PathVariable int id){
		Emp emp=dao.getEmpById(id);
		System.out.println(id + " " +emp.getId() + emp.getFirstname() + emp.getDesignation() + emp.getLastname()
		 + emp.getSalary() + emp.getLocation());
		return new ModelAndView("empeditform","command",emp);
	}
	/* It updates model object. */
	@RequestMapping(value="/editsave",method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("emp") Emp emp){
		System.out.println(emp.getId() + emp.getFirstname() + emp.getDesignation() + emp.getLastname()
		 + emp.getSalary() + emp.getLocation());
		System.out.println(dao.update(emp));
		return new ModelAndView("redirect:/viewemp");
	}
	/* It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id){
		System.out.println(dao.delete(id));
		return new ModelAndView("redirect:/viewemp");
	}

}