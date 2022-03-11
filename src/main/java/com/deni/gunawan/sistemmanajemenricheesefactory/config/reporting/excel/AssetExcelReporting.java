package com.deni.gunawan.sistemmanajemenricheesefactory.config.reporting.excel;

import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Asset;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.AssetRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author denigunawan
 */

@Service
@Data
@AllArgsConstructor
public class AssetExcelReporting {

    private AssetRepo assetRepo;

    /* export */
    public ByteArrayInputStream exportExcel(List<Asset> assets) throws Exception{
        String[] columns = {"Id", "Name", "Kelas", "Jurusan"};
        try(
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream()
        )
        {
            CreationHelper creationHelper = workbook.getCreationHelper();
            Sheet sheet = workbook.createSheet("Data Siswa");
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            //Row ofor Header
            Row headerRow = sheet.createRow(0);

            //Header
            for(int i=0;i<columns.length;i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerCellStyle);
            }


            int rowIdx = 1;
            for(Asset asset : assets) {
                Row row = sheet.createRow(rowIdx);
                row.createCell(0).setCellValue(asset.getId());
                row.createCell(1).setCellValue(asset.getNoAssets());
                row.createCell(2).setCellValue(asset.getJenis());
                row.createCell(3).setCellValue(asset.getNama());
                row.createCell(4).setCellValue(asset.getQuantity());
                row.createCell(5).setCellValue(asset.getTanggalDiterima());
                row.createCell(6).setCellValue(asset.getTanggalInput());
                row.createCell(7).setCellValue(String.valueOf(asset.getHargaAssets()));
                row.createCell(8).setCellValue(String.valueOf(asset.getVendor()));
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