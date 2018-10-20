package hatim.shops.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Shop {

    @Id
    private int id;
    private String name;
    /*
        Using String to store a picture
        because pictures are gonna be stored in base64 encoding
        to make sending through http easier
     */
    @Lob
    @Column(columnDefinition="LONGTEXT")
    private String picture;

    public Shop() {
    }

    public Shop(int id, String name, String picture) {
        this.id = id;
        this.name = name;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
