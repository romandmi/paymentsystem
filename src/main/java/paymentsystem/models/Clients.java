package paymentsystem.models;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String firstName;

    @Column(length = 30)
    private String lastName;

    @Column(length = 30)
    private String surname;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "user_id")
    private User user;

    @OneToMany (mappedBy = "client",cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private Set<Card> cards;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurname() {
        return surname;
    }

    public User getUser() {
        return user;
    }

    public Set<Card> getCards() {
        return cards;
    }
}
