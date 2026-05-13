package nautillus.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import nautillus.enums.EmployeeType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Employee {

    private static int genId = 0;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private String name;
    private String cpf;
    private String rg;
    private EmployeeType role;
    private String birthDate;
    private String password;
    private String employeeId;
    private final int id;

    public Employee(String name, String cpf, String rg, EmployeeType role,
                    String employeeId, String birthDate, String password) {
        setName(name);
        setCpf(cpf);
        setRg(rg);
        setRole(role);
        setEmployeeId(employeeId);
        setBirthDate(birthDate);
        setPassword(password);
        this.id = ++genId;
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

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        if (cpf != null && cpf.replace(" ", "").matches("[0-9]+") && cpf.length() == 11) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF invalido!");
        }
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        if (rg != null && rg.matches("[0-9]+") && rg.length() == 9) {
            this.rg = rg;
        } else {
            throw new IllegalArgumentException("RG invalido!");
        }
    }

    public EmployeeType getRole() {
        return this.role;
    }

    public void setRole(EmployeeType role) {
        if (role == null) {
            throw new IllegalArgumentException("Funcao invalida!");
        }
        this.role = role;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        try {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(birthDate, formatador);

            if (!data.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("Digite uma data valida.");
            }

            this.birthDate = birthDate;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de data invalido! Use dd/MM/yyyy.");
        }
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(String employeeId) {
        if (employeeId != null && !employeeId.isBlank() && employeeId.length() < 30) {
            this.employeeId = employeeId;
        } else {
            throw new IllegalArgumentException("Matricula invalida!");
        }
    }

    public void setPassword(String password) {
        if (password != null && password.length() >= 8) {
            this.password = encoder.encode(password);
        } else {
            throw new IllegalArgumentException("Senha invalida! Minimo 8 caracteres.");
        }
    }

    public boolean verifyPassword(String password) {
        return encoder.matches(password, this.password);
    }

    public int getId() {
        return this.id;
    }
}
