import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class DataProvider {

    private String url;

    public DataProvider(String url) {
        this.url = url;
    }

    public ParsedData getData(){

        ParsedData parsedData = null;
        try {
            Document doc = Jsoup.connect(this.url).get();
            parsedData = new ParsedData(
                    //doc.select("h3:contains(Gmina)"),
                    doc.select(".panel0 div > h3:eq(0)"),
                    doc.select(".panel0 div > h3:eq(0)~a:eq(1)"),
                    doc.select(".panel0 div > h3:eq(0)~a:eq(2)"),
                    doc.select(".panel0 .gminy")
            );

        }catch(IOException e){
            e.printStackTrace();
        }
        return parsedData;
    }
}
