package util;

import enums.StudyProfile;
import model.Statistics;
import model.Student;
import model.University;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.ExcelNumberFormat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class StatisticsCreator {
    public static List<Statistics> statistica(List<Student> studentsList, List<University> universities){
        List<Statistics> statisticsArrayList = new ArrayList<>();
        // creating Set of profiles
        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> {
            // add object to list
            Statistics statistics = new Statistics();
            statisticsArrayList.add(statistics);
            //set profile
            statistics.setProfile(profile);
            // set amount of universities (create List of universities which has this profile by stream of universities,
            // then mapping stream to university.getId and collecting all to list,
            // size of that list equals meaning of field amountOf Univ...)
            List<String> profileUnivIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setAmountUniversitiesByProfile(profileUnivIds.size());
            //set university names (set name "", then add "" + university name)
            statistics.setUniversityNames(StringUtils.EMPTY);
            universities.stream()
                    .filter(university -> profileUnivIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullName -> statistics.setUniversityNames(
                            statistics.getUniversityName() + fullName +";" ));
            //set amount of students (such as universities)
            List<Student> profileStudents = studentsList.stream()
                    .filter(student -> profileUnivIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setAmountStudentsByProfile(profileStudents.size());
            //set avg ()
            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAvgExam(0);
            avgExamScore.ifPresent(value -> statistics.setAvgExam(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_DOWN).doubleValue()));

        });

        return statisticsArrayList;
    }
}
