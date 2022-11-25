package Enums;

public enum StudyProfile {
    ARCHITECT("Architecture"),
    LAWYER("Jurisprudence"),
    MEDICINE("Medicine"),
    PHYSICS("Physics"),
    LINGUISTICS("Linguistics"),
    MATHEMATICS("Math");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
