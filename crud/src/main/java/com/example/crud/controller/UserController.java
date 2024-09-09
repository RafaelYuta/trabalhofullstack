package com.example.crud.controller;

import com.example.crud.entity.User;
import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/adicionar")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> findUsers(){
        return service.getUsers();
    }

    @GetMapping("/{id}")
    public User findUserByID(@PathVariable Long id){
        return service.getUserByID(id);
    }

    @PutMapping("/update")
    public User updateById(@PathVariable User user){
        return service.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        service.deleteByID(id);
        return "User deleted successfully";
    }
}
