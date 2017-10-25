package e_sell.e_sell_back_end.domain;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import e_sell.e_sell_back_end.web.User;

@Controller 
public class AppController {

/*
	@RequestMapping("/new_user")
	public String createUser(){
		return "new_user";
	}
*/
	//create empty User object and add to model
	@GetMapping("/sign_up")
	public String signUpForm(Model model){
		model.addAttribute("user", new User());
		return "sign_up";
	}
	
	@PostMapping("/sign_up")
	public String signUpSubmit(@ModelAttribute User user){
		return "home";
	}
}