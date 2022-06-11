package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.excel;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Raw;
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
public class RawExcelReporting {


    private final XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private final List<Raw> listRaw;

    public RawExcelReporting(List<Raw> listRaw) {
        this.listRaw = listRaw;
        workbook = new XSSFWorkbook();
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("Data Raw");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Vendor", style);
        createCell(row, 1, "Nama Product", style);
        createCell(row, 2, "Production Date", style);
        createCell(row, 3, "Exp Date", style);
        createCell(row, 4, "Negara", style);
        createCell(row, 5, "UOM", style);
        createCell(row, 6, "Code Barang", style);
        createCell(row, 7, "Tanggal Penerimaan", style);
        createCell(row, 8, "Deskripsi", style);
        createCell(row, 9, "Pic", style);

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

        for (Raw raw : listRaw) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, raw.getVendor().getVendorDisplay(), style);
            createCell(row, columnCount++, raw.getNamaProduct(), style);
            createCell(row, columnCount++, raw.getProductionDate(), style);
            createCell(row, columnCount++, raw.getExpDate(), style);
            createCell(row, columnCount++, raw.getNegara().getNegaraDisplay(), style);
            createCell(row, columnCount++, raw.getUom().getUomDisplay(), style);
            createCell(row, columnCount++, raw.getCodeBarang(), style);
            createCell(row, columnCount++, raw.getTanggalPenerimaan(), style);
            createCell(row, columnCount++, raw.getDeskripsi(), style);

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
