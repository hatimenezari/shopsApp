package hatim.shops.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    private int id;
    private String email;
    private String password;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="likedshops",
            joinColumns = @JoinColumn( name="user_id"),
            inverseJoinColumns = @JoinColumn( name="shop_id")
    )
    List<Shop> shops;

    public User() {
    }

    public User(int id, String email, String password, List<Shop> shops) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.shops = shops;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
