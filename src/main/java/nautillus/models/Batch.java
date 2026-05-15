package nautillus.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Batch {

    private final Remedy remedy;
    private int quantity;
    private LocalDate manufacturingDate;
    private LocalDate expiryDate;
    private int batchNumber;
    private LocalDate registrationDate;

    public Batch(Remedy remedy, int quantity,
                 String manufacturingDate, String expiryDate,
                 int batchNumber, String registrationDate) {
        this.remedy = remedy;
        setQuantity(quantity);
        setManufacturingDate(manufacturingDate);
        setExpiryDate(expiryDate);
        setBatchNumber(batchNumber);
        setRegistrationDate(registrationDate);
    }

    public Remedy getRemedy() {
        return this.remedy;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("Quantidade nao pode ser negativa!");
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

    public float getBatchPrice() {
        return this.remedy.getPrice() * this.quantity;
    }
}
