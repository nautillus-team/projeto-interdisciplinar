package nautillus.testes;

import nautillus.models.RegiForm;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegiFormTest {

    @Test
    void regiFormValid() {
        RegiForm Jimmy = new RegiForm(
            1,
            "adsdsdssadsds",
            "Jimmy Silva",
            "12345678901",
            "123456789",
            "01/01/1990",
            "123456789101112"
        );

        assertEquals("Jimmy Silva", Jimmy.getName());
        assertEquals("12345678901", Jimmy.getCpf());
        assertEquals("123456789", Jimmy.getRg());
        assertEquals("01/01/1990", Jimmy.getBirthDate());
        assertEquals("123456789101112", Jimmy.getSusCard());
        assertEquals(36, Jimmy.getAge());
    }

    @Test
    void regiFormInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new RegiForm(
            1,
            "adsdsdssadsds",
            "Jimmy Silva",
            "12345678901",
            "123456789",
            "01/01/1990",
            "101112"
        ));
    }
}
