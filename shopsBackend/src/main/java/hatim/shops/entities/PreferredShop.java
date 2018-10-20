package hatim.shops.entities;

import javax.persistence.*;

@Entity
public class PreferredShop {

    @Id
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public PreferredShop() {
    }

    public PreferredShop(int id, Shop shop) {
        this.id = id;
        this.shop = shop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
