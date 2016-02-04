import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.jsoup.Jsoup.connect;

public class DataProvider {

    private String url;
    private Document doc;
    List<String> headers = new ArrayList<String>();

    public DataProvider(String url) {

        this.url = url;
        try {
            doc = connect(this.url).get();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public List<String> getHeaders(){

        String yearHeader;
        yearHeader = doc.select(".panel0 h2:eq(0)").text();

//        headers.add(yearHeader.substring(yearHeader.indexOf(":")+2,yearHeader.indexOf(")")));
//        headers.add(doc.select(".panel0 div > h3:eq(0)").text());
//        headers.add(doc.select(".panel0 div > h3:eq(0)~a:eq(1)").text());
//        headers.add(doc.select(".panel0 div > h3:eq(0)~a:eq(2)").text());
        headers.add("Rok");
        headers.add("Wojewdztwo");
        headers.add("Gmina");
        headers.add("Powiat");

        for (int j=0;j<3;j++){
            headers.add(doc.select(".panel0 .gminy").select("tr:eq(0) th:eq(" + j +")").text());
        }
        return headers;
    }

    public List<String> getLocationInfo(){
        String yearHeader;
        yearHeader = doc.select(".panel0 h2:eq(0)").text();
        List<String> locationInfoList = new ArrayList<String>();
        locationInfoList.add(yearHeader.substring(yearHeader.indexOf(":")+2,yearHeader.indexOf(")")));
        locationInfoList.add(doc.select(".panel0 div > h3:eq(0)~a:eq(1)").text());
        locationInfoList.add(doc.select(".panel0 div > h3:eq(0)").text());
        locationInfoList.add(doc.select(".panel0 div > h3:eq(0)~a:eq(2)").text());

        return locationInfoList;
    }

    public ParsedSoilCategoryTable getSoilCategoryTable(){

        ParsedSoilCategoryTable parsedSoilCategoryTable = null;
        List<String> tableHeaders = new ArrayList<String>();
        String[][] tableContent = new String[4][4];

            for (int i = 0;i<4;i++){
                for (int j = 0;j<3;j++){
//                    if(i==0)
//                        tableHeaders.add(doc.select(".panel0 .gminy").select("tr:eq(" + i + ") th:eq(" + j + ")").text());

                    tableContent[i][j] = doc.select(".panel0 .gminy").select("tr:eq(" + (i+1) + ") td:eq(" + (j) + ")").text();
                }
            }

        return new ParsedSoilCategoryTable(tableHeaders,tableContent);
    }
}
