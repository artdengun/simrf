package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.excel;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Asset;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Component
public class AssetExcelReporting {

    private final XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private final List<Asset> listAssets;

    public AssetExcelReporting(List<Asset> listAssets) {
        this.listAssets = listAssets;
        workbook = new XSSFWorkbook();
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("Data Asset");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "User ID", style);
        createCell(row, 1, "E-mail", style);
        createCell(row, 2, "Full Name", style);
        createCell(row, 3, "Roles", style);
        createCell(row, 4, "Enabled", style);
        createCell(row, 5, "Roles", style);
        createCell(row, 6, "Roles", style);
        createCell(row, 7, "Roles", style);
        createCell(row, 8, "Roles", style);
        createCell(row, 9, "Roles", style);


    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Asset asset : listAssets) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, asset.getNoAssets(), style);
            createCell(row, columnCount++, asset.getNama(), style);
            createCell(row, columnCount++, asset.getHargaAssets(), style);
            createCell(row, columnCount++, asset.getJenis().toString(), style);
            createCell(row, columnCount++, asset.getVendor().toString(), style);
            createCell(row, columnCount++, asset.getTanggalDiterima().toString(), style);
            createCell(row, columnCount++, asset.getTanggalInput().toString(), style);
            createCell(row, columnCount++, asset.getQuantity(), style);
            createCell(row, columnCount++, asset.getPic().toString(), style);

        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();

    }
}