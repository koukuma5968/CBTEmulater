package emulater.layout.center.ordinal;

public enum OrdinalViewItem {

    VIEW_TITLE("cert-view-title"),
    TITLE("cert-title"),
    VALUE("cert-value");

    OrdinalViewItem(String style) {
        this.style = style;
    }

    private String style;

    public String getStyle() {
        return style;
    }

}
