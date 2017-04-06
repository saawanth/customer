

package com.SpringMVC;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringMVC.DOA.DoaUserInterface;
import com.SpringMVC.DOA.MovieDoa;
import com.SpringMVC.Model.Movies;
import com.SpringMVC.Model.User;
import com.SpringMVC.Service.Service;
import com.SpringMVC.ServiceImpl.UserService;

@Controller
@RequestMapping("/")
public class ControllerHome {
	@Autowired
	DoaUserInterface userDoa;
	@Autowired
	MovieDoa movieDoa;
public String start(ModelMap model){
	model.addAttribute("UserName","suman goud janagam");
	return "index";
}
@RequestMapping(value="home",method=RequestMethod.POST)
public String home(User user,ModelMap model){
	userDoa.insert(user);
	model.put("name",user.getName());

	model.put("age",user.getAge());
	
	return "home";
	
}
@RequestMapping(value="moviedetails",method=RequestMethod.POST)
public String moviedetails(@ModelAttribute("movie") Movies movie,ModelMap model){
	movieDoa.insert(movie);
	model.put("name",movie);
	
	return "moviedisplay";
	
}
	@RequestMapping(value="find",method=RequestMethod.POST)
	public String find(@RequestParam("username") String username, ModelMap model){
		
		if(username.equals("") || username==null){
			return "error";
		}
		else{
		String movieName=movieDoa.find(username);
		//User user=service.find(username);
		model.put("user",movieName);
		model.put("username", username);
	//	model.put("movie",user.getTitle());
	//	model.put("age",user.getAge());
	//	model.put("rating",user.getRating());
		return "display";
	
	}
	}
	
	
	
	
}
