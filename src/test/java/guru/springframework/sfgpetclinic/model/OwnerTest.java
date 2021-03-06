package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

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
    }
}