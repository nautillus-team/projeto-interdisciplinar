package nautillus.enums;

public enum AdministrationRoute {

    PO("Oral"),
    SL("Sublingual"),
    IV("Intravenous"),
    IM("Intramuscular"),
    SC("Subcutaneous"),
    TOP("Topical"),
    INH("Inhalational");

    private final String description;

    AdministrationRoute(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
