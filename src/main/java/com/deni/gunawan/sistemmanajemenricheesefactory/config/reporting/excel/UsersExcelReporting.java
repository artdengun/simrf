package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.excel;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@Component
public class UsersExcelReporting {
//
//
//    private final XSSFWorkbook workbook;
//    private XSSFSheet sheet;
//    private final List<Users> listUsers;
//
//    public UsersExcelReporting(List<Users> listUsers) {
//        this.listUsers = listUsers;
//        workbook = new XSSFWorkbook();
//    }
//
//
//    private void writeHeaderLine() {
//        sheet = workbook.createSheet("Data Users");
//
//        Row row = sheet.createRow(0);
//
//        CellStyle style = workbook.createCellStyle();
//        XSSFFont font = workbook.createFont();
//        font.setBold(true);
//        font.setFontHeight(16);
//        style.setFont(font);
//
//        createCell(row, 0, "Nama", style);
//        createCell(row, 1, "Username", style);
//        createCell(row, 2, "Password", style);
//        createCell(row, 3, "Alamat", style);
//        createCell(row, 4, "Jenis Kelamin", style);
//        createCell(row, 5, "Pendidikan", style);
//        createCell(row, 6, "Jabatan", style);
//        createCell(row, 7, "Telephone", style);
//        createCell(row, 8, "Perkawinan", style);
//        createCell(row, 9, "Tanggal Join", style);
//        createCell(row, 10, "Email", style);
//
//    }
//
//    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
//        sheet.autoSizeColumn(columnCount);
//        Cell cell = row.createCell(columnCount);
//        if (value instanceof Integer) {
//            cell.setCellValue((Integer) value);
//        } else if (value instanceof Boolean) {
//            cell.setCellValue((Boolean) value);
//        }else {
//            cell.setCellValue((String) value);
//        }
//        cell.setCellStyle(style);
//    }
//
//    private void writeDataLines() {
//        int rowCount = 1;
//
//        CellStyle style = workbook.createCellStyle();
//        XSSFFont font = workbook.createFont();
//        font.setFontHeight(14);
//        style.setFont(font);
//
//        for (Users users : listUsers) {
//            Row row = sheet.createRow(rowCount++);
//            int columnCount = 0;
//
//            createCell(row, columnCount++, users.getNama(), style);
//            createCell(row, columnCount++, users.getUsername(), style);
//            createCell(row, columnCount++, users.getPassword(), style);
//            createCell(row, columnCount++, users.getAlamat(), style);
//            createCell(row, columnCount++, users.getJenisKelamin().getJenisKelaminDisplay(), style);
//            createCell(row, columnCount++, users.getPendidikan().getPendidikanDisplay(), style);
//            createCell(row, columnCount++, users.getRole().getRole(), style);
//            createCell(row, columnCount++, users.getTelephone(), style);
//            createCell(row, columnCount++, users.getStatusPerkawinan().getStatusPerkawinanDisplay(), style);
//            createCell(row, columnCount++, users.getTanggalJoin(), style);
//            createCell(row, columnCount++, users.getEmail(), style);
//
//        }
//    }
//
//    public void export(HttpServletResponse response) throws IOException {
//        writeHeaderLine();
//        writeDataLines();
//
//        ServletOutputStream outputStream = response.getOutputStream();
//        workbook.write(outputStream);
//        outputStream.close();
//
//    }


}
