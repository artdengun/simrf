package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.excel;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Raw;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 *
 * @author denigunawan
 */

@Data
@AllArgsConstructor
public class RawExcelReporting {
    /* export */
    public ByteArrayInputStream exportExcel(List<Raw> raws) throws Exception{
        String[] columns = {"Vendor", "Nama Product", "Production Date", "Exp Date", "Negara", "UOM", "PIC", "Kode Barang", "Tanggal Penerima", "Deskripsi"};
        try(
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream()
        )
        {
            CreationHelper creationHelper = workbook.getCreationHelper();
            Sheet sheet = workbook.createSheet("Data Barang Raw");
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            //Row offer Header
            Row headerRow = sheet.createRow(0);

            //Header
            for(int i=0;i<columns.length;i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerCellStyle);
            }

            int rowIdx = 1;
            for(Raw raw : raws) {
                Row row = sheet.createRow(rowIdx);
                row.createCell(0).setCellValue(raw.getVendor());
                row.createCell(1).setCellValue(raw.getNamaProduct());
                row.createCell(2).setCellValue(raw.getProductionDate());
                row.createCell(3).setCellValue(raw.getExpDate());
                row.createCell(4).setCellValue(raw.getNegara());
                row.createCell(5).setCellValue(raw.getUom());
                row.createCell(6).setCellValue(raw.getPic());
                row.createCell(7).setCellValue(raw.getCodeBarang());
                row.createCell(8).setCellValue(raw.getTanggalPenerimaan());
                row.createCell(9).setCellValue(raw.getDeskripsi());

                rowIdx++;
            }
            workbook.write(out);
            workbook.close();
            return new ByteArrayInputStream(out.toByteArray());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
