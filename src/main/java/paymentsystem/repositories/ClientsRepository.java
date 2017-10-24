package paymentsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import paymentsystem.models.Clients;

public interface ClientsRepository  extends JpaRepository<Clients, Integer> {
}
