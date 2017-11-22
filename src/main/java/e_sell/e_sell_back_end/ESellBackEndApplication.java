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
				urepository.save(new User("Jose","Zapata","jose@zapata.com","peckpeck","1234567","ADMIN"));
				urepository.save(new User("Teddy","Bear","teddy@bear.com","tedy200","12345678","USER"));
				urepository.save(new User("Cleo","Yuka","cleo@yuka.com","yuka2017","12345678","USER"));
				
				//create categories
				crepository.save(new Category("Home"));
				crepository.save(new Category("Electronics"));
				crepository.save(new Category("Services"));
				crepository.save(new Category("Vehicles"));
				crepository.save(new Category("Clothes"));
				
				//insert items
				//irepository.save(new Item(1,"aa",50.00,"New","test",0002));
				//irepository.save(new Item("1","like new car with tires","2000.00","used","Mazda 2009","00200"));
				//irepository.save(new Item("Mazda 2009","like new car with tires","Used","00200","1200.00",1));
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
				
				//find Services category
				log.info("SHOW SERVICES CATEGORY");
				log.info("-------------------------------");
				for (Category category : crepository.findByType("Services")){
					log.info(category.toString());
				}
			
			};
	
		}
}
