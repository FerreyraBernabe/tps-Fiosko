
package tpsfiosko;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;


public class ExcelWriter {

    public static void inicializarExcel(ArrayList<Venta> ventas, String rutaExcelVentas) {
        File file = new File(rutaExcelVentas);
        Workbook workbook;
        Sheet sheet;
        boolean archivoNuevo = !file.exists();

        try {
            // Crear carpeta padre si no existe
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            if (archivoNuevo) {
                // Crear libro nuevo
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Ventas");

                // Cabeceras
                Row header = sheet.createRow(0);
                header.createCell(0).setCellValue("IdVentaTPS");
                header.createCell(1).setCellValue("FechaHora");
                header.createCell(2).setCellValue("Producto");
                header.createCell(3).setCellValue("Monto");

            } else {
                // Abrir existente
                try (FileInputStream fis = new FileInputStream(file)) {
                    workbook = WorkbookFactory.create(fis);
                }
                sheet = workbook.getSheetAt(0);
                if (sheet == null) {
                    sheet = workbook.createSheet("Ventas");
                }
            }

            // Buscar la próxima fila libre
            int rowNum = sheet.getLastRowNum();
            if (archivoNuevo && rowNum == 0 && sheet.getPhysicalNumberOfRows() == 1) {
                // Sólo header
                rowNum = 1;
            } else {
                rowNum = rowNum + 1;
            }

            // Escribir todas las ventas
            for (Venta v : ventas) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(v.getId());
                row.createCell(1).setCellValue(v.getFecha());
                row.createCell(2).setCellValue(v.getProducto().getNombre());
                row.createCell(3).setCellValue(v.getMonto());
            }

            // Guardar
            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
            }
            workbook.close();

            System.out.println("Ventas guardadas en: " + rutaExcelVentas);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void agregarVenta(Venta v) 
    {
        File file = new File(Config.LeerRutaVentas());
        Workbook workbook;
        Sheet sheet;
        boolean archivoNuevo = !file.exists();

        try {
            // Crear carpeta padre si no existe
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            if (archivoNuevo) {
                // Crear libro nuevo y hoja
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Ventas");

                // Cabeceras
                Row header = sheet.createRow(0);
                header.createCell(0).setCellValue("IdVentaTPS");
                header.createCell(1).setCellValue("FechaHora");
                header.createCell(2).setCellValue("Producto");
                header.createCell(3).setCellValue("Monto");

            } else {
                // Abrir libro existente
                try (FileInputStream fis = new FileInputStream(file)) {
                    workbook = WorkbookFactory.create(fis);
                }
                sheet = workbook.getSheetAt(0);
                if (sheet == null) {
                    sheet = workbook.createSheet("Ventas");
                }
            }

            // Próxima fila libre
            int rowNum;
            if (archivoNuevo && sheet.getPhysicalNumberOfRows() == 1) {
                // Sólo header
                rowNum = 1;
            } else {
                rowNum = sheet.getLastRowNum() + 1;
            }

            // Crear la fila de la venta
            Row row = sheet.createRow(rowNum);

            row.createCell(0).setCellValue(v.getId());
            row.createCell(1).setCellValue(v.getFecha());
            row.createCell(2).setCellValue(v.getProducto().getNombre());
            row.createCell(3).setCellValue(v.getMonto());
            
            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
            }
            workbook.close();

            System.out.println("Venta agregada en: " + Config.LeerRutaVentas());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

