package enums;

public enum StudyProfile {
    ARCHITECT("�����������"),
    LAWYER("�������������"),
    MEDICINE("��������"),
    PHYSICS("������"),
    LINGUISTICS("�����������"),
    MATHEMATICS("����������");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
