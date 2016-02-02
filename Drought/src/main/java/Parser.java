import com.aspose.cells.*;

/**
 * Created by sczerwinski on 2016-02-02.
 */
public class Parser {
    public static void main(String[] args) {

        DataProvider dataProvider = new DataProvider("http://susza.iung.pulawy.pl/tabele/0201011/");
        ParsedData parsedData = dataProvider.getData();

        System.out.println("Header: " + parsedData.getHeader().text());
        System.out.println("Wojewodztwo: " + parsedData.getProvince().text());
        System.out.println("Powiat: " + parsedData.getDistrict().text());
        //System.out.println("Soil category table: " + parsedData.getSoilCategoryTable().toString());

////Instantiate the workbook object
//        Workbook workbook = new Workbook();
//
////Get first worksheet of workbook
//        Worksheet worksheet1 = workbook.getWorksheets().get(0);
//
////Get Cells in a Worksheet
//        Cells cells = worksheet1.getCells();
//
////Get the individual cell
//        Cell cell = cells.get("A1");
//
//        String htmlstring = parsedData.getSoilCategoryTable().toString();
//
////Setting Cell Style
//        Style style = new Style();
//        style.setHorizontalAlignment(TextAlignmentType.LEFT);
//        style.setTextWrapped(true);
//        cell.setStyle(style);
//
////Set HTML string as Cell Text
//        cell.setHtmlString(htmlstring);
//
//        //worksheet1.autoFitColumns();
////        worksheet1.autoFitRows();
//
////Save the workbook.
//        try {
//            workbook.save("c:\\Sandbox\\HtmlStringtest.xlsx");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
