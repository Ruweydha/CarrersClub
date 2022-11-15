package com.careerclub.careerclub.Controllers;

import com.careerclub.careerclub.DTOs.ChangePasswordDto;
import com.careerclub.careerclub.Service.ChangePasswordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/password/change")
@Tag(name ="Change password controller")
public class changePasswordController {
    private final ChangePasswordService changePasswordService;

    public changePasswordController(ChangePasswordService changePasswordService) {
        this.changePasswordService = changePasswordService;
    }

    @PostMapping
    public String changePassword(ChangePasswordDto changePasswordDto){
        changePasswordService.changeYourPassword(changePasswordDto);
        return "Password changed successfully";
    }
}
