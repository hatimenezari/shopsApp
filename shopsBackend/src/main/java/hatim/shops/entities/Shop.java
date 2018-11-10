package hatim.shops.entities;

import javax.persistence.*;

@Entity
public class Shop {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    /*
        Using String to store a picture
        because pictures are gonna be stored in a base64 encoding
        to make sending through http easier
     */
    @Lob
    @Column(columnDefinition="LONGTEXT")
    private String picture;
    private Coordinates coordinates;

    public Shop() {
    }

    public Shop(String name, String picture, Coordinates coordinates) {
        this.name = name;
        this.picture = picture;
        this.coordinates = coordinates;
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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
