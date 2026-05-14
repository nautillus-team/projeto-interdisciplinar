package nautillus.testes;

import nautillus.enums.EmployeeType;
import nautillus.models.Pharmaceutical;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PharmaceuticalTest {

    @Test
    void PharmaceuticalValid() {
        Pharmaceutical Jimmy = new Pharmaceutical(
            "Jimmy Silva",
            "12345678901",
            "123456789",
            EmployeeType.PHARMACIST,
            "MAT001",
            "01/01/1990",
            "senha123",
            "12345"
        );

        assertEquals("12345", Jimmy.getCrf());
    }

    @Test
    void  PharmaceuticalInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Pharmaceutical(
            "Jimmy Silva",
            "12345678901",
            "123456789",
            EmployeeType.PHARMACIST,
            "MAT001",
            "01/01/1990",
            "senha123",
            "123"
        ));
    }
}
