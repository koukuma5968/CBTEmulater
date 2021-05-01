package emulater.application.layout.problem.center;

import java.util.List;

import emulater.application.names.problem.CheckAnswerBean;
import emulater.application.names.problem.QuestionItem;
import emulater.util.RequestCipher;
import emulater.xml.problem.Question;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;

public class QuestionPane extends BorderPane {

    private String solution = null;

    public QuestionPane(QuestionItem style) {
        super();
        super.getStyleClass().add(style.getStyleName());
    }

    public void initLayout(List<String> list) {

        ExplanBox explan = new ExplanBox();
        explan.setExplanText(list);

        super.setCenter(explan);

    }

    public void setQuestion(int index, Question question) {

        Label number = new Label();
        number.getStyleClass().add(QuestionItem.QUEST_NUM.getStyleName());
        number.setText("問" + (index + 1));

        super.setTop(number);

        QuestionItemBox box = new QuestionItemBox();
        box.setIrem(question);

        ScrollPane sc = new ScrollPane();
        sc.setContent(box);
        sc.setFitToHeight(true);
        sc.setFitToWidth(true);

        super.setCenter(sc);

        solution = RequestCipher.decode(question.getSolution());

        SolutionSelectBox solution = new SolutionSelectBox();
        solution.setSelectBox(question);

        super.setBottom(solution);

    }

    public CheckAnswerBean getCheckAnswer() {

        CheckAnswerBean bean = new CheckAnswerBean();

        bean.setNumber(((Label) super.getTop()).getText());
        bean.setSolution(this.solution);

        SolutionSelectBox select = (SolutionSelectBox) super.getBottom();

        StringBuilder userSel = new StringBuilder();

        select.getChildren().forEach(node -> {

            CheckBox check = (CheckBox) node;
            if (check.isSelected()) {
                userSel.append(check.getText());
                userSel.append(",");

            }

        });

        if (userSel.length() != 0) {
            userSel.deleteCharAt(userSel.length() - 1);
        }

        bean.setCorrection(this.solution.equals(userSel.toString()));
        bean.setUserSel(userSel.toString());

        return bean;
    }
}
