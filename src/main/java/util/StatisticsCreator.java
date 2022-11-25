package util;

import model.Statistics;
import model.Student;
import model.University;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StatisticsCreator {
    public static List<Statistics> statistica(List<Student> studentsList, List<University> universities){
        List<Statistics> statistics = new ArrayList<>();

        Stream<Student> studentStream = studentsList.stream();
        Stream<University> universityStream = universities.stream();

        return statistics;
    }
}
