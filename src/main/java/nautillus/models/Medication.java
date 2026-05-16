package nautillus.models;

import nautillus.enums.AdministrationRoute;
import nautillus.enums.Label;
import nautillus.enums.MedicationForm;
import nautillus.enums.MedicationStatus;

public class Medication {

    private String name;
    private Label labelColor;
    private MedicationForm pharmaceuticalForm;
    private AdministrationRoute administrationRoute;
    private String anvisaRegistration;
    private boolean selfMedication;
    private MedicationStatus status;
    private int quantity;
    private float price;

    public Medication(String name) {
        setName(name);
    }

    public Medication(String name, Label labelColor, MedicationForm pharmaceuticalForm,
                      AdministrationRoute administrationRoute, String anvisaRegistration,
                      boolean selfMedication, MedicationStatus status, int quantity, float price) {
        setName(name);
        setLabel(labelColor);
        setPharmaceuticalForm(pharmaceuticalForm);
        setAdministrationRoute(administrationRoute);
        setAnvisaRegistration(anvisaRegistration);
        setSelfMedication(selfMedication);
        setStatus(status);
        setQuantity(quantity);
        setPrice(price);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name != null && name.replace(" ", "").matches("[a-zA-ZÀ-ÿ]+")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Nome invalido! Use apenas letras.");
        }
    }

    public Label getLabel() {
        return this.labelColor;
    }

    public void setLabel(Label labelColor) {
        if (labelColor == null) throw new IllegalArgumentException("Tarja invalida!");
        this.labelColor = labelColor;
    }

    public MedicationForm getPharmaceuticalForm() {
        return this.pharmaceuticalForm;
    }

    public void setPharmaceuticalForm(MedicationForm pharmaceuticalForm) {
        if (pharmaceuticalForm == null) throw new IllegalArgumentException("Forma farmaceutica invalida!");
        this.pharmaceuticalForm = pharmaceuticalForm;
    }

    public AdministrationRoute getAdministrationRoute() {
        return this.administrationRoute;
    }

    public void setAdministrationRoute(AdministrationRoute administrationRoute) {
        if (administrationRoute == null) throw new IllegalArgumentException("Via de administracao invalida!");
        this.administrationRoute = administrationRoute;
    }

    public String getAnvisaRegistration() {
        return this.anvisaRegistration;
    }

    public void setAnvisaRegistration(String anvisaRegistration) {
        if (anvisaRegistration != null && anvisaRegistration.matches("[0-9]+") && anvisaRegistration.length() == 13) {
            this.anvisaRegistration = anvisaRegistration;
        } else {
            throw new IllegalArgumentException("Registro ANVISA invalido! Deve conter 13 digitos.");
        }
    }

    public boolean isSelfMedication() {
        return this.selfMedication;
    }

    public void setSelfMedication(boolean selfMedication) {
        this.selfMedication = selfMedication;
    }

    public MedicationStatus getStatus() {
        return this.status;
    }

    public void setStatus(MedicationStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Status invalido!");
        }
        this.status = status;
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
}