import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Parser {
    public static void main(String[] args) {

        DataProvider dataProvider = new DataProvider("http://susza.iung.pulawy.pl/tabele/0201011/");
        ParsedSoilCategoryTable parsedSoilCategoryTable = dataProvider.getSoilCategoryTable();
        Header header = dataProvider.getHeader();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sample sheet");


        int rownum = 0;

        Row row = sheet.createRow(rownum++);
        for (int i = header.; i<parsedSoilCategoryTable.getTableHeaders().size();i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(parsedSoilCategoryTable.getTableHeaders().get(i));
        }



//        for (String key : keyset) {
//            Row row = sheet.createRow(rownum++);
//            Object [] objArr = data.get(key);
//            int cellnum = 0;
//            for (Object obj : objArr) {
//                Cell cell = row.createCell(cellnum++);
//                if(obj instanceof Date)
//                    cell.setCellValue((Date)obj);
//                else if(obj instanceof Boolean)
//                    cell.setCellValue((Boolean)obj);
//                else if(obj instanceof String)
//                    cell.setCellValue((String)obj);
//                else if(obj instanceof Double)
//                    cell.setCellValue((Double)obj);
//
//            }
//        }

        try {
            FileOutputStream out =
                    new FileOutputStream(new File("C:\\Sandbox\\new.xls"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
