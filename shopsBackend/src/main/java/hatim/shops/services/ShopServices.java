package hatim.shops.services;

import hatim.shops.entities.Shop;
import hatim.shops.entities.User;
import hatim.shops.repositories.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServices {
    @Autowired
    private ShopRepo shopRepo;

    @Autowired
    private UserServices userServices;

    /*
        First we have to get the user through the mail sent in the http header
        we then get the list of already liked shops and store their ids in a list
        that list gets passed to the repo function that does the not in query to get the 'not liked' shops
     */
    public Page<Shop> getShops(Pageable p, String mail) {
        User user = userServices.findByEmail(mail);
        List<Integer> likedShopsIds = new ArrayList<>();
        user.getShops().forEach((Shop s) -> likedShopsIds.add(s.getId()));
        return shopRepo.findAllByIdNotIn(likedShopsIds, p);
    }

    /*
    similarly we start by getting the user
    we add the shop to his liked shops list
    then we update the user which just adds another liked shop to the likedShops table
     */
    public void addLikedShop(Shop shop, String mail) {
        User user = userServices.findByEmail(mail);
        List<Shop> likedShops = user.getShops();
        likedShops.add(shop);
        user.setShops(likedShops);
        userServices.updateUser(user);
    }
}
