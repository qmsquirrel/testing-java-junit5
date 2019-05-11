package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
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

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My repeated test")
    @Test
    void myRepeatedTest() {
        //to-do impl
    }
}