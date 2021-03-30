package emulater.application.names;

public enum Examinationtem {

    VIEW_TITLE(0, "exam-view"),
    ITEM_VALUE(Double.MAX_VALUE, "exam-button");

    Examinationtem(double maxWidth, String styleName) {
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
