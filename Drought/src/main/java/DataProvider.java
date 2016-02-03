import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.jsoup.Jsoup.connect;

public class DataProvider {

    private String url;
    private Document doc;
    public DataProvider(String url) {

        this.url = url;
        try {
            doc = connect(this.url).get();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public Header getHeader(){
        String yearHeader;
        Header header = null;

        yearHeader = doc.select(".panel0 h2:eq(0)").text();
            header = new Header(
                    yearHeader.substring(yearHeader.indexOf(":")+2,yearHeader.indexOf(")")),
                    doc.select(".panel0 div > h3:eq(0)").text(),
                    doc.select(".panel0 div > h3:eq(0)~a:eq(1)").text(),
                    doc.select(".panel0 div > h3:eq(0)~a:eq(2)").text()
            );

        return header;
    }

    public ParsedSoilCategoryTable getSoilCategoryTable(){

        ParsedSoilCategoryTable parsedSoilCategoryTable = null;
        List<String> tableHeaders = new ArrayList<String>();
        String[][] tableContent = new String[4][4];

            for (int i = 0;i<4;i++){
                for (int j = 0;j<3;j++){
                    if(i==0)
                        tableHeaders.add(doc.select(".panel0 .gminy").select("tr:eq(" + i + ") th:eq(" + j + ")").text());

                    tableContent[i][j] = doc.select(".panel0 .gminy").select("tr:eq(" + (i+1) + ") td:eq(" + (j) + ")").text();
                }
            }

        return new ParsedSoilCategoryTable(tableHeaders,tableContent);
    }
}
