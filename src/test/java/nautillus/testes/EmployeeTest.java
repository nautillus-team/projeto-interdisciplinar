package nautillus.testes;

import nautillus.models.Employee;
import nautillus.enums.EmployeeType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    void employeeValid() {
        Employee jimmy = new Employee(
                "Jimmy Silva",
                "12345678901",
                "123456789",
                EmployeeType.DOCTOR,
                "MAT001",
                "01/01/1990",
                "senha123"
        );

        assertEquals("Jimmy Silva", jimmy.getName());
        assertEquals("12345678901", jimmy.getCpf());
        assertEquals("123456789", jimmy.getRg());
        assertEquals("01/01/1990", jimmy.getBirthDate());
        assertEquals("MAT001", jimmy.getEmployeeId());
        assertTrue(jimmy.verifyPassword("senha123"));
        assertFalse(jimmy.verifyPassword("senhaErrada"));
    }

    @Test
    void employeeInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Employee(
                "Jimmy Silva",
                "12345678901",
                "123456789",
                EmployeeType.DOCTOR,
                "MAT001",
                "01/01/1990",
                "s"
        ));
    }
}
