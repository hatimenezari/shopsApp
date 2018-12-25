package hatim.shops.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;
    @Column(unique=true)
    private String email;
    private String password;
    /*
        Join table is preferable to foreign key
        to avoid duplications in database
    */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="likedshops",
            joinColumns = @JoinColumn( name="user_id"),
            inverseJoinColumns = @JoinColumn( name="shop_id")
    )
    List<Shop> shops;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="dislikedshops",
            joinColumns = @JoinColumn( name="user_id"),
            inverseJoinColumns = @JoinColumn( name="shop_id")
    )
    List<Shop> dislikedShops;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, List<Shop> shops, List<Shop> dislikedShops) {
        this.email = email;
        this.password = password;
        this.shops = shops;
        this.dislikedShops = dislikedShops;
    }

    public List<Shop> getDislikedShops() {
        return dislikedShops;
    }

    public void setDislikedShops(List<Shop> dislikedShops) {
        this.dislikedShops = dislikedShops;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}

