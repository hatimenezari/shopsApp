package hatim.shops.repositories;

import hatim.shops.entities.Shop;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShopRepo extends PagingAndSortingRepository<Shop, Integer> {
}
