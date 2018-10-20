package hatim.shops.controllers;

import hatim.shops.entities.Shop;
import hatim.shops.services.ShopServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    @Autowired
    ShopServices shopServices;

    @RequestMapping("/shops")
    public Page<Shop> getShops(Pageable p){
        return shopServices.getShops(p);
    }
}
