package e_sell.e_sell_back_end;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
		public CommandLineRunner demo(UserRepository urepository) {
			return (args) -> {
				//saving users
				urepository.save(new User("Jose","Zapata","jose@zapata.com","12345678"));
				urepository.save(new User("Teddy","Bear","teddy@bear.com","12345678"));
				urepository.save(new User("Cleo","Yuka","cleo@yuka.com","12345678"));
				
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
				
			};
	
		}
}
