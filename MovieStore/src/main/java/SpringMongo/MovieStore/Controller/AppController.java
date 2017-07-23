package SpringMongo.MovieStore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping("/")
	public String getIndex()
	{
		return "index";
	}
}
