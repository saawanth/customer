package Demo;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, ste);
	}
	
	@RequestMapping("/showForm")
	public String customerInfo(Model model){		
		model.addAttribute("customer", new Customer());		
		return "CustomerForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, 
			BindingResult theBindingResult){
		if(theBindingResult.hasErrors()){
			return "CustomerForm";
		}else{
			return "CustomerConfirmation";		
		}			
	}

}
