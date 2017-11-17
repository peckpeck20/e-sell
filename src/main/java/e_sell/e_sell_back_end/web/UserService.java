package e_sell.e_sell_back_end.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import e_sell.e_sell_back_end.domain.User;
import e_sell.e_sell_back_end.domain.UserRepository;

//used by Spring security to authenticate n validate users
@Service
public class UserService implements UserDetailsService {
private final UserRepository repository;
@Autowired
public UserService(UserRepository userRepository) {
this.repository = userRepository;
}
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User curruser = repository.findByUsername(username);
	UserDetails user = new org.springframework.security.core.userdetails.User(username,
	curruser.getPassword(),
	AuthorityUtils.createAuthorityList(curruser.getRole()));
	return user;
	}
}
