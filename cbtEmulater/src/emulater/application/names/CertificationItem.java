package emulater.application.names;

public enum CertificationItem {

    VIEW_TITLE(0, "cert-view"),
    TOP_TITLE(Double.MAX_VALUE, "cert-view-title"),
    CERT_HEAD(0, "cert-head"),
    CERT_ITEM(0, "cert-item"),
    ITEM_TITLE(Double.MAX_VALUE, "cert-title"),
    ITEM_VALUE(Double.MAX_VALUE, "cert-value");

    CertificationItem(double maxWidth, String styleName) {
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
