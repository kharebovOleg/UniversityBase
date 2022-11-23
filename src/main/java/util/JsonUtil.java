package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Student;
import model.University;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    private JsonUtil() {
    }

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static String jsonStudentWrite(Student student) {
        return GSON.toJson(student);
    }

    public static String jsonUniversitiesWrite(University university) {
        return GSON.toJson(university);
    }

    public static List<String> jsonListUniversitiesWrite(List<University> universityList){
        List<String> universitiesInJson = new ArrayList<>();
        for (University university : universityList){
            universitiesInJson
                    .add(jsonUniversitiesWrite(university));
        }
        return universitiesInJson;
    }

    public static List<String> jsonListStudentsWrite(List<Student> studentList){
        List<String> studentsInJson = new ArrayList<>();
        for (Student student : studentList){
            studentsInJson
                    .add(jsonStudentWrite(student));
        }
        return studentsInJson;
    }

    public static Student jsonStudentRead(String s) {
        return GSON.fromJson(s, Student.class);
    }

    public static University jsonUniversityRead(String s) {
        return GSON.fromJson(s, University.class);
    }

    public static List<Student> jsonStudentListRead (List<String> strings) {
        List<Student> sList = new ArrayList<>();
        for (String student : strings) {
            sList.add(jsonStudentRead(student));
        }
        return sList;
    }

    public static List<University> jsonUniversityListRead (List<String> strings) {
        List<University> sList = new ArrayList<>();
        for (String student : strings) {
            sList.add(jsonUniversityRead(student));
        }
        return sList;
    }

}
