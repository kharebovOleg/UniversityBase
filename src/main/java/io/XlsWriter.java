package io;

import model.Statistics;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class XlsWriter {

    private XlsWriter() {
    }

    public static void writeToExcel(List<Statistics> statistics, File file) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Statistics");

        Font head = createMyFont(workbook,"Times New Roman", true, 300);
        CellStyle style = workbook.createCellStyle();
        style.setFont(head);

        int rownum = 0;
        createHead(sheet,rownum,style,"Profile", "AVG",
                "amountStudentsByProfile", "amountUniversitiesByProfile", "universityName");


        for (Statistics st : statistics) {
            createLine(sheet, ++rownum, st);
        }

        try {
            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
            fos.close();
            System.out.println("finished");
        } catch (Exception e) {
            System.out.println("error");
        }

    }

    public static Font createMyFont(@NotNull Workbook workbook, String fontName, boolean bold, int size) {
        Font f = workbook.createFont();
        f.setFontName(fontName);
        f.setBold(bold);
        f.setFontHeight((short) size);
        return f;
    }

    public static void createHead(XSSFSheet sheet,int rownum, CellStyle cs, String a, String b, String c, String d, String e){

        Row row = sheet.createRow(rownum);
        Cell cell1 = row.createCell(0);
        cell1.setCellStyle(cs);
        cell1.setCellValue(a);
        Cell cell2 = row.createCell(1);
        cell2.setCellStyle(cs);
        cell2.setCellValue(b);
        Cell cell3 = row.createCell(2);
        cell3.setCellStyle(cs);
        cell3.setCellValue(c);
        Cell cell4 = row.createCell(3);
        cell4.setCellStyle(cs);
        cell4.setCellValue(d);
        Cell cell5 = row.createCell(4);
        cell5.setCellStyle(cs);
        cell5.setCellValue(e);
    }

    public static void createLine(XSSFSheet sheet, int rownum, Statistics st){
        Row row = sheet.createRow(rownum);

        row.createCell(0).setCellValue(st.getProfile().getProfileName());
        row.createCell(1).setCellValue(st.getAvgExam());
        row.createCell(2).setCellValue(st.getAmountStudentsByProfile());
        row.createCell(3).setCellValue(st.getAmountUniversitiesByProfile());
        row.createCell(4).setCellValue(st.getUniversityName());
    }


}
