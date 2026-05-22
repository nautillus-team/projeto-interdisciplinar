package nautillus.models;

public class Section {

    private long sectionId;
    private String sectionName;

    private Section rootSection;
    private Section[] subSections;

    private Batch[] sectionBatches;
}
