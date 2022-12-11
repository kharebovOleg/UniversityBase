package model;

import enums.StudyProfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {

    @XmlElement(name = "universityProfile")
    private StudyProfile profile;

    @XmlElement(name = "avgScore")
    private float avgExam;

    @XmlTransient
    private int amountStudentsByProfile;

    @XmlTransient
    private int amountUniversitiesByProfile;

    @XmlTransient
    private String universityName;

    public Statistics(StudyProfile profile, float avgExam, int amountStudentsByProfile,
                      int amountUniversitiesByProfile, String uniersityNames) {
        this.profile = profile;
        this.avgExam = avgExam;
        this.amountStudentsByProfile = amountStudentsByProfile;
        this.amountUniversitiesByProfile = amountUniversitiesByProfile;
        this.universityName = uniersityNames;
    }

    public Statistics() {

    }

    public StudyProfile getProfile() {
        return profile;
    }

    public Statistics setProfile(StudyProfile profile) {
        this.profile = profile;
        return this;
    }

    public float getAvgExam() {
        return avgExam;
    }

    public Statistics setAvgExam(float avgExam) {
        this.avgExam = avgExam;
        return this;
    }

    public int getAmountStudentsByProfile() {
        return amountStudentsByProfile;
    }

    public Statistics setAmountStudentsByProfile(int amountStudentsByProfile) {
        this.amountStudentsByProfile = amountStudentsByProfile;
        return this;
    }

    public int getAmountUniversitiesByProfile() {
        return amountUniversitiesByProfile;
    }

    public Statistics setAmountUniversitiesByProfile(int amountUniversitiesByProfile) {
        this.amountUniversitiesByProfile = amountUniversitiesByProfile;
        return this;
    }

    public String getUniversityName() {
        return universityName;
    }

    public Statistics setUniversityNames(String universityName) {
        this.universityName = universityName;
        return this;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "profile=" + profile +
                ", avgExam=" + avgExam +
                ", amountStudentsByProfile=" + amountStudentsByProfile +
                ", amountUniversitiesByProfile=" + amountUniversitiesByProfile +
                ", universityName='" + universityName + '\'' +
                '}';
    }
}
