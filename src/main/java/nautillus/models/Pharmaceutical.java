package nautillus.models;

import nautillus.enums.AdministrationRoute;
import nautillus.enums.EmployeeType;
import nautillus.enums.Label;
import nautillus.enums.PharmForm;
import nautillus.enums.RemedyStatus;

public class Pharmaceutical extends Employee {

    private String crf;

    public Pharmaceutical(String name, String cpf, String rg, String employeeId, String birthDate,
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

    public void createRemedy(Remedies remedy, String name, Label labelColor,
                              PharmForm pharmaceuticalForm, AdministrationRoute administrationRoute,
                              String anvisaRegistration, boolean selfMedication,
                              RemedyStatus status, int quantity) {
        try {
            remedy.setName(name);
            remedy.setLabel(labelColor);
            remedy.setPharmaceuticalForm(pharmaceuticalForm);
            remedy.setAdministrationRoute(administrationRoute);
            remedy.setAnvisaRegistration(anvisaRegistration);
            remedy.setSelfMedication(selfMedication);
            remedy.setStatus(status);
            remedy.setQuantity(quantity);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar remedio: " + e.getMessage());
        }
    }

    public void createBatch(Batch batch, float price, String manufacturingDate, String expiryDate,
                            int batchNumber, String registrationDate) {
        try {
            batch.setPrice(price);
            batch.setManufacturingDate(manufacturingDate);
            batch.setExpiryDate(expiryDate);
            batch.setBatchNumber(batchNumber);
            batch.setRegistrationDate(registrationDate);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar lote: " + e.getMessage());
        }
    }
}
