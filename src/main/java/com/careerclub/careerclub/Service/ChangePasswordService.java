package com.careerclub.careerclub.Service;

import com.careerclub.careerclub.Advice.RecordNotFoundException;
import com.careerclub.careerclub.Config.WebSecurityConfig;
import com.careerclub.careerclub.DTOs.ChangePasswordDto;
import com.careerclub.careerclub.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordService {
    private final UserRepository userRepository;

    public ChangePasswordService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String changeYourPassword(ChangePasswordDto changePasswordDto){
        var user = userRepository.findById(changePasswordDto.getUserId());
        user.ifPresentOrElse(user1 -> {
            if(WebSecurityConfig.passwordEncoder().matches(changePasswordDto.getOldPassword(), user1.getPassword())){
                user1.setPassword(changePasswordDto.encryptPassword());
                userRepository.save(user1);
            }else{
                throw new RecordNotFoundException("Incorrect password") ;
            }
        }, ()->{
            throw new RecordNotFoundException("User doesn't exist");
        });
        return "Password changed successfully";
    }
}
