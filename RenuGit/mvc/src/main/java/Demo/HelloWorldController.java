package Demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm(){
		return "firstForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm(){
		return "firstFileProcessing";
	}
	
	@RequestMapping("/processFormVersion2")
	public String changeCase(HttpServletRequest request, Model model){
		
		String theName = request.getParameter("studentName");
		
		theName = theName.toUpperCase();
		
		String result = "Yo" + theName+"!";
		
		model.addAttribute("Message", result);
		
		return "firstFileProcessing";
		
	}
	
	@RequestMapping("/processFormVersionThree")
	public String ProcessFormVersionThree(@RequestParam("studentName") String theName, Model model){
		
		theName = theName.toUpperCase();
		
		String result = "My Friend" + theName+"!";
		
		model.addAttribute("Message", result);
		
		return "firstFileProcessing";
		
	}

}
