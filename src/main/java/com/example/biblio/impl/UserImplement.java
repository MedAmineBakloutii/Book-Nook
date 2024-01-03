package com.example.biblio.impl;



import com.example.biblio.Model.User;
import com.example.biblio.Repository.UserRepository;
import com.example.biblio.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service

public class UserImplement implements UserService {


    @Autowired
    private UserRepository userrepository;

    @Override
    public Long createUser(User user){
        return  userrepository.save(user).getIdUser();
    }
    @Override
    public User getUser(Long id){
        return userrepository.findById(id).orElse(null);
    }
    @Override
    public List<User> getUsers(){
        return userrepository.findAll().stream().sorted().collect(Collectors.toList());
    }

    @Override
    public void deleteByid(Long id){
        userrepository.deleteById(id);
    }


    @Override
    public User getOneUserById(int id) {
        return this.userrepository.findById((long) id).orElse(null);
    }

}
