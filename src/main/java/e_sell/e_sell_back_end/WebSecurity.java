package e_sell.e_sell_back_end;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import e_sell.e_sell_back_end.web.UserService;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
    @Autowired
    private UserService userDetailsService;	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http
	.authorizeRequests()
	//pages made public
	.antMatchers("/api/**", "/itemlist","/categorylist/**","/item-by-category/**","/sign_up","/css/**", "/js/**","/","/img/**","/categories","/items").permitAll()
	.antMatchers("/admin/**").hasRole("ADMIN")
	.anyRequest().authenticated()
	.and()
	.formLogin()
	.loginPage("/login")
	.defaultSuccessUrl("/itemlist")
	.permitAll()
	.and()
	.logout()
	.permitAll();
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication().withUser("admin").password("").roles("ADMIN");
	auth.inMemoryAuthentication().withUser("user").password("").roles("USER");
	auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	

	
	
}
