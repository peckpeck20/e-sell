package e_sell.e_sell_back_end.domain;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	/*
	//post form to model
	@PostMapping("/sign_up")
	public String signUpSubmit(@ModelAttribute User user){
		return "home";
	}
	*/
	

	@PostMapping("/sign_up")
	public String signUpSubmit(@Valid User user,BindingResult bindingResult,Model model){
		if (bindingResult.hasErrors()){
			//if the form has errors return Error
			return "error";
		}
		//if its correct proceed to add user to model
		model.addAttribute("user",user);
		return "correct";
	}
	

}