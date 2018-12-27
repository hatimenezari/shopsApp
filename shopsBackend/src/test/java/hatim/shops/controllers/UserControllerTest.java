package hatim.shops.controllers;

import hatim.shops.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    UserController userController;

    @Test
    public void signin() {
    }

    @Test
    public void isCorrectLogin() {
        assertEquals(true, userController.isCorrectLogin("hatim@mail.com"));
        assertEquals(false, userController.isCorrectLogin("sth"));
    }

    @Test
    public void isCorrectLoginPassword() {
        assertEquals(true, userController.isCorrectLoginPassword("hatim@mail.com", "hatim"));
        assertEquals(false, userController.isCorrectLoginPassword("sth", "sth"));
    }

    @Test
    public void getLogin(){
        assertEquals("hatim@mail.com", userController.getLogin(new User("hatim@mail.com","hatim")));
    }



}
