package io;

import model.AllInfo;
import util.JsonUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonWriter {

    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

    private JsonWriter() {}

    public static void writeJsonFile(AllInfo allInfo){

        logger.log(Level.INFO, "JSON writing started");

        try {
            Files.createDirectory(Paths.get("jsonReqs"));
            logger.log(Level.INFO, "Directory created successfully");
        } catch (IOException e) {
            logger.log(Level.FINE, "Directory already created", e);
        }

        writeStudentJs(allInfo);
        writeUniversitiesJs(allInfo);
        writeStatisticsListJs(allInfo);

        logger.log(Level.INFO, "JSON writing finished successfully");

    }

    public static void writeStudentJs(AllInfo allInfo) {
        String studentsJs = JsonUtil.writeListToJson(allInfo.getStudentList());

        try {
            FileOutputStream fos = new FileOutputStream("jsonReqs/students"
                    + dateFormat.format(allInfo.getProcessDate().getTime()) + ".json");
            fos.write(studentsJs.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Students JSON writing failed", e);
        }
    }

    private static void writeUniversitiesJs(AllInfo allInfo) {
        String universitiesJs = JsonUtil.writeListToJson(allInfo.getUniversityList());

        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/universities" + dateFormat.format(allInfo.getProcessDate().getTime()) + ".json");
            outputStream.write(universitiesJs.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Universities JSON writing failed", e);
        }
    }

    private static void writeStatisticsListJs(AllInfo allInfo) {
        String studentsJs = JsonUtil.writeListToJson(allInfo.getStatisticsList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/statistics" + dateFormat.format(allInfo.getProcessDate().getTime()) + ".json");
            outputStream.write(studentsJs.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Statistics JSON writing failed", e);
        }
    }

}
