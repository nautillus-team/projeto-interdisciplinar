package nautillus.testes;

import nautillus.models.Patient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {

    @Test
    void patientValid() {
        Patient Jimmy = new Patient(
                1,
                "adsdsdssadsds"
        );

        assertEquals("adsdsdssadsds", Jimmy.getTriage());
    }

    @Test
    void patientInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Patient(
                1,
                ""
        ));
    }
}
