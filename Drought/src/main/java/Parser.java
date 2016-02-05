import enums.ReportType;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Parser {

    public static final int FIRST_ROWNUM = 0;
    final static Logger log = Logger.getLogger(Parser.class);
    public final static String TWO_DIGIT_FORMAT = "%02d";
    public final static String THREE_DIGIT_FORMAT = "%03d";

    public static void main(String[] args) {

        final String URL = "http://susza.iung.pulawy.pl";
        final String CONTEXT = "/tabele/";
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Report");

        int province;
        int district;
        int borough;
        int rownum = 0;

        for (province = 2; province <= 2; province += 2) {
            for (district = 25; district <= 80; district += 1) {
                if (districtNotFound(URL, CONTEXT, province, district) && district < 61) {
                    district = 60;
                    continue;
                } else if (districtNotFound(URL, CONTEXT, province, district)
                        && !(districtNotFound(URL, CONTEXT, province, district + 1))
                        && district >= 61) {
                    continue;
                } else if (districtNotFound(URL, CONTEXT, province, district)
                        && (districtNotFound(URL, CONTEXT, province, district + 1))
                        && district >= 61) {
                    break;
                }
                for (borough = 1; borough <= 102; borough++) {
                    DataProvider dataProvider = new DataProvider(URL + CONTEXT + String.format(TWO_DIGIT_FORMAT, province)
                            + String.format(TWO_DIGIT_FORMAT, district) + String.format(THREE_DIGIT_FORMAT, borough) +"/");

                    if (dataProvider.getLocationInfo().get(1).isEmpty())
                        continue;
                    if (rownum == 0) {
                        //TODO: use parameters to switch between the tables
                        dataProvider.fillHeadersList(ReportType.water);
                        insertHeadersInWorksheet(dataProvider, sheet);
                        rownum++;
                    }
                    String currentLocationBeingProcessed =
                            dataProvider.getLocationInfo().get(1) + ", "
                            + dataProvider.getLocationInfo().get(2) + ", "
                            + dataProvider.getLocationInfo().get(3);

                    log.info("Started processing " + currentLocationBeingProcessed);
                    rownum = insertContent(dataProvider, sheet, rownum);
                    //log.info("Finished processing " + currentLocationBeingProcessed);
                }
            }
        }
        saveFile(workbook);
    }

    private static boolean districtNotFound(String URL, String CONTEXT, int province, int district) {
        String districtUrl = URL + CONTEXT
                + String.format("%02d", province)
                + String.format("%02d", district);

        return new DataProvider(districtUrl
                + "011/").getLocationInfo().get(1).isEmpty()
                && new DataProvider(districtUrl
                + "012/").getLocationInfo().get(1).isEmpty()
                && new DataProvider(districtUrl
                + "014/").getLocationInfo().get(1).isEmpty();
    }

    private static void insertHeadersInWorksheet(DataProvider dataProvider, HSSFSheet sheet) {
        Cell cell;
        Row row = sheet.createRow(FIRST_ROWNUM);
        //for (int i = 0; i < 7; i++) {
        for (int i = 0; i < dataProvider.headers.size(); i++) {
            cell = row.createCell(i);
            cell.setCellValue(dataProvider.headers.get(i));
        }
    }

    private static int insertContent(DataProvider dataProvider, HSSFSheet sheet, int rownum) {
        Row row;
        Cell cell;
        //TODO:It shouldn't be in the place where you insert it to xls
        String[][] parsedTable = dataProvider.getWaterBalanceTable().getTableContent();

        for (int i = 0; i < parsedTable.length; i++) {
            row = sheet.createRow(rownum++);
            for (int j = 0; j < 17;j++){//dataProvider.headers.size(); j++) {
                cell = row.createCell(j);
                if (j < 4) {
                    cell.setCellValue(dataProvider.getLocationInfo().get(j));
                } else if (j >= 4) {
                    //TODO: Table should be chosen using parameter
//                    cell.setCellValue(((String)parsedTable.getTableContent()[i][j - 4]).replace(".",","));
                    cell.setCellValue((parsedTable[i][j - 4]));//.replace(".",","));

                }
            }
        }
        return rownum;
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