package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerTest implements ModelTest {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("Key Largo");
        owner.setTelephone("123456789");

        assertAll( "Properties Test",
                () -> {
                    assertAll("Person Properties",
                            () -> assertEquals("Joe", owner.getFirstName()),
                            () -> assertEquals("Buck", owner.getLastName())
                    );
                },
                () -> {
                    assertAll("Owner Properties",
                            () -> assertEquals("Key Largo", owner.getCity()),
                            () -> assertEquals("123456789", owner.getTelephone())
                    );
                });

        assertThat(owner.getCity(), is("Key Largo"));
    }
}