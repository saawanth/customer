package Demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/studentForm")
	public String studentInfo(Model model){
		
		Student theStudent = new Student();		
		model.addAttribute("student", theStudent);		
		return "studentForm";		
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theName){
		System.out.println("The Student: " +theName.getFirstName() + theName.getLastName());
		return "studentConfirmation";		
	}
}
