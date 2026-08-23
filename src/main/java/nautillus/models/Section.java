package nautillus.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sectionId;

    private String sectionName;

    @ManyToOne
    @JoinColumn(name = "root_section_id")
    private Section rootSection;

    // Setters
    public void setSectionId(long sectionId)            { this.sectionId = sectionId; }
    public void setSectionName(String sectionName)      { this.sectionName = sectionName; }
    public void setRootSection(Section rootSection)     { this.rootSection = rootSection; }

    // Getters
    public long getSectionId()                          { return sectionId; }
    public String getSectionName()                      { return sectionName; }
    public Section getRootSection()                     { return rootSection; }
}
