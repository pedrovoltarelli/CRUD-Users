package com.pedrooomv.crud_usuarios.controller;

import com.pedrooomv.crud_usuarios.entity.User;
import com.pedrooomv.crud_usuarios.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    UserRepository repository;

    public void cadastrarUser(User user){
        repository.save(user);
    }

    public void lerUser(Long id){
        repository.findById(id);
    }

    public void atualizarUser(User user){
        repository.save(user);
    }

    public void deletarUser(Long id){
        repository.deleteById(id);
    }
}
