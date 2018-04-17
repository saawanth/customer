package springmvcdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	@RequestMapping("/showForm")
	public String showForm() {
		return "showform";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "processform";
	}

	@RequestMapping(value = "/processFormvtwo", method = RequestMethod.GET)
	public String shoutLoud(HttpServletRequest request, Model model) {
		String name = request.getParameter("studentName");
		name = name.toUpperCase();
		String result = "Yo! " + name;
		model.addAttribute("message", result);
		return "processform";
	}

	@RequestMapping(value = "/processFormvthree", method = RequestMethod.GET)
	public String shoutVeryLoud(@RequestParam("studentName") String name, Model model) {
		name = name.toUpperCase();
		String result = "Hey!! " + name;
		model.addAttribute("message", result);
		return "processform";
	}
}
