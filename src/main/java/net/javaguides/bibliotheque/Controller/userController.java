package net.javaguides.bibliotheque.Controller;

import lombok.RequiredArgsConstructor;
import net.javaguides.bibliotheque.Model.User;
import net.javaguides.bibliotheque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class userController {

    @Autowired
    private UserService userservice;


    @PostMapping
    public Long saveUser(@RequestBody User userRequest) {
        return userservice.createUser(userRequest);
    }

}
