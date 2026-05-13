package nautillus.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import nautillus.enums.AdministrationRoute;
import nautillus.enums.Label;
import nautillus.enums.PharmForm;
import nautillus.enums.RemedyStatus;

public class Batch extends Remedies {

    private float price;
    private LocalDate manufacturingDate;
    private LocalDate expiryDate;
    private int batchNumber;
    private LocalDate registrationDate;

    public Batch(String name, Label labelColor, PharmForm pharmaceuticalForm,
                 AdministrationRoute administrationRoute, String anvisaRegistration,
                 boolean selfMedication, RemedyStatus status, int quantity,
                 float price, String manufacturingDate, String expiryDate,
                 int batchNumber, String registrationDate) {

        super(name, labelColor, pharmaceuticalForm, administrationRoute,
              anvisaRegistration, selfMedication, status, quantity);

        setPrice(price);
        setManufacturingDate(manufacturingDate);
        setExpiryDate(expiryDate);
        setBatchNumber(batchNumber);
        setRegistrationDate(registrationDate);
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Preco invalido! O valor nao pode ser negativo.");
        }
    }

    public LocalDate getManufacturingDate() {
        return this.manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        try {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(manufacturingDate, formatador);

            if (!data.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("Data de fabricacao deve ser anterior a data atual.");
            }
            this.manufacturingDate = data;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de data invalido! Use dd/MM/yyyy.");
        }
    }

    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        try {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(expiryDate, formatador);

            if (this.manufacturingDate != null && !data.isAfter(this.manufacturingDate)) {
                throw new IllegalArgumentException("Data de validade deve ser maior que a data de fabricacao.");
            }
            this.expiryDate = data;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de data invalido! Use dd/MM/yyyy.");
        }
    }

    public int getBatchNumber() {
        return this.batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        if (batchNumber > 0) {
            this.batchNumber = batchNumber;
        } else {
            throw new IllegalArgumentException("Numero de lote invalido!");
        }
    }

    public LocalDate getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        try {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(registrationDate, formatador);

            if (!data.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("Data de cadastro deve ser anterior a data atual.");
            }
            this.registrationDate = data;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de data invalido! Use dd/MM/yyyy.");
        }
    }
}
