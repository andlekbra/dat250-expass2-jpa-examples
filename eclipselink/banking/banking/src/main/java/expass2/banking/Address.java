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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street;
    private int number;
    @ManyToMany(mappedBy = "addresses")
    private List<Person> persons = new ArrayList<Person>();
}
