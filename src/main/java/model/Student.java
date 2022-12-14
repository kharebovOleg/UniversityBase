package model;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @SerializedName("Id")
    @XmlElement(name = "universityId")
    private String universityId;

    @SerializedName("Name")
    @XmlElement(name = "studentName")
    private String fullName;

    @SerializedName("Course")
    @XmlTransient
    private int currentCourseNumber;

    @SerializedName("avgMark")
    @XmlElement(name = "avgScore")
    private float avgExamScore;

    public Student(String universityId, String fullName, int currentCourseNumber, float avgExamScore) {
        this.universityId = universityId;
        this.fullName = fullName;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "model.Student{" +
                "universityId='" + universityId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }
}
