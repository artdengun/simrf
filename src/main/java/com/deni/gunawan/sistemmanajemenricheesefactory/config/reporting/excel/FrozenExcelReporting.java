package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.excel;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Frozen;
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
public class FrozenExcelReporting {

    /* export */
    public ByteArrayInputStream exportExcel(List<Frozen> frozens) throws Exception{
        String[] columns = {"Vendor", "Nama Product", "Suhu Product", "Production Date", "Exp Date", "Negara", "UOM", "PIC", "Kode Barang", "Tanggal Penerima", "Deskripsi"};
        try(
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream()
        )
        {
            CreationHelper creationHelper = workbook.getCreationHelper();
            Sheet sheet = workbook.createSheet("Data Barang Frozen");
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
            for(Frozen frozen : frozens) {
                Row row = sheet.createRow(rowIdx);
                row.createCell(0).setCellValue(frozen.getVendor());
                row.createCell(1).setCellValue(frozen.getNamaProduct());
                row.createCell(2).setCellValue(frozen.getSuhuProduct());
                row.createCell(3).setCellValue(frozen.getProductionDate());
                row.createCell(4).setCellValue(frozen.getExpDate());
                row.createCell(5).setCellValue(frozen.getNegara());
                row.createCell(6).setCellValue(frozen.getUom());
                row.createCell(7).setCellValue(frozen.getPic());
                row.createCell(8).setCellValue(frozen.getCodeBarang());
                row.createCell(9).setCellValue(frozen.getTanggalPenerimaan());
                row.createCell(10).setCellValue(frozen.getDeskripsi());

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
