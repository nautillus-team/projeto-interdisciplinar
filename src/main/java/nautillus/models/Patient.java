package nautillus.models;

public class Patient {

    private static int genId = 0;

    private final int id;
    private String triage;

    public Patient(int id, String triage) {
        this.id = ++genId;
        setTriage(triage);
    }

    public int getId() {
        return this.id;
    }

    public String getTriage() {
        return this.triage;
    }

    public void setTriage(String triage) {
        if (triage != null && triage.length() > 0) {
            this.triage = triage;
        } else {
            throw new IllegalArgumentException("E necessario digitar um valor para triagem!");
        }
    }
}
