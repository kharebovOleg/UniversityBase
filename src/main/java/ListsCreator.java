import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListsCreator {

    private static File f = new File("src/main/resources/universityInfo.xlsx");
    private static ListsCreator instance;

    private ListsCreator() {
    }

    public static ListsCreator getInstance(){
        if (instance == null){
            instance = new ListsCreator();
        }
        return instance;
    }

    public static XSSFWorkbook readExcel(){
        try {
            FileInputStream file = new FileInputStream(f);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            file.close();
            return workbook;
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static List<Student> createListStudents(@NotNull XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        List<Student> studentList = new ArrayList<>();
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            int i = 0;
            Cell[] cells = new Cell[4];
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                cells[i] = cell;
                i++;
            }
            studentsAdd(cells, studentList);
        }
        return studentList;
    }

    public static void studentsAdd(Cell[] cells, List<Student> list){
        list.add(new Student(cells[0].getStringCellValue(),cells[1].getStringCellValue(),
                (int) cells[2].getNumericCellValue(),(float) cells[3].getNumericCellValue()));
    }

    public static void univercityAdd(Cell[] cells, List<University> list){
        list.add(new University(cells[0].getStringCellValue(),cells[1].getStringCellValue(),
                cells[2].getStringCellValue(),(int) cells[3].getNumericCellValue(), getProfile(cells[4].getStringCellValue())));
    }

    public static StudyProfile getProfile(String st) {
        for (StudyProfile studyProfile : StudyProfile.values()){
            if (studyProfile.name().equals(st)){
                return studyProfile;
            }
        }
        return null;
    }

    public static List<University> createListUniversity(XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.getSheetAt(1);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        List<University> universityList = new ArrayList<>();
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            int i = 0;
            Cell[] cells = new Cell[5];
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                cells[i] = cell;
                i++;
            }
            univercityAdd(cells, universityList);
        }
        return universityList;
    }


    public static void printList(List<? extends Object> list) {
        Iterator<?> st = list.iterator();
        int i = 1;
        while (st.hasNext()) {
            System.out.println(i + ") " + st.next());
            i++;
        }

    }

    public static File getF() {
        return f;
    }
}
