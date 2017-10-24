package paymentsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import paymentsystem.models.Card;

public interface CardRepository  extends JpaRepository<Card, Integer> {
}
