/**
 * Created by sczerwinski on 2016-02-03.
 */
public class SoilCategoryTableRow {
    private String category;
    private Integer area;
    private Integer share;

    public SoilCategoryTableRow(String category, Integer area, Integer share) {
        this.category = category;
        this.area = area;
        this.share = share;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }
}
