import Enums.StudentsSorting;
import Enums.UniversitySorting;
import comparators.StudentsComparator;
import comparators.UniversityComparator;
import io.ListsCreator;
import model.Student;
import model.University;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.JsonUtil;
import util.SortingChooser;

import java.io.File;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
// creating Workbook
        File f = new File("src/main/resources/universityInfo.xlsx");
        XSSFWorkbook workbook = ListsCreator.readExcel(f);
        List<Student> studentsList = ListsCreator.createListStudents(workbook);
        List<University> universities = ListsCreator.createListUniversity(workbook);

// students comparators
        StudentsComparator univerId = SortingChooser.choseStudentSorting(StudentsSorting.ID);
        StudentsComparator byName = SortingChooser.choseStudentSorting(StudentsSorting.FULLNAME);
        StudentsComparator byCourse = SortingChooser.choseStudentSorting(StudentsSorting.COURSE);
        StudentsComparator byAvg = SortingChooser.choseStudentSorting(StudentsSorting.AVGEXAM);
// universities comparators
        UniversityComparator byId = SortingChooser.choseUniverSorting(UniversitySorting.ID);
        UniversityComparator byFullName = SortingChooser.choseUniverSorting(UniversitySorting.FULLNAME);
        UniversityComparator byShortName = SortingChooser.choseUniverSorting(UniversitySorting.SHORTNAME);
        UniversityComparator byYear = SortingChooser.choseUniverSorting(UniversitySorting.YEAROFFOUNDATION);
        UniversityComparator byProfile = SortingChooser.choseUniverSorting(UniversitySorting.PROFILE);

// streams
        Stream<Student> studentStream = studentsList.stream();
        Stream<University> universityStream = universities.stream();

        studentStream
                .filter(student -> student.getAvgExamScore() > 4.5f)
                .sorted(byName)
                .limit(1)
                .map(JsonUtil::jsonStudentWrite)
                .peek(System.out::println)
                .map(JsonUtil::jsonStudentRead)
                .forEach(System.out::println);


        universityStream
                .sorted(byProfile)
                .limit(1)
                .map(JsonUtil::jsonUniversitiesWrite)
                .peek(System.out::println)
                .map(JsonUtil::jsonUniversityRead)
                .forEach(System.out::println);

//        List<String> stringsSt = util.JsonUtil.jsonListStudentsWrite(studentsList);
//        List<String> stringsUn = util.JsonUtil.jsonListUniversitiesWrite(universities);
//
//        List<model.Student> studentsFromJson = util.JsonUtil.jsonStudentListRead(stringsSt);
//        List<model.University> universitiesFromJson = util.JsonUtil.jsonUniversityListRead(stringsUn);
//
//        System.out.println(universities);
//        System.out.println(universitiesFromJson);
//
//        System.out.println(studentsList);
//        System.out.println(studentsFromJson);
    }
}
