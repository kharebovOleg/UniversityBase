public class Main {
    public static void main(String[] args) {
        University mgu = new University("1", "Moscow State University",
                "MGU", 1755, StudyProfile.LAWYER);

        University medicineAcademy = new University("2", "Main Medicine Academy",
                "MMA", 1975, StudyProfile.MEDICINE);

        University gaydiInst = new University("3", "Institute of architect od Gaydi",
                "IAG", 1798, StudyProfile.ARCHITECT);

        Student student1 = new Student("Петров Иван Анатольевич", "1",3,4.3f);
        Student student2 = new Student("Муслимов Хабиб Анатольевич", "2",1,4.0f);
        Student student3 = new Student("Ассаянц Гаяне Грачиковна", "3",4,4.8f);

        System.out.println(mgu);
        System.out.println(medicineAcademy);
        System.out.println(gaydiInst);
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
    }
}
