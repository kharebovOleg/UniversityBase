package model;

import enums.StudyProfile;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class University {

    @SerializedName("number_ID")
    @XmlElement(name = "universityId")
    private String id;

    @SerializedName("full")
    @XmlElement(name = "universityName")
    private String fullName;

    @SerializedName("short")
    @XmlTransient
    private String shortName;

    @SerializedName("foundation")
    @XmlTransient
    private int yearOfFoundation;

    @SerializedName("profile")
    @XmlElement(name = "universityProfile")
    private StudyProfile mainProfile;

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
        return "model.University{" +
                ", id='" + id + '\'' +
                "fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
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
