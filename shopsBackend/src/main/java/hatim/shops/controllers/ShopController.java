package hatim.shops.controllers;

import hatim.shops.entities.Coordinates;
import hatim.shops.entities.Shop;
import hatim.shops.entities.User;
import hatim.shops.services.ShopServices;
import hatim.shops.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@CrossOrigin("*")
public class ShopController {

    @Autowired
    ShopServices shopServices;

    private String getMail(HttpHeaders headers){
        String authorisation = headers.get("Authorization").toString();
        String base64 = authorisation.substring(7,authorisation.length() - 1);
        String[] credentials = new String(Base64.getDecoder().decode(base64)).split(":");
        return credentials[0];
    }

    private Coordinates getCoords(HttpHeaders headers){
        Coordinates coords = new Coordinates();
        String locationb64 = headers.get("Location").toString();
        locationb64 = locationb64.substring(1, locationb64.length()-1);
        String[] location = new String(Base64.getDecoder().decode(locationb64)).split(":");
        coords.setY(Double.valueOf(location[0]));
        coords.setX(Double.valueOf(location[1]));
        return coords;
    }


    @RequestMapping("/shops")
    public Page<Shop> getShops(Pageable p, @RequestHeader HttpHeaders headers){
        String mail = getMail(headers);
        Coordinates coords = getCoords(headers);
        return shopServices.getShops(p, mail,coords);
    }

    @RequestMapping("/likedShops")
    public Page<Shop> getLikedShops(Pageable p, @RequestHeader HttpHeaders headers){
        String mail = getMail(headers);
        return shopServices.getLikedShops(p, mail);
    }

    @RequestMapping("/nearShops")
    public Page<Shop> getNearShops(Pageable p, @RequestHeader HttpHeaders headers){
        String mail = getMail(headers);
        Coordinates coords = getCoords(headers);
        return shopServices.getNearShops(p, mail, coords);
    }


    @RequestMapping(method = RequestMethod.POST,value="/addLikedShop")
    public void addLikedShop(@RequestBody Shop shop, @RequestHeader HttpHeaders headers){
        String mail = getMail(headers);
        shopServices.addLikedShop(shop, mail);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/removeLikedShop/{id}")
    public void removeLikedShop(@PathVariable int id, @RequestHeader HttpHeaders headers){
        String mail = getMail(headers);
        shopServices.removeLikedShop(id, mail);
    }
}
