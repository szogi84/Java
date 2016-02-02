import org.jsoup.select.Elements;

public class ParsedData {

    private org.jsoup.select.Elements header = null;
    private org.jsoup.select.Elements province = null;
    private org.jsoup.select.Elements district = null;
    private org.jsoup.select.Elements soilCategoryTable = null;

    public ParsedData(Elements header, Elements province, Elements district, Elements soilCategoryTable) {
        this.header = header;
        this.province = province;
        this.district = district;
        this.soilCategoryTable = soilCategoryTable;
    }

    public Elements getSoilCategoryTable() {
        return soilCategoryTable;
    }

    public void setSoilCategoryTable(Elements soilCategoryTable) {
        this.soilCategoryTable = soilCategoryTable;
    }

    public Elements getHeader() {
        return header;
    }

    public void setHeader(Elements header) {
        this.header = header;
    }

    public Elements getProvince() {
        return province;
    }

    public void setProvince(Elements province) {
        this.province = province;
    }

    public Elements getDistrict() {
        return district;
    }

    public void setDistrict(Elements district) {
        this.district = district;
    }
}
