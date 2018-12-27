package hatim.shops.controllers;

import hatim.shops.entities.User;
import hatim.shops.repositories.UserRepo;
import hatim.shops.services.UserServices;
import org.assertj.core.api.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockUserControllerTest {

    @Autowired
    UserRepo userRepo;

    @Mock
    UserServices userServices;


    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void testLoginWithMock(){
        List<String> users  = new ArrayList<>();
        userRepo.findAll().forEach(user -> users.add(user.getEmail()));
        Mockito.when(userServices.getUsers()).thenReturn(users);

        assertTrue(userServices.getUsers().contains("hatim@mail.com") &&
                passwordEncoder.matches("hatim", userRepo.findByEmail("hatim@mail.com").getPassword()));

        assertFalse( userServices.getUsers().contains("wrong.mail@mail.com") &&
                passwordEncoder.matches("hatim", userRepo.findByEmail("wrong.mail@mail.com").getPassword()));

    }


}
