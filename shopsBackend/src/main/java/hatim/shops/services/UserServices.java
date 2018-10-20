package hatim.shops.services;

import hatim.shops.entities.User;
import hatim.shops.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepo userRepo;


}
