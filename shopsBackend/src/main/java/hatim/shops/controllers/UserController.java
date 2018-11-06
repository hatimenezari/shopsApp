package hatim.shops.controllers;

import hatim.shops.entities.User;
import hatim.shops.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserServices userServices;

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
}