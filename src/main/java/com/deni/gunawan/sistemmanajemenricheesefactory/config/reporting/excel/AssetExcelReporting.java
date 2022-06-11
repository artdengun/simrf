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
import java.text.DecimalFormat;
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

        createCell(row, 0, "No Asset", style);
        createCell(row, 1, "Nama Asset", style);
        createCell(row, 2, "Vendor", style);
        createCell(row, 3, "Tanggal Penerimaan", style);
        createCell(row, 4, "Jenis Asset", style);
        createCell(row, 5, "Quantity", style);
        createCell(row, 6, "Harga", style);
        createCell(row, 7, "Tanggal Input", style);
        createCell(row, 8, "Pic", style);
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
            createCell(row, columnCount++, asset.getVendor().getVendorDisplay(), style);
            createCell(row, columnCount++, asset.getTanggalDiterima(), style);
            createCell(row, columnCount++, asset.getJenis().getJenisDisplay(), style);
            createCell(row, columnCount++, asset.getQuantity(), style);
            createCell(row, columnCount++, DecimalFormat.getInstance().format(asset.getHargaAssets()), style);
            createCell(row, columnCount++, asset.getTanggalInput(), style);

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