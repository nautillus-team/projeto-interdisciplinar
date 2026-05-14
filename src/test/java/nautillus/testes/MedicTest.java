package nautillus.testes;

import nautillus.enums.EmployeeType;
import nautillus.enums.MedicalSpecialty;
import nautillus.models.Medic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedicTest {

    @Test
    void medicValid() {
        Medic Jimmy = new Medic(
            "Jimmy Silva",
            "12345678901",
            "123456789",
            EmployeeType.DOCTOR,
            "MAT001",
            "01/01/1990",
            "senha123",
            "123456789",
            10,
            MedicalSpecialty.CARDIOLOGY
        );

        assertEquals("123456789", Jimmy.getCrm());
        assertEquals(10, Jimmy.getOffice());
        assertEquals(MedicalSpecialty.CARDIOLOGY, Jimmy.getSpecialty());
    }

    @Test
    void medicInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Medic(
                "Jimmy Silva",
                "12345678901",
                "123456789",
                EmployeeType.DOCTOR,
                "MAT001",
                "01/01/1990",
                "senha123",
                "1",
                10,
                MedicalSpecialty.CARDIOLOGY
        ));
    }
}
