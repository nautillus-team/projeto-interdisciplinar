package nautillus.models;

import nautillus.enums.EmployeeType;
import nautillus.enums.MedicalSpecialty;
import nautillus.enums.NurseType;

public class Administrative extends Employee {

    private float budget;

    public Administrative(String name, String cpf, String rg, String employeeId,
                          String birthDate, String password, float budget) {
        super(name, cpf, rg, EmployeeType.ADMINISTRATIVE, employeeId, birthDate, password);
        setBudget(budget);
    }

    public float getBudget() {
        return this.budget;
    }

    public void setBudget(float budget) {
        if (budget >= 0) {
            this.budget = budget;
        } else {
            throw new IllegalArgumentException("Verba invalida! O valor nao pode ser negativo.");
        }
    }

    public void createEmployee(Employee employee, String name, String cpf, String rg,
                                EmployeeType role, String employeeId, String birthDate, String password) {
        try {
            employee.setName(name);
            employee.setCpf(cpf);
            employee.setRg(rg);
            employee.setRole(role);
            employee.setEmployeeId(employeeId);
            employee.setBirthDate(birthDate);
            employee.setPassword(password);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar funcionario: " + e.getMessage());
        }
    }

    public void createMedic(Medic medic, String crm, int office, MedicalSpecialty specialty) {
        try {
            medic.setCrm(crm);
            medic.setOffice(office);
            medic.setSpecialty(specialty);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar medico: " + e.getMessage());
        }
    }

    public void createNurse(Nurse nurse, String coren, NurseType category) {
        try {
            nurse.setCoren(coren);
            nurse.setCategory(category);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar enfermeiro: " + e.getMessage());
        }
    }

    public void createPharmaceutical(Pharmaceutical pharmaceutical, String crf) {
        try {
            pharmaceutical.setCrf(crf);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar farmaceutico: " + e.getMessage());
        }
    }
}
