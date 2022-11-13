import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        XSSFWorkbook workbook = ListsCreator.readExcel();
        List<Student> studentsList = ListsCreator.createListStudents(workbook);
        List<University> universities = ListsCreator.createListUniversity(workbook);
        ListsCreator.printList(universities);
        System.out.println("==================================");
        ListsCreator.printList(studentsList);
    }
}
