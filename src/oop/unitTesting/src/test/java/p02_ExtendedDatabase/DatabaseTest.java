package oop.unitTesting.src.test.java.p02_ExtendedDatabase;

import oop.unitTesting.src.main.java.p02_ExtendedDatabase.Database;
import oop.unitTesting.src.main.java.p02_ExtendedDatabase.Person;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Person[] persons;
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.persons = new Person[]{new Person(1, "Vladimir"), new Person(2, "Stilian"), new Person(1, "Vladimir")};
        this.database = new Database(persons);
    }

    @Test
    public void test_Constructor_SuccessfullyCreateDb() throws OperationNotSupportedException {
        this.persons = new Person[]{new Person(1, "Vladimir"), new Person(2, "Stilian")};
        this.database = new Database(persons);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Constructor_WithLessThan_1_Elements_ShouldThrow() throws OperationNotSupportedException {
        new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Constructor_WithMoreThan_16_Elements_ShouldThrow() throws OperationNotSupportedException {
        Person[] persons = new Person[17];
        new Database(persons);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Add_NullPerson_ShouldThrow() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void test_Add_Successfully() throws OperationNotSupportedException {
        this.database.add(new Person(3, "Magdalena"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Remove_ShouldThrow() throws OperationNotSupportedException {
        for (int i = 0; i < persons.length; i++) {
            this.database.remove();
        }

        this.database.remove();
    }

    @Test
    public void test_getElements() {
        Person[] expectedPersons = this.database.getElements();

        assertArrayEquals(expectedPersons, persons);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByUsername_NullString_ShouldThrow() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByUsername_DoesNotReturn_1Person_ShouldThrow() throws OperationNotSupportedException {
        database.findByUsername("Vladimir");
    }

    @Test
    public void test_FindByUsername_Successfully() throws OperationNotSupportedException {
        Person expectedPerson = database.findByUsername("Stilian");

        assertEquals("Stilian", expectedPerson.getUsername());
        assertEquals(2, expectedPerson.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_FindById_DoesNotReturn_1Person_ShouldThrow() throws OperationNotSupportedException {
        database.findById(1);
    }

    @Test
    public void test_FindById_Successfully() throws OperationNotSupportedException {
        Person expectedPerson = database.findById(2);

        assertEquals("Stilian", expectedPerson.getUsername());
        assertEquals(2, expectedPerson.getId());
    }
}