package com.example.zadaniesi.Dto;

import jakarta.validation.constraints.Email;

public class EmailUpdateDto {
    @Email
    private String email;



    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}