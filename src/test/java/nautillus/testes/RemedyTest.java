package nautillus.testes;

import nautillus.enums.AdministrationRoute;
import nautillus.enums.Label;
import nautillus.enums.PharmForm;
import nautillus.enums.RemedyStatus;
import nautillus.models.Remedy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RemedyTest {
    @Test
    void remediesValid() {
        Remedy Jimmy = new Remedy(
            "Jimmyrona",
            Label.RED,
            PharmForm.INJECTABLE,
            AdministrationRoute.PO,
            "1234567891011",
            true,
            RemedyStatus.INACTIVE,
            1000,
            8f
        );

        assertEquals("Jimmyrona", Jimmy.getName());
        assertEquals("1234567891011", Jimmy.getAnvisaRegistration());
        assertEquals(1000, Jimmy.getQuantity());
    }

    @Test
    void remediesInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Remedy(
            "Jimmyrona",
            Label.RED,
            PharmForm.INJECTABLE,
            AdministrationRoute.PO,
            "1234567891011",
            true,
            RemedyStatus.INACTIVE,
            -1,
            8f
        ));
    }

}
