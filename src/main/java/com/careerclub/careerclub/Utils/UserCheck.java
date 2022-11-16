package com.careerclub.careerclub.Utils;

import com.careerclub.careerclub.Advice.RecordNotFoundException;
import com.careerclub.careerclub.Entities.User;
import com.careerclub.careerclub.Repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserCheck {

    private final UserRepository userRepository;

    public UserCheck(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public  User getUserFromToken(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        var user = userRepository.findByUsername(username).get();
        if(user==null){
            throw new RecordNotFoundException("User doesn't exists");
        };
        return user;
    }
}
