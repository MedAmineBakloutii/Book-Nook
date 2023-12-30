package net.javaguides.bibliotheque.Service;

import net.javaguides.bibliotheque.Model.User;
import net.javaguides.bibliotheque.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userrepository;

    public Long createUser(User user){
        return  userrepository.save(user).getIdUser();
    }

    public User getUser(Long id){
        return userrepository.findById(id).orElse(null);
    }

    public List<User> getUsers(){
        return userrepository.findAll().stream().sorted().collect(Collectors.toList());
    }

    public void deleteByid(Long id){
        userrepository.deleteById(id);
    }


}
