package com.pedrooomv.crud_usuarios.controller;

import com.pedrooomv.crud_usuarios.request.LoginRequest;
import com.pedrooomv.crud_usuarios.security.JwtSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtSecurity security;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        if("admin".equals(request.getUsername()) && "1234".equals(request.getPassword())){
            return security.gerarToken(request.getUsername());
        }
        throw new RuntimeException("Invalid username and password");
    }
}
