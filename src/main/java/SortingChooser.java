public class SortingChooser {
    private SortingChooser() {
    }

    public static UniversityComparator choseUniverSorting(UniversitySorting sorting) {
        switch (sorting) {
            case ID:
                return new UniversityIdComparator();
            case FULLNAME:
                return new UniversityFullNameComparator();
            case SHORTNAME:
                return new UniversityShortNameComparator();
            case YEAROFFOUNDATION:
                return new UniversityYearComparator();
            case PROFILE:
                return new UniversityProfileComparator();
            default:
                System.out.println("Такой сортировки еще нет");
                break;
        }
        return null;
    }

    public static StudentsComparator choseStudentSorting(StudentsSorting sorting) {
        switch (sorting) {
            case ID: return new StudentIdComparator();
            case FULLNAME:return new StudentFullNameComparator();
            case COURSE: return new StudentsCurrentCourseNumberComparator();
            case AVGEXAM: return new StudentsAvgExamScoreComparator();
            default:
                System.out.println("Такой сортировки еще нет");
                break;
        }
        return null;
    }
}
