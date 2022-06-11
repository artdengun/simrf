package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.excel;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Retur;
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

@Component
public class ReturExcelReporting {

    
    private final XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private final List<Retur> listRetur;

    public ReturExcelReporting(List<Retur> listRetur) {
        this.listRetur = listRetur;
        workbook = new XSSFWorkbook();
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("Data Retur");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Vendor", style);
        createCell(row, 1, "Nama Barang", style);
        createCell(row, 2, "Tanggal Produksi", style);
        createCell(row, 3, "Exp Date", style);
        createCell(row, 4, "Negara", style);
        createCell(row, 5, "Jumlah Retur", style);
        createCell(row, 6, "Uom", style);
        createCell(row, 7, "Kode", style);
        createCell(row, 8, "Tanggal Retur", style);
        createCell(row, 9, "Deskripsi", style);
        createCell(row, 10, "PIC", style);


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

        for (Retur Retur : listRetur) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, Retur.getVendor().getVendorDisplay(), style);
            createCell(row, columnCount++, Retur.getNamaBarang(), style);
            createCell(row, columnCount++, Retur.getProductionDate(), style);
            createCell(row, columnCount++, Retur.getExpDate(), style);
            createCell(row, columnCount++, Retur.getNegara().getNegaraDisplay(), style);
            createCell(row, columnCount++, Retur.getJumlahRetur(), style);
            createCell(row, columnCount++, Retur.getUom().getUomDisplay(), style);
            createCell(row, columnCount++, Retur.getCodeBarang(), style);
            createCell(row, columnCount++, Retur.getTanggalRetur(), style);
            createCell(row, columnCount++, Retur.getDeskripsi(), style);

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
