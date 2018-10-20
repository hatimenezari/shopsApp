package hatim.shops.services;

import hatim.shops.repositories.PreferredShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreferredShopServices {
    @Autowired
    private PreferredShopRepo preferredShopRepo;


}
