package nautillus.testes;

import nautillus.enums.AdministrationRoute;
import nautillus.enums.Label;
import nautillus.enums.PharmForm;
import nautillus.enums.RemedyStatus;
import nautillus.models.Batch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BatchTest {

    @Test
    void batchValid() {
        Batch batch = new Batch(
                "Dipirona Monoidratada",
                Label.RED,
                PharmForm.TABLET,
                AdministrationRoute.PO,
                "1234567891234",
                true,
                RemedyStatus.ACTIVE,
                12,
                2.99f,
                "01/03/2026",
                "01/05/2026",
                1,
                "12/04/2026"
                );

        // Lower case test
        assertEquals("Dipirona Monoidratada", batch.getName());
    }
}

