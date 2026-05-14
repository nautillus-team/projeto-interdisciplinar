package nautillus.models;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class RegiForm extends Patient {

    private String name;
    private String cpf;
    private String rg;
    private String birthDate;
    private String susCard;

    public RegiForm(int id, String triage, String name, String cpf, String rg, String birthDate, String susCard) {

        super(id, triage);

        setName(name);
        setCpf(cpf);
        setRg(rg);
        setBirthDate(birthDate);
        setSusCard(susCard);
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

    public String getSusCard() {
        return this.susCard;
    }

    public void setSusCard(String susCard) {
        if (susCard != null && susCard.matches("[0-9]+") && susCard.length() == 15) {
            this.susCard = susCard;
        } else {
            throw new IllegalArgumentException("Digite um cartao SUS valido!");
        }
    }

    public int getAge() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nascimento = LocalDate.parse(this.birthDate, formatador);
        return Period.between(nascimento, LocalDate.now()).getYears();
    }
}
