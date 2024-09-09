package com.example.crud.service;

import com.example.crud.entity.User;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user){
        return repository.save(user);
    }

    public List<User> getUsers(){
        return repository.findAll();
    }

    public User getUserByID(Long id){
        return repository.findById(id).orElse(null);
    }

    public String deleteByID(Long id){
        repository.deleteById(id);
        return "Usuário deletado com sucesso!";
    }

    public User updateUser(User user){
        User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setCpf(user.getCpf());
        existingUser.setName(user.getName());
        existingUser.setNumero(user.getNumero());
        return repository.save(existingUser);
    }
}
