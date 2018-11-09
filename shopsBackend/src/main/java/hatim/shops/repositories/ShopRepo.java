package hatim.shops.repositories;

import hatim.shops.entities.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ShopRepo extends PagingAndSortingRepository<Shop, Integer> {
    public Page<Shop> findAllByIdNotIn(List<Integer> likedShopsIds, Pageable p);
}
