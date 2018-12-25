package hatim.shops.services;

import hatim.shops.entities.Shop;
import hatim.shops.entities.User;
import hatim.shops.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserServices {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    public boolean signin(User user){
        User check = userRepo.findByEmail(user.getEmail());
        if(check != null){
            if(passwordEncoder.matches(user.getPassword(), check.getPassword()))
                return true;
        }
        return false;
    }

    public List<String> getUsers(){
        List<String> users = new ArrayList<>();
        userRepo.findAll().forEach( user -> {
            users.add(user.getEmail());
        });
        return users;
    }

    public User findByEmail(String mail) {
        return userRepo.findByEmail(mail);
    }

    public void updateUser(User user){
        userRepo.save(user);
    }
}
