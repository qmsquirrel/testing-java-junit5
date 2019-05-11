package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

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


    @DisplayName("Value Source Test")
    @ParameterizedTest(name ="{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String val) {
        System.out.println(val);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name ="{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {

        System.out.println(ownerType);

    }

    @DisplayName("CSV Input Test")
    @ParameterizedTest(name ="{displayName} - [{index}] {arguments}")
    @CsvSource({
            "FL, 1, 1",
            "OH, 2, 2",
            "MI, 1, 2"
    })
    void csvInputTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2 );
    }
}