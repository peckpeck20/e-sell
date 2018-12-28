package e_sell.e_sell_back_end;



//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import e_sell.e_sell_back_end.domain.Category;
import e_sell.e_sell_back_end.domain.CategoryRepository;
import e_sell.e_sell_back_end.domain.Item;
import e_sell.e_sell_back_end.domain.ItemRepository;
import e_sell.e_sell_back_end.domain.User;
import e_sell.e_sell_back_end.domain.UserRepository;


@SpringBootApplication
public class ESellBackEndApplication {
	//Logger
	//private static final Logger log = LoggerFactory.getLogger(ESellBackEndApplication.class);
	//main application
	public static void main(String[] args) {
		SpringApplication.run(ESellBackEndApplication.class, args);
	}
	//bean 
		@Bean
		public CommandLineRunner demo(UserRepository urepository, CategoryRepository crepository, ItemRepository irepository) {
			return (args) -> {
				
				//create test users
				String pwd = "1234567";
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashPwd = bc.encode(pwd);
				
				urepository.save(new User("Jose", "Zapata", "jose@zapata.com", "creator", hashPwd,"ADMIN"));
				urepository.save(new User("Tester","Bear","tester@bear.com","tester",hashPwd,"USER"));
				urepository.save(new User("Beta","Beta","beta@tester.com","betatester",hashPwd,"USER"));
				urepository.save(new User("Charley","Charley","charley@tester.com","charleytester",hashPwd,"USER"));
				urepository.save(new User("Delta","Delta","delta@tester.com","deltatester",hashPwd,"USER"));
				
				//create categories
				crepository.save(new Category("Home"));
				crepository.save(new Category("Electronics"));
				crepository.save(new Category("Services"));
				crepository.save(new Category("Vehicles"));
				crepository.save(new Category("Clothes"));
				
				//insert items
				irepository.save(new Item("mazda 2009","manual transmition 10000km","Used",00200,2000.00, crepository.findOne(4L),urepository.findOne(2L)));
				irepository.save(new Item("iPhone 6","latest OS, includes all accesories","Used",00150,999.00,crepository.findOne(2L),urepository.findOne(5L)));
				irepository.save(new Item("Blender","brand new, never opened","New",00135,20.00,crepository.findOne(1L),urepository.findOne(2L)));
				irepository.save(new Item("Samsung 8","Fresh from the factory, 3 year warranty","Refurbished",00200,400.00,crepository.findOne(2L),urepository.findOne(4L)));
				irepository.save(new Item("T-shirt","White Polo","New",00124,4.99,crepository.findOne(5L),urepository.findOne(2L)));
				irepository.save(new Item("Timberland Boots","Size 9","New",00200,100.00,crepository.findOne(5L),urepository.findOne(2L)));
				irepository.save(new Item("Lenovo x240","Latest ultrabook - i7 quad core processor","Refurbished",00100,499.99,crepository.findOne(2L),urepository.findOne(3L)));
				irepository.save(new Item("Car wash","make your car fresh and clean now!","New",00200,40.00, crepository.findOne(3L),urepository.findOne(3L)));
				irepository.save(new Item("Computer repair","Do you have a broken computer? no problem. Call us now ","New",00200,100.00, crepository.findOne(3L),urepository.findOne(2L)));
				irepository.save(new Item("Washing machine","Brand:Samsung still in box","Refurbished",00500,500.00, crepository.findOne(1L),urepository.findOne(2L)));				
				irepository.save(new Item("broken honda 1999","manual transmition 2131230km","Used",00200,2000.00, crepository.findOne(4L),urepository.findOne(1L)));
				irepository.save(new Item("new honda 2009","manual transmition 0km","NEW",00200,2000.00, crepository.findOne(4L),urepository.findOne(1L)));
		
				};
	
		}
}
