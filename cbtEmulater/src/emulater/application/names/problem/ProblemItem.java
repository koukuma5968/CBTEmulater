package emulater.application.names.problem;

public enum ProblemItem {

    VIEW_TITLE("problem-view"),
    MENU_VIEW("problem-menu");

    private ProblemItem(String styleName) {
        this.styleName = styleName;
    }

    private String styleName;

    public String getStyleName() {
        return styleName;
    }

}
