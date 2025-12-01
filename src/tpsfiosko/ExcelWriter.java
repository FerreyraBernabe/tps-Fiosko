
package tpsfiosko;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelWriter {
    
    public void CrearPlanilla() {
        
    String excelPath = Config.LeerRutaVentas(); 
    File file = new File(excelPath);
    Workbook workbook = null;
    Sheet sheet = null;
        try {
            // Asegurar que exista el directorio padre
            File parent = file.getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
            }

            if (file.exists() && file.isFile()) {
                // Intentar abrir el archivo existente
                try (FileInputStream fis = new FileInputStream(file)) {
                    workbook = WorkbookFactory.create(fis); // puede tirar la POIXMLException
                } catch (Exception e) {
                    // Si está corrupto o no se puede abrir, creamos uno nuevo
                    System.out.println("Archivo existente da error al abrir, se crea uno nuevo: " + e);
                    workbook = new XSSFWorkbook();
                }
            } else {
                // Si no existe, creamos uno nuevo
                workbook = new XSSFWorkbook();
            }

            // Obtener o crear hoja
            if (workbook.getNumberOfSheets() > 0) {
                sheet = workbook.getSheetAt(0);
            } else {
                sheet = workbook.createSheet("Ventas");
            }
            
            // Calcular el número de fila siguiente
            int rowNum;
            if (sheet.getPhysicalNumberOfRows() == 0) {
                rowNum = 0;
            } else {
                rowNum = sheet.getLastRowNum() + 1;
            }

            Row row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue("Venta " + rowNum);
            row.createCell(1).setCellValue(100.0 * rowNum);

            // Escribir el archivo
            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
            }

            workbook.close();
            System.out.println("Fila escrita exitosamente en " + excelPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}

