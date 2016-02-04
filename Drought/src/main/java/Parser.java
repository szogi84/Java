import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Parser {

    public static final int FIRST_ROWNUM = 0;
    final static Logger log = Logger.getLogger(Parser.class);

    public static void main(String[] args) {

        final String URL = "http://susza.iung.pulawy.pl";

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sample sheet");

        int province;
        int district;
        int borough;
        int rownum = 0;

        for (province = 2; province <= 32; province += 2) {
            for (district = 1; district <= 80; district += 1) {
                if (new DataProvider(URL + "/tabele/"
                        + String.format("%02d", province)
                        + String.format("%02d", district)
                        + "011/").getLocationInfo().get(1).isEmpty()
                        && new DataProvider(URL + "/tabele/"
                        + String.format("%02d", province)
                        + String.format("%02d", district)
                        + "012/").getLocationInfo().get(1).isEmpty())
                    continue;
                for (borough = 1; borough <= 100; borough++) {
                    DataProvider dataProvider = new DataProvider(URL + "/tabele/" + String.format("%02d", province)
                            + String.format("%02d", district) + String.format("%03d", borough) +"/");

                    if (dataProvider.getLocationInfo().get(1).isEmpty())
                        continue;
                    if (rownum == 0) {
                        insertHeadersInWorksheet(dataProvider, sheet);
                        rownum++;
                    }
                    log.info("Started processing "
                            + dataProvider.getLocationInfo().get(1) + ", "
                            + dataProvider.getLocationInfo().get(2) + ", "
                            + dataProvider.getLocationInfo().get(3));

                    Row row;
                    Cell cell;
                    for (int i = 0; i < 4; i++) {
                        row = sheet.createRow(rownum++);
                        for (int j = 0; j < 7; j++) {
                            cell = row.createCell(j);
                            if (j < 4) {
                                cell.setCellValue(dataProvider.getLocationInfo().get(j));
                            } else if (j >= 4) {
//                                Object obj = dataProvider.getSoilCategoryTable().getTableContent()[i][j - 4];//.replace(".",",");
//                                if (obj instanceof Date)
//                                    cell.setCellValue((Date) obj);
//                                else if (obj instanceof Boolean)
//                                    cell.setCellValue((Boolean) obj);
//                                else if (obj instanceof Integer)
//                                    cell.setCellValue((Integer) obj);
//                                else if (obj instanceof Double)
//                                    cell.setCellValue((Double) obj);
//                                else if (obj instanceof String)
//                                    cell.setCellValue((String) obj);

                                cell.setCellValue(((String)dataProvider.getSoilCategoryTable().getTableContent()[i][j - 4]).replace(".",","));
                            }

                        }
                    }
                    log.info("Finished processing "
                            + dataProvider.getLocationInfo().get(1) + ", "
                            + dataProvider.getLocationInfo().get(2) + ", "
                            + dataProvider.getLocationInfo().get(3));

                }
            }
        }
        saveFile(workbook);
    }

    private static void insertHeadersInWorksheet(DataProvider dataProvider, HSSFSheet sheet) {
        Cell cell;
        Row row = sheet.createRow(FIRST_ROWNUM);
        for (int i = 0; i < 7; i++) {
            cell = row.createCell(i);
            cell.setCellValue(dataProvider.getHeaders().get(i));
        }
    }

    private static void saveFile(HSSFWorkbook workbook) {
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