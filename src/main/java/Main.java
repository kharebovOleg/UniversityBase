import comparators.StudentsComparator;
import comparators.UniversityComparator;
import enums.StudentsSorting;
import enums.UniversitySorting;
import io.JaxbWriter;
import io.XlsReader;
import io.XlsWriter;
import model.AllInfo;
import model.Statistics;
import model.Student;
import model.University;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.SortingChooser;
import util.StatisticsCreator;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.LogManager;

import static java.util.logging.Level.INFO;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {

        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        logger.log(INFO, "Application started, Logger configured");

        File f = new File("src/main/resources/universityInfo.xlsx");
        XSSFWorkbook workbook = XlsReader.readExcel(f);

        List<Student> studentsList = XlsReader.createListStudents(workbook);
        List<University> universities = XlsReader.createListUniversity(workbook);

        StudentsComparator byName = SortingChooser.choseStudentSorting(StudentsSorting.FULLNAME);
        studentsList.sort(byName);
        UniversityComparator byProfile = SortingChooser.choseUniverSorting(UniversitySorting.PROFILE);
        universities.sort(byProfile);

        List<Statistics> st = StatisticsCreator.statistica(studentsList,universities);

        File file = new File("src/main/resources/toWrite.xlsx");
        XlsWriter.writeToExcel(st, file);

        AllInfo allLists = new AllInfo()
                .setStatisticsList(st)
                .setStudentList(studentsList)
                .setUniversityList(universities)
                .setProcessDate(new Date());

        JaxbWriter.writeXml(allLists);

        logger.log(INFO, "Application finished");
    }
}
