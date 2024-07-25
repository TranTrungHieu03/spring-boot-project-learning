package com.hieutt03.springboot.mydemowebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        boolean isValidUserName = username.equalsIgnoreCase("hieu");
        boolean isValidPassword = password.equalsIgnoreCase("111");
        return isValidUserName && isValidPassword;
    }
}
