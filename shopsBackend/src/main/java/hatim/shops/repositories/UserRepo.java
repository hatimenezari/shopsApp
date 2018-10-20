package hatim.shops.repositories;

import hatim.shops.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepo extends PagingAndSortingRepository<User, Integer> {
}
