package paymentsystem.models;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (length = 16)
    private String cardNumber;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "account_id")
    private BankAccount bankAccount;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "client_id")
    private Clients client;

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return cardNumber;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public Clients getClient() {
        return client;
    }
}
