package e_sell.e_sell_back_end.web;



import java.util.List;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import e_sell.e_sell_back_end.domain.Category;
import e_sell.e_sell_back_end.domain.CategoryRepository;
import e_sell.e_sell_back_end.domain.Item;
import e_sell.e_sell_back_end.domain.ItemRepository;
import e_sell.e_sell_back_end.domain.SignupForm;
import e_sell.e_sell_back_end.domain.User;
import e_sell.e_sell_back_end.domain.UserRepository;


@Controller 
public class AppController {
	//allows us to use the repositories methods
	@Autowired
	private UserRepository urepository;
	
	@Autowired
	private ItemRepository irepository;

	@Autowired
	private CategoryRepository crepository;
	
    //login redirects root and login path
    @RequestMapping(value={"/"},method=RequestMethod.GET)
    public String rootDefault() {	
        return "redirect:itemlist";
    }
    
    @RequestMapping(value={"/login"})
    public String loginReq() {	
        return "login";
    }
    //fb 
    @RequestMapping(value={"/signin"})
    public String signIn() {	
        return "signin";
    }
    

	//for testing purposes
	@RequestMapping("/correct")
	public String correctPage(){
		return "correct";
	}


	//1.create an empty form object and add to model
	@GetMapping("/sign_up")
	public String signUpForm(Model model){
		model.addAttribute("signupform", new SignupForm());
		return "sign_up";
	}
	
	//2.post filled form from user to the model object created in step 1 once validated
	@PostMapping("/sign_up")
	public String submitForm(@Valid @ModelAttribute("signupform") SignupForm signupform,BindingResult bindingResult){
		if (!bindingResult.hasErrors()) { // validation errors
    		if (signupform.getPassword().equals(signupform.getPasswordCheck())) { // check password match		
	    		String pwd = signupform.getPassword();
		    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		    	String hashPwd = bc.encode(pwd);
	
		    	User newUser = new User();
		    	newUser.setFirstName(signupform.getFirstName());
		    	newUser.setLastName(signupform.getLastName());
		    	newUser.setEmail(signupform.getEmail());
		    	newUser.setUsername(signupform.getUsername());
		    	newUser.setPassword(hashPwd);
		    	newUser.setRole("USER");
		    	if (urepository.findByUsername(signupform.getUsername()) == null) { // Check if user exists
		    		urepository.save(newUser);
		    	}
		    	else {
	    			bindingResult.rejectValue("username", "err.username", "Username already exists");    	
	    			return "sign_up";		    		
		    	}
    		}
    		else {
    			bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");    	
    			return "sign_up";
    		}
    	}
    	else {
    		return "sign_up";
    	}
    	return "redirect:/login";    	   
	}
	
	//list all user
    @RequestMapping(value ="userlist")
    public String userList(Model model) {
    	//add all users to Model
        model.addAttribute("users", urepository.findAll());
        return "userlist";
    }
	
	//1.create empty Item object and add to model
    

    
	@GetMapping("/add_item")
	public String itemForm(Model model){
		model.addAttribute("item", new Item());
		//add categories
		model.addAttribute("categorys",crepository.findAll());
		//testing
		
		//String test = session.getId();

		//System.out.println("PRINT --------" + test.toString());
		//model.addAttribute("users",urepository.findAll());
		return "add_item";
	}
	
	//2.post filled form from user to the model object created in step 1 once validated
	@PostMapping("/add_item")
	public String itemFormSubmit(@Valid Item item,BindingResult bindingResult,Model model){
		if (bindingResult.hasErrors()){
			//if the form has errors return Error
			return "add_item";
		}
		//if its correct proceed to add user to model
		//item.setPrice(new BigDecimal(0));
		irepository.save(item);
		return "redirect:/itemlist";
	}
	
	//Show all items
    @RequestMapping(value ="/itemlist")
    public String itemList(Model model) {
    	//add all items to Model
        model.addAttribute("items", irepository.findAllByOrderByPriceAsc());
        return "itemlist";
    }
    
	//show all categories
	@RequestMapping(value="/categorylist")
	public String categoryList(Model model){
		model.addAttribute("categorys", crepository.findAll());
		return "categorylist";
	}
    //show items by category
    @RequestMapping(value="/item-by-category/{id}",method= RequestMethod.GET)
    public String itemByCategory(@PathVariable("id") Category categoryid, Model model){
    	model.addAttribute("items",irepository.findByCategory(categoryid));
    	return "/itemlist";  	
    }
  //show items by user
    @RequestMapping(value="/user-posts/{id}",method= RequestMethod.GET)
    public String showPosts(@PathVariable("id") User userId, Model model){
    	model.addAttribute("items",irepository.findByUser(userId));
    	return "/itemlist";  	
    }
    
    //edit category
    @RequestMapping(value="/edit_category/{id}",method = RequestMethod.GET)
    //@PathVariable indicates that a method parameter should be bound to a URL template variable
    public String editCategory(@PathVariable("id")Long categoryId,Model model){
		model.addAttribute(crepository.findOne(categoryId));	
    	return "edit-category";	
    }
    //save category
    @RequestMapping(value = "/save_category", method = RequestMethod.POST)
    public String saveCat(Category category){
        crepository.save(category);
    	return "redirect:/categorylist";
    }
    
    //create new category
    @RequestMapping(value = "/save_category", method = RequestMethod.GET)
    public String createCat(Category category,Model model){
        model.addAttribute("category", new Category());
    	return "/save_category";
    }
    
    
    //delete category
    @RequestMapping(value="/delete_category/{id}",method = RequestMethod.GET)
    //@PathVariable indicates that a method parameter should be bound to a URL template variable
    public String deleteCategory(@PathVariable("id")Long categoryId,Model model){
		crepository.delete(categoryId);
    	return "redirect:/categorylist";	
    }

        
    //delete a user - admin
    //in value we take the ID
    @RequestMapping(value="/delete_user{id}",method = RequestMethod.GET)
    //@PathVariable indicates that a method parameter should be bound to a URL template variable
    public String deleteBook(@PathVariable("id")Long userId,Model model){
		urepository.delete(userId);
    	return "redirect:userlist";	
    }
    
    //Edit user - admin
    @RequestMapping(value="/edit_user/{id}",method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long userId,Model model){
    	model.addAttribute("user",urepository.findOne(userId));
    	return "edit_user";
    }
    
    //save edited user
    @RequestMapping(value = "save_user", method = RequestMethod.POST)
    public String saveUser(User user){
    	//encrypt password
    	String pwd = user.getPassword();
    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
    	String hashPwd = bc.encode(pwd);
    	user.setPassword(hashPwd);
        urepository.save(user);
    	return "redirect:/userlist";
    }
    
    //edit item
    @RequestMapping(value="/edit_item/{id}",method = RequestMethod.GET)
    public String editItem(@PathVariable("id") Long itemId,Model model){
    	model.addAttribute("item",irepository.findOne(itemId));
    	model.addAttribute("categorys",crepository.findAll());
    	//model.addAttribute("users",urepository.findAll());
    	return "edit_item";
    };
    //save edited item
    @RequestMapping(value = "save_item", method = RequestMethod.POST)
    public String saveItem(Item item){
        irepository.save(item);
    	return "redirect:/itemlist";
    }
    //delete item - admin
    @RequestMapping(value="/delete_item/{id}",method = RequestMethod.GET)
    public String deleteItem(@PathVariable("id") Long itemId,Model model){
       	irepository.delete(itemId);
		return "redirect:/itemlist";
    }
    //REST service
	@RequestMapping(value = "/users" ,method = RequestMethod.GET)
    public @ResponseBody List<User> userListRest(){
    	return (List<User>) urepository.findAll();
    }
	
	@RequestMapping(value = "/items" ,method = RequestMethod.GET)
    public @ResponseBody List<Item> itemListRest(){
    	return (List<Item>) irepository.findAll();
    }
	
	@RequestMapping(value = "/categories" ,method = RequestMethod.GET)
    public @ResponseBody List<Category> categoryListRest(){
    	return (List<Category>) crepository.findAll();
    }
	
	//REST service - get by ID
    @RequestMapping(value="/user/{id}", method = RequestMethod.GET)
    public @ResponseBody User findUserRest(@PathVariable("id")Long userid){
    	return urepository.findOne(userid);
    }
    
    @RequestMapping(value="/category/{id}", method = RequestMethod.GET)
    public @ResponseBody Category findCategoryRest(@PathVariable("id")Long categoryid){
    	return crepository.findOne(categoryid);
    }
    /*
     * not showing Category
     */
    @RequestMapping(value="/item/{id}", method = RequestMethod.GET)
    public @ResponseBody Item findItemRest(@PathVariable("id")Long itemid){
    	return irepository.findOne(itemid);
    }
    

    
    

    


	
	
	

}