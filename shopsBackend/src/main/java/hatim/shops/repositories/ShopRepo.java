package hatim.shops.repositories;

import hatim.shops.entities.Shop;
import hatim.shops.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ShopRepo extends PagingAndSortingRepository<Shop, Integer> {

    public Page<Shop> findAllByIdNotIn(List<Integer> likedShopsIds, Pageable p);

    /*
        I used native query because the sorting uses a mathematical formula which makes it hard to use a spring data jpa
        query method.
        The coordinates for each shop are stored in the database (Xs, Ys).
        The coordinates for the user come through http (Xu,Yu).
        To calculate the distance I used the formula: sqrt((Xs - Xu)^2 + (Ys- Yu)^2).
        I then sorted the result using those distance values.
        The "not in" part excludes shops that are liked by the user because they do not appear in the main page.
     */
    @Query(value = "SELECT * FROM shopsapp.shop " +
            "Where id not in " +
            "(select shop_id from shopsapp.likedshops where user_id = ?1) order by sqrt(pow(x - ?2,2) + pow(y - ?3,2)) desc"
            , nativeQuery = true)
    public Page<Shop> findAllAndOrderByDistance(int id,double x, double y, Pageable p);

}
