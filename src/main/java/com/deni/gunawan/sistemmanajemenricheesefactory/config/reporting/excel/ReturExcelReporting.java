package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.excel;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Retur;
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
public class ReturExcelReporting {

    /* export */
    public ByteArrayInputStream exportExcel(List<Retur> returs) throws Exception{
        String[] columns = {"Vendor", "Nama Barang", "Production Date", "Exp Date", "Pic", "Negara", "Jumlah Retur", "UOM", "Code Barang", "Tanggal Retur", "Deskripsi"};
        try(
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream()
        )
        {
            CreationHelper creationHelper = workbook.getCreationHelper();
            Sheet sheet = workbook.createSheet("Data Barang Retur");
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
            for(Retur retur : returs) {
                Row row = sheet.createRow(rowIdx);
                row.createCell(0).setCellValue(retur.getVendor());
                row.createCell(1).setCellValue(retur.getNamaBarang());
                row.createCell(2).setCellValue(retur.getProductionDate());
                row.createCell(3).setCellValue(retur.getExpDate());
                row.createCell(4).setCellValue(retur.getPic());
                row.createCell(5).setCellValue(retur.getNegara());
                row.createCell(6).setCellValue(retur.getJumlahRetur());
                row.createCell(7).setCellValue(retur.getUom());
                row.createCell(8).setCellValue(retur.getTanggalRetur());
                row.createCell(9).setCellValue(retur.getDeskripsi());

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
