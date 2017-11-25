package e_sell.e_sell_back_end;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import e_sell.e_sell_back_end.domain.Category;
import e_sell.e_sell_back_end.domain.CategoryRepository;
import e_sell.e_sell_back_end.domain.Item;
import e_sell.e_sell_back_end.domain.ItemRepository;
import e_sell.e_sell_back_end.domain.User;
import e_sell.e_sell_back_end.domain.UserRepository;


@SpringBootApplication
public class ESellBackEndApplication {
	//Logger
	private static final Logger log = LoggerFactory.getLogger(ESellBackEndApplication.class);
	//main application
	public static void main(String[] args) {
		SpringApplication.run(ESellBackEndApplication.class, args);
	}
	//bean 
		@Bean
		public CommandLineRunner demo(UserRepository urepository, CategoryRepository crepository, ItemRepository irepository) {
			return (args) -> {
				//create users
				/*
				urepository.save(new User("Jose","Zapata","jose@zapata.com","peckT","1234567","ADMIN"));
				urepository.save(new User("Teddy","Bear","teddy@bear.com","tedy200","12345678","USER"));
				urepository.save(new User("Cleo","Yuka","cleo@yuka.com","yuka2017","12345678","USER"));
				
				//create categories
				crepository.save(new Category("Home"));
				crepository.save(new Category("Electronics"));
				crepository.save(new Category("Services"));
				crepository.save(new Category("Vehicles"));
				crepository.save(new Category("Clothes"));
				
				//insert items
				irepository.save(new Item("mazda 2009","manual transmition 10000km","Used",00200,2000.00, crepository.findOne(4L)));
				irepository.save(new Item("iPhone 6","latest OS, includes all accesories","Used",00150,999.00,crepository.findOne(2L)));
				irepository.save(new Item("Blender","brand new, never opened","New",00135,20.00,crepository.findOne(1L)));
				irepository.save(new Item("Samsung 8","Fresh from the factory, 3 year warranty","Refurbished",00200,400.00,crepository.findOne(2L)));
				irepository.save(new Item("T-shirt","White Polo","New",00124,4.99,crepository.findOne(5L)));
				irepository.save(new Item("Timberland Boots","Size 9","New",00200,100.00,crepository.findOne(5L)));
				irepository.save(new Item("Lenovo x240","Latest ultrabook - i7 quad core processor","Refurbished",00100,499.99,crepository.findOne(2L)));
				irepository.save(new Item("Car wash","make your car fresh and clean now!","New",00200,40.00, crepository.findOne(3L)));
				irepository.save(new Item("Computer repair","Do you have a broken computer? no problem. Call us now ","New",00200,100.00, crepository.findOne(3L)));
				irepository.save(new Item("Washing machine","Brand:Samsung still in box","Refurbished",00500,500.00, crepository.findOne(1L)));				
				
				
				//show all users
				log.info("SHOWING ALL USERS");
				log.info("-------------------------------");
				for (User user : urepository.findAll()) {
					log.info(user.toString());
				}
				//get a user by ID
				log.info("USER WITH ID 3");		
				//once we found the user we see the results in String format
				User foundUser = urepository.findOne(3L);
				log.info("-------------------------------");
				log.info(foundUser.toString());
				//get user by lastName
				log.info("SHOW USER WITH LAST NAME: ZAPATA");
				log.info("-------------------------------");
				//User userlastName = urepository.findByLastName("zapata")
				for (User user : urepository.findByLastName("Zapata")) {
					log.info(user.toString());
				}
*/			
			};
	
		}
}
