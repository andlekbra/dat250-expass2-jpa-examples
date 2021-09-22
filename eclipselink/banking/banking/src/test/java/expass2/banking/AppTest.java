package expass2.banking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static final String PERSISTENCE_UNIT_NAME = "banking";
    private EntityManagerFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Query q = em.createQuery("select m from Person m");

        boolean createNewEntries = (q.getResultList().size() == 0);

        if (createNewEntries) {
            assertTrue(q.getResultList().size() == 0);

            Address address = new Address();
            address.setStreet("Inndalsveien");
            address.setNumber(28);

            PinCode pinCode = new PinCode();
            pinCode.setPincode("123");
            pinCode.setCount(1);

            Bank bank = new Bank();
            bank.setName("Pengebank");

            CreditCard creditCard1 = new CreditCard();
            creditCard1.setNumber(12345);
            creditCard1.setBalance(-5000);
            creditCard1.setLimit(-10000);
            creditCard1.setPin(pinCode);

            CreditCard creditCard2 = new CreditCard();
            creditCard2.setNumber(123);
            creditCard2.setBalance(1);
            creditCard2.setLimit(2000);
            creditCard2.setPin(pinCode);

            creditCard1.setBank(bank);
            creditCard2.setBank(bank);
            bank.getCreditCards().add(creditCard1);
            bank.getCreditCards().add(creditCard2);

            Person person = new Person();
            person.setName("Max Mustermann");
            person.getAddresses().add(address);
            address.getPersons().add(person);
            person.getCreditCards().add(creditCard1);
            person.getCreditCards().add(creditCard2);

            em.persist(person);
            em.persist(address);
            em.persist(creditCard1);
            em.persist(creditCard2);
            em.persist(pinCode);
            em.persist(bank);

            em.getTransaction().commit();

            em.close();

        }
    }

    @Test
    public void checkPerson() {
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("select m from Person m");

        Person person = (Person) q.getResultList().get(0);

        assertEquals(person.getName(), "Max Mustermann");

        assertTrue(q.getResultList().size() == 1);

    }

    @Test
    public void checkPersonAdress() {
        EntityManager em = factory.createEntityManager();

        Query qPerson = em.createQuery("select m from Person m");

        Person person = (Person) qPerson.getResultList().get(0);

        Query qAddress = em.createQuery("select m from Address m");

        assertTrue(qAddress.getResultList().size() == 1);

        Address address = (Address) qAddress.getResultList().get(0);

        assertEquals(person.getAddresses().get(0), address);

        assertEquals(address.getPersons().get(0), person);

    }
}
