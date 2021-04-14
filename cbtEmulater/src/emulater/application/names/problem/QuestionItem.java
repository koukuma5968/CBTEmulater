package emulater.application.names.problem;

public enum QuestionItem {

    VIEW_TITLE("question-view"),
    EXPLAN_BOX("explanatory-box"),
    TEXT("explanatory-text"),
    START_BOX("start-box"),
    START_TEXT("start-text"),
    RUN_BOX("run_box"),
    IMAGE("question-image"),
    RUN_BUTTON("run-button");

    private QuestionItem(String styleName) {
        this.styleName = styleName;
    }

    private String styleName;

    public String getStyleName() {
        return styleName;
    }

}
