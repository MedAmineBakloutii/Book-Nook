package com.example.biblio.Service;



import com.example.biblio.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    Long createUser(User user);

    User getUser(Long id);

    List<User> getUsers();

    void deleteByid(Long id);

    User getOneUserById(int id);

}
