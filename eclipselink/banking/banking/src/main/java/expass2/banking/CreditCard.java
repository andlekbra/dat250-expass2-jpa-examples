package expass2.banking;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int number;
    private int limit;
    private int balance;
    private PinCode pin;
    @ManyToOne
    private Bank bank;
}
