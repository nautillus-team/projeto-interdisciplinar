package nautillus.models;

import nautillus.enums.AdministrationRoute;
import nautillus.enums.EmployeeType;
import nautillus.enums.Label;
import nautillus.enums.MedicationForm;
import nautillus.enums.MedicationStatus;

public class Pharmaceutical extends Employee {

    private String crf;

    public Pharmaceutical(String name, String cpf, String rg, EmployeeType role, String employeeId, String birthDate,
                          String password, String crf) {
        super(name, cpf, rg, EmployeeType.PHARMACIST, employeeId, birthDate, password);
        setCrf(crf);
    }

    public String getCrf() {
        return this.crf;
    }

    public void setCrf(String crf) {
        if (crf != null && crf.length() == 5 && crf.matches("[0-9]+")) {
            this.crf = crf;
        } else {
            throw new IllegalArgumentException("Digite um CRF valido!");
        }
    }

    public void createRemedy(Medication medication, String name, Label labelColor,
                             MedicationForm pharmaceuticalForm, AdministrationRoute administrationRoute,
                             String anvisaRegistration, boolean selfMedication,
                             MedicationStatus status, int quantity, float price) {
        try {
            medication.setName(name);
            medication.setLabel(labelColor);
            medication.setPharmaceuticalForm(pharmaceuticalForm);
            medication.setAdministrationRoute(administrationRoute);
            medication.setAnvisaRegistration(anvisaRegistration);
            medication.setSelfMedication(selfMedication);
            medication.setStatus(status);
            medication.setQuantity(quantity);
            medication.setPrice(price);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar remedio: " + e.getMessage());
        }
    }

    public void createBatch(Batch batch, int quantity, String manufacturingDate, String expiryDate,
                            int batchNumber, String registrationDate) {
        try {
            batch.setQuantity(quantity);
            batch.setManufacturingDate(manufacturingDate);
            batch.setExpiryDate(expiryDate);
            batch.setBatchNumber(batchNumber);
            batch.setRegistrationDate(registrationDate);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar lote: " + e.getMessage());
        }
    }
}
