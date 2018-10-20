package hatim.shops.services;

import hatim.shops.entities.Shop;
import hatim.shops.repositories.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShopServices {
    @Autowired
    private ShopRepo shopRepo;

    public Page<Shop> getShops(Pageable p){
        return shopRepo.findAll(p);
    }
}
