package nautillus.testes;

import nautillus.enums.AdministrationRoute;
import nautillus.enums.Label;
import nautillus.enums.PharmForm;
import nautillus.enums.RemedyStatus;
import nautillus.models.Batch;
import nautillus.models.Remedy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BatchTest {

    @Test
    void batchValid() {
        Remedy remedy = new Remedy(
                "Dipirona Monoidratada",
                Label.RED,
                PharmForm.TABLET,
                AdministrationRoute.PO,
                "1234567891234",
                true,
                RemedyStatus.ACTIVE,
                0,
                2.99f
                );

        Batch batch = new Batch(
                remedy,
                12,
                "01/03/2026",
                "01/05/2026",
                1,
                "12/04/2026"
                );

        // Lower-case test
        assertEquals("Dipirona Monoidratada", batch.getRemedy().getName());
    }
}