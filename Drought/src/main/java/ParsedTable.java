import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ParsedTable {

    private List<String> tableHeaders;
    private String[][] tableContent;

    public ParsedTable(List<String> tableHeaders, String[][] tableContent) {
        this.tableHeaders = tableHeaders;
        this.tableContent = tableContent;
    }

    public List<String> getTableHeaders() {
        return tableHeaders;
    }

    public String[][] getTableContent() {
        return tableContent;
    }
}
