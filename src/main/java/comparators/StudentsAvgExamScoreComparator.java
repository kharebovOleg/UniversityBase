package comparators;

import model.Student;

public class StudentsAvgExamScoreComparator implements StudentsComparator{
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o2.getAvgExamScore(), o1.getAvgExamScore());
    }
}
