package hatim.shops.controllers;

import hatim.shops.entities.User;
import hatim.shops.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserServices userServices;

    private String mail = "hatim@mail.com";
    private String password = "hatim";

    @RequestMapping(method = RequestMethod.POST, value="/signup")
    public void register(@RequestBody User user){
        userServices.register(user);
    }

    @RequestMapping(method = RequestMethod.POST,value="/signin")
    public ResponseEntity signin(@RequestBody User user){


        if(userServices.signin(user))
            return new ResponseEntity( HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    public boolean isCorrectLogin(String mail){
        if(this.mail.equals(mail))
            return true;
        return false;
    }

    public boolean isCorrectLoginPassword(String mail,String password){
        if(this.mail.equals(mail))
            if(this.password.equals(password))
            return true;
        return false;
    }

    public String getLogin(User user){
        return user.getEmail();
    }
}
