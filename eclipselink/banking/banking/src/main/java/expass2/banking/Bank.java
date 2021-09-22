package expass2.banking;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Data
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "bank")
    private List<CreditCard> creditCards = new ArrayList<CreditCard>();
}
