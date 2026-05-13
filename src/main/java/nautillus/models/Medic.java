package nautillus.models;

import nautillus.enums.EmployeeType;
import nautillus.enums.MedicalSpecialty;

public class Medic extends Employee {

    private String crm;
    private int office;
    private MedicalSpecialty specialty;

    public Medic(String name, String cpf, String rg, String employeeId, String birthDate,
                 String password, String crm, int office, MedicalSpecialty specialty) {
        super(name, cpf, rg, EmployeeType.DOCTOR, employeeId, birthDate, password);
        setCrm(crm);
        setOffice(office);
        setSpecialty(specialty);
    }

    public String getCrm() {
        return this.crm;
    }

    public void setCrm(String crm) {
        if (crm != null && crm.matches("[0-9]+") && crm.length() >= 4) {
            this.crm = crm;
        } else {
            throw new IllegalArgumentException("CRM invalido!");
        }
    }

    public int getOffice() {
        return this.office;
    }

    public void setOffice(int office) {
        if (office >= 0 && office <= 100) {
            this.office = office;
        } else {
            throw new IllegalArgumentException("Consultorio invalido! Digite um valor entre 0 e 100.");
        }
    }

    public MedicalSpecialty getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(MedicalSpecialty specialty) {
        if (specialty == null) {
            throw new IllegalArgumentException("Especialidade invalida!");
        }
        this.specialty = specialty;
    }
}
