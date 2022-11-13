public enum StudyProfile {
    ARCHITECT("Архитектура"),
    LAWYER("Юриспруденция"),
    MEDICINE("Медицина"),
    PHYSICS("Физика"),
    LINGUISTICS("Лингвистика"),
    MATHEMATICS("Математика");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
