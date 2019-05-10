package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest implements ModelTest {

    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1l, "Joe", "Buck");

        // then
        assertAll( "Test Props Set",
                () -> assertEquals(person.getFirstName(), "Joe"),
                () -> assertEquals(person.getLastName(), "Buck"));
    }

    @Test
    void groupedAssertionsMsg() {
        // given
        Person person = new Person(1l, "Joe", "Buck");

        // then
        assertAll( "Test Props Set",
                () -> assertEquals(person.getFirstName(), "Joe", "First Name Failed"),
                () -> assertEquals(person.getLastName(), "Buck", "Last Name Failed"));
    }
}