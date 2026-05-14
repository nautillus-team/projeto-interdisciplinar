package nautillus.testes;

import nautillus.enums.AdministrationRoute;
import nautillus.enums.Label;
import nautillus.enums.PharmForm;
import nautillus.enums.RemedyStatus;
import nautillus.models.Remedies;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RemediesTest {
    @Test
    void remediesValid() {
        Remedies Jimmy = new Remedies(
            "Jimmyrona",
            Label.RED,
            PharmForm.INJECTABLE,
            AdministrationRoute.PO,
            "1234567891011",
            true,
            RemedyStatus.INACTIVE,
            1000
        );

        assertEquals("Jimmyrona", Jimmy.getName());
        assertEquals("1234567891011", Jimmy.getAnvisaRegistration());
        assertEquals(1000, Jimmy.getQuantity());
    }

    void remediesInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Remedies(
            "Jimmyrona",
            Label.RED,
            PharmForm.INJECTABLE,
            AdministrationRoute.PO,
            "1234567891011",
            true,
            RemedyStatus.INACTIVE,
            -1
        ));
    }

}
