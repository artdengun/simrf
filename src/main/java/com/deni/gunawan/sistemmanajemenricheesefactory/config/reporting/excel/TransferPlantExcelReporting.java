package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.excel;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Retur;
import com.deni.gunawan.sistemmanajemenricheesefactory.entity.TransferPlant;
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
public class TransferPlantExcelReporting {

    /* export */
    public ByteArrayInputStream exportExcel(List<TransferPlant> transferPlants) throws Exception{
        String[] columns = {"Tanggal Dikirim", "No Dokumen", "Nama Barang", "Quantity", "UOM", "PIC", "Outlet Penerima", "Outlet Pengirim", "Mod Incharge"};
        try(
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream()
        )
        {
            CreationHelper creationHelper = workbook.getCreationHelper();
            Sheet sheet = workbook.createSheet("Data Barang Transfer Plant");
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
            for(TransferPlant transferPlant : transferPlants) {
                Row row = sheet.createRow(rowIdx);
                row.createCell(0).setCellValue(transferPlant.getTanggalDikirim());
                row.createCell(1).setCellValue(transferPlant.getNoDokumen());
                row.createCell(2).setCellValue(transferPlant.getNamaBarang());
                row.createCell(3).setCellValue(transferPlant.getQuantiyBarang());
                row.createCell(4).setCellValue(transferPlant.getUom());
                row.createCell(5).setCellValue(transferPlant.getPic());
                row.createCell(6).setCellValue(transferPlant.getOutletPenerima());
                row.createCell(7).setCellValue(transferPlant.getOutletPengirim());
                row.createCell(8).setCellValue(transferPlant.getModIncharge());
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
