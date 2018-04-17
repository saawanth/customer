package jsondemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("employees")
public class EmployeeController {
	Employee employee = new Employee();

	@RequestMapping(value = "/{name}/{email}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Employee getEmployeeInJSON(@PathVariable String name, @PathVariable String email) {

		employee.setName(name);
		employee.setEmail(email);

		return employee;

	}

	@RequestMapping(value = "/{name}.xml", method = RequestMethod.GET, produces = "application/xml")
	public @ResponseBody Employee getEmployeeInXML(@PathVariable String name) {

		employee.setName(name);
		employee.setEmail("employee1@genuitec.com");

		return employee;

	}

}
