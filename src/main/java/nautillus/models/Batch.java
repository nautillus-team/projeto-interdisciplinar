package nautillus.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long batchId;

    private int medicationQuantity;

    @ManyToOne
    @JoinColumn(name = "medication_id")
    private Medication medication;

    // Setters
    public void setMedication(Medication medication)    { this.medication = medication; }
    public void setMedicationQuantity(int quantity)     { this.medicationQuantity = quantity; }
    public void setBatchId(long batchId)                { this.batchId = batchId; }

    // Getters
    public long getBatchId()                            { return batchId; }
    public int getMedicationQuantity()                  { return medicationQuantity; }
    public Medication getMedication()                   { return medication; }
}
