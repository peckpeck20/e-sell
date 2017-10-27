package e_sell.e_sell_back_end.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import e_sell.e_sell_back_end.domain.Item;
import e_sell.e_sell_back_end.domain.User;

@Controller 
public class AppController {

/*
	@RequestMapping("/new_user")
	public String createUser(){
		return "new_user";
	}
*/
	//1.create empty User object and add to model
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
	
////2.post filled form from user to the model object created in step 1 once validated
	@PostMapping("/sign_up")
	public String signUpSubmit(@Valid User user,BindingResult bindingResult,Model model){
		if (bindingResult.hasErrors()){
			//if the form has errors return Error
			return "sign_up";
		}
		//if its correct proceed to add user to model
		model.addAttribute("user",user);
		return "redirect:/add_item";
	}
	
	//1.create empty Item object and add to model
	@GetMapping("/add_item")
	public String itemForm(Model model){
		model.addAttribute("item", new Item());
		return "add_item";
	}
	
////2.post filled form from user to the model object created in step 1 once validated
	@PostMapping("/add_item")
	public String itemFormSubmit(@Valid Item item,BindingResult bindingResult,Model model){
		if (bindingResult.hasErrors()){
			//if the form has errors return Error
			return "add_item";
		}
		//if its correct proceed to add user to model
		model.addAttribute("item",item);
		return "redirect:/correct";
	}
	

}