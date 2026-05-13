package nautillus.models;

import nautillus.enums.EmployeeType;
import nautillus.enums.NurseType;

public class Nurse extends Employee {

    private String coren;
    private NurseType category;

    public Nurse(String name, String cpf, String rg, String employeeId, String birthDate,
                 String password, String coren, NurseType category) {
        super(name, cpf, rg, EmployeeType.NURSE, employeeId, birthDate, password);
        setCoren(coren);
        setCategory(category);
    }

    public String getCoren() {
        return this.coren;
    }

    public void setCoren(String coren) {
        if (coren != null && coren.length() == 6 && coren.matches("[0-9]+")) {
            this.coren = coren;
        } else {
            throw new IllegalArgumentException("COREN invalido! Deve conter 6 digitos.");
        }
    }

    public NurseType getCategory() {
        return this.category;
    }

    public void setCategory(NurseType category) {
        if (category == null) {
            throw new IllegalArgumentException("Categoria invalida!");
        }
        this.category = category;
    }
}
