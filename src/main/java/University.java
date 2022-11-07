public class University {
    private String id;
    private String fullName, shortName;
    private int yearOfFoundation;
    StudyProfile mainProfile;

    public University() {}

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }


    public String getFullName() {
        return fullName;
    }


    public String getShortName() {
        return shortName;
    }


    public String getId() {
        return id;
    }


    public int getYearOfFoundation() {
        return yearOfFoundation;
    }


    public StudyProfile getMainProfile() {
        return mainProfile;
    }


    @Override
    public String toString() {
        return "University{" +
                "fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", id='" + id + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }
}
