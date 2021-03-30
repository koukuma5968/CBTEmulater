package emulater.application.names;

public enum OrdinalItem {

    VIEW_TITLE(0, "ordinal-view"),
    TOP_TITLE(Double.MAX_VALUE, "ordinal-grid"),
    ORDINAL_HEAD(0, "ordinal-head"),
    ORDINAL_ITEM(0, "ordinal-clauesGroup"),
    ITEM_TITLE(Double.MAX_VALUE, "ordinal-title"),
    ITEM_VALUE(Double.MAX_VALUE, "ordinal-value");

    OrdinalItem(double maxWidth, String styleName) {
        this.maxWidth = maxWidth;
        this.styleName = styleName;
    }

    private double maxWidth;

    private String styleName;

    public double getMaxWidth() {
        return maxWidth;
    }

    public String getStyleName() {
        return styleName;
    }

}
