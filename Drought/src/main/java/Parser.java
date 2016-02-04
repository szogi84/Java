import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class Parser {
    public static void main(String[] args) {

        DataProvider dataProvider = new DataProvider("http://susza.iung.pulawy.pl/tabele/0201011/");
        ParsedSoilCategoryTable parsedSoilCategoryTable = dataProvider.getSoilCategoryTable();
//        List<String>  = dataProvider.getHeaders();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sample sheet");


        int rownum = 0;
        Cell cell;

        Row row = sheet.createRow(rownum++);
        for (int i = 0; i<7;i++){
            cell = row.createCell(i);
            cell.setCellValue(dataProvider.getHeaders().get(i));
        }
        for (int i=0;i<4;i++){
            row = sheet.createRow(rownum++);
            for (int j=0;j<7;j++){
                cell = row.createCell(j);
                if (j<4){
                    cell.setCellValue(dataProvider.getLocationInfo().get(j));
                }
                else if (j>=4){
                    cell.setCellValue(dataProvider.getSoilCategoryTable().getTableContent()[i][j-4]);
                }

            }
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
