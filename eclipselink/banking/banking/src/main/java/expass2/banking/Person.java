package expass2.banking;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany()
    private List<Address> addresses = new ArrayList<Address>();
    private List<CreditCard> creditCards = new ArrayList<CreditCard>();
}
