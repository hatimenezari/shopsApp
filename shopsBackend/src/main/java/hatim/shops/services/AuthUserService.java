package hatim.shops.services;

import hatim.shops.entities.User;
import hatim.shops.repositories.UserRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class AuthUserService implements UserDetailsService {


    public UserRepo rep;

    public AuthUserService(UserRepo rep) {
        this.rep = rep;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = rep.findByEmail(s);
        if(user != null){
            List<GrantedAuthority> authorities =
                    new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    authorities);
        }

        throw new UsernameNotFoundException(
                "User '" + s + "' not found.");
    }
}
