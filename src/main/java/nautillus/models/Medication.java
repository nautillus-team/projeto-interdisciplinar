package nautillus.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long medicationId;

    private String medicationName;

    // Setters
    public void setMedicationId(long medicationId)          { this.medicationId = medicationId; }
    public void setMedicationName(String medicationName)    { this.medicationName = medicationName; }

    // Getters
    public long getMedicationId()                           { return medicationId; }
    public String getMedicationName()                       { return medicationName; }
}
