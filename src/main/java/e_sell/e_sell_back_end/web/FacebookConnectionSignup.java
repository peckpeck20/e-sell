package e_sell.e_sell_back_end.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

import e_sell.e_sell_back_end.domain.User;
import e_sell.e_sell_back_end.domain.UserRepository;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String execute(Connection<?> connection) {
        System.out.println("signup === FB ");
        final User user = new User();
        user.setUsername(connection.getDisplayName());
        String pwd =connection.getProfileUrl();
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        String hashPwd = bc.encode(pwd);
        
        user.setPassword(hashPwd);
        userRepository.save(user);
        return user.getUsername();
    }

}