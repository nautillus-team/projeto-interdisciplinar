package nautillus.models;

public class Patient {

    private static int genId = 0;

    private final int id;
    private String triagem;

    public Patient(int id, String Triagem) {

        this.id = ++genId;
        setTriagem(triagem);
    }

    public int getId() {
        return this.id;
    }

    public String getTriagem() {
        return this.triagem;
    }

    public void setTriagem(String fTriagem) {
        if (fTriagem != null) {
            this.triagem = fTriagem;
        } else {
            throw new IllegalArgumentException("E necessário digitar um valor para triagem!");
        }
    }


}