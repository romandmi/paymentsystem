package paymentsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import paymentsystem.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
