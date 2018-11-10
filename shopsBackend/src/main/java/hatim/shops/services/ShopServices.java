package hatim.shops.services;

import hatim.shops.entities.Coordinates;
import hatim.shops.entities.Shop;
import hatim.shops.entities.User;
import hatim.shops.repositories.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
    public Page<Shop> getShops(Pageable p, String mail, Coordinates coords) {
        User user = userServices.findByEmail(mail);
        List<Integer> likedShopsIds = new ArrayList<>();
        user.getShops().forEach((Shop s) -> likedShopsIds.add(s.getId()));
        return shopRepo.findAllByIdNotIn(likedShopsIds, p);
    }


    public Page<Shop> getNearShops(Pageable p,String mail, Coordinates coords){
        User user = userServices.findByEmail(mail);
        return shopRepo.findAllAndOrderByDistance(user.getId(), coords.getX(), coords.getY(), p);
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

    /*
        Since the liked shops are accessible through the user object
        we have to convert the list into the page the user wants
        this solution uses the pageImpl<> constructor along with sublist.
        Since sublist is used we have to check if the end of the page is still within the list bounds.
     */
    public Page<Shop> getLikedShops(Pageable p, String mail) {
        User user = userServices.findByEmail(mail);
        List<Shop> likedShops = user.getShops();
        int start = (int) p.getOffset();
        int end =(start + p.getPageSize() > likedShops.size())? likedShops.size (): (int) p.getOffset() + p.getPageSize();
        Page<Shop> page = new PageImpl<>(user.getShops().subList(start,end), p , user.getShops().size());

        return page;
    }

    public void removeLikedShop(int id, String mail) {
        User user = userServices.findByEmail(mail);
        List<Shop> likedShops = user.getShops();
        for(int i=0; i<likedShops.size(); i++){
            if(likedShops.get(i).getId() == id)
                likedShops.remove(i);
        }
        userServices.updateUser(user);
    }
}
