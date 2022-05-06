package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.excel;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.TransferPlant;
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
public class TransferplantExcelReporting {


    private final XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private final List<TransferPlant> listTransferplant;

    public TransferplantExcelReporting(List<TransferPlant> listTransferplant) {
        this.listTransferplant = listTransferplant;
        workbook = new XSSFWorkbook();
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("Data Transferplant");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Tanggal Pengiriman", style);
        createCell(row, 1, "No Dokumen", style);
        createCell(row, 2, "Nama Barang", style);
        createCell(row, 3, "Quantity Barang", style);
        createCell(row, 4, "Uom", style);
        createCell(row, 5, "outletPenerima", style);
        createCell(row, 6, "outletPengirim", style);
        createCell(row, 7, "modeIncharge", style);
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

        for (TransferPlant transferPlant : listTransferplant) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, transferPlant.getTanggalDikirim(), style);
            createCell(row, columnCount++, transferPlant.getNoDokumen(), style);
            createCell(row, columnCount++, transferPlant.getNamaBarang(), style);
            createCell(row, columnCount++, transferPlant.getQuantityBarang(), style);
            createCell(row, columnCount++, transferPlant.getUom().getUomDisplay(), style);
            createCell(row, columnCount++, transferPlant.getOutletPenerima(), style);
            createCell(row, columnCount++, transferPlant.getOutletPengirim(), style);
            createCell(row, columnCount++, transferPlant.getModIncharge(), style);
            createCell(row, columnCount++, transferPlant.getUsers().getNama(), style);

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
