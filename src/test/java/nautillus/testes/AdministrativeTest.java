package nautillus.testes;

import nautillus.enums.EmployeeType;
import nautillus.models.Administrative;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdministrativeTest {

    @Test
    void administrativeValid() {
        Administrative jimmy = new Administrative(
            "jimmy Silva",
            "12345678901",
            "123456789",
            EmployeeType.DOCTOR,
            "MAT001",
            "01/01/1990",
            "senha123",
            10000
        );

        assertEquals(10000, jimmy.getBudget());
    }

    @Test
    void administrativeInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Administrative(
            "jimmy Silva",
            "12345678901",
            "123456789",
            EmployeeType.DOCTOR,
            "MAT001",
            "01/01/1990",
            "senha123",
            -1
        ));
    }
}
