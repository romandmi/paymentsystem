package paymentsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import paymentsystem.models.BankAccount;

public interface BankAccountRepository  extends JpaRepository<BankAccount, Integer> {
}
