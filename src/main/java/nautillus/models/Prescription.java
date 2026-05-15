package nautillus.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// TODO: Refatorar isso daqui pra aceitar apenas uma entidade remédio
public class Prescription extends Remedy {

    private LocalDate startDate;
    private LocalDate EndDate;
    private String observation;
    private float dosage;

    public Prescription(String startdate, String endDate, String observation,
                        float dosage, String name) {

        super(name);

        setStartdate(startdate);
        setEndDate(endDate);
        setObservation(observation);
        setDosage(dosage);
    }

    public LocalDate getStartdate() {
        return this.startDate;
    }

    public LocalDate setStartdate(String startDate) {
        try {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(startDate, formatador);

            if (!date.isAfter(LocalDate.now())) {
                return this.startDate = date;
            } else {
                throw new IllegalArgumentException("Data de inicio invalida!");
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }catch (Exception e) {
            throw new IllegalArgumentException("Data de inicio invalida!");
        }
    }

    public LocalDate getEndDate() {
        return this.EndDate;
    }

    public void setEndDate(String endDate) {
        try {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(endDate, formatador);

            if (!date.isBefore(LocalDate.now())) {
                this.EndDate = date;
            } else {
                throw new IllegalArgumentException("Data de fim invalida!");
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }catch (Exception e) {
            throw new IllegalArgumentException("Data de fim invalida!");
        }
    }

    public String getObservation() {
        return this.observation;
    }

    public void setObservation(String observation) {
        if (observation != null && observation.length() <= 255) {
            this.observation = observation;
        } else {
            throw new IllegalArgumentException("Observacao invalida! Maximo de 255 caracteres.");
        }
    }

    public float getDosage() {
        return this.dosage;
    }

    public void setDosage(float dosage) {
        if (dosage >= 0) {
            this.dosage = dosage;
        } else {
            throw new IllegalArgumentException("Dosagem invalida! O valor nao pode ser negativo.");
        }
    }
}
