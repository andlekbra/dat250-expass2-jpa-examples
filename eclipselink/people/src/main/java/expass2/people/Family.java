package expass2.people;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String description;

    private final List<Person> members = new ArrayList<Person>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "family")
    public List<Person> getMembers() {
        return members;
    }

}