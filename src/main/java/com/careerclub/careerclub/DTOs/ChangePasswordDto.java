package com.careerclub.careerclub.DTOs;

import com.careerclub.careerclub.Config.WebSecurityConfig;

import javax.persistence.PrePersist;

public class ChangePasswordDto {
    private Long userId;
    private String oldPassword;
    private String newPassword;

    public long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }


    public String encryptPassword(){
        this.newPassword = WebSecurityConfig.passwordEncoder().encode(this.newPassword);
        return this.newPassword;
    }
}
