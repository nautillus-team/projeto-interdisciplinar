package nautillus.testes;

import nautillus.enums.EmployeeType;
import nautillus.enums.NurseType;
import nautillus.models.Nurse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NurseTest {

    @Test
    public void nurseValid() {
        Nurse Jimmy = new Nurse(
            "Jimmy Silva",
            "12345678901",
            "123456789",
            EmployeeType.NURSE,
            "MAT001",
            "01/01/1990",
            "senha123",
            "123456",
            NurseType.AUX
        );

        assertEquals("123456", Jimmy.getCoren());
    }



    @Test
    public void nurseInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Nurse(
            "Jimmy Silva",
            "12345678901",
            "123456789",
            EmployeeType.NURSE,
            "MAT001",
            "01/01/1990",
            "senha123",
            "12",
            NurseType.AUX
        ));

    }
}
