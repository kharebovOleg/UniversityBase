package enums;

public enum StudyProfile {
    ARCHITECT("архитектура"),
    LAWYER("юриспруденция"),
    MEDICINE("медицина"),
    PHYSICS("физика"),
    LINGUISTICS("лингвистика"),
    MATHEMATICS("математика");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
