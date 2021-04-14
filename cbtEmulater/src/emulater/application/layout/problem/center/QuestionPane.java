package emulater.application.layout.problem.center;

import java.util.List;

import emulater.application.names.problem.QuestionItem;
import emulater.util.RequestCipher;
import emulater.xml.problem.Answer;
import emulater.xml.problem.Question;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class QuestionPane extends GridPane {

    public QuestionPane() {
        super();
        super.getStyleClass().add(QuestionItem.VIEW_TITLE.getStyleName());
    }

    public void initLayout(List<String> list) {

        ExplanBox explan = new ExplanBox();
        explan.setExplanText(list);

        GridPane.setConstraints(explan, 0, 0);
        super.getChildren().add(explan);

        StartLabelBox startBox = new StartLabelBox();
        startBox.setRunBox();

        GridPane.setConstraints(startBox, 0, 1);
        super.getChildren().add(startBox);

    }

    public void serLayout(Question question) {

        int count = 0;

        Label id = new Label();
        id.setText(RequestCipher.decode(question.getId()));
        GridPane.setConstraints(id, 0, count++);
        super.getChildren().add(id);

        Label statement = new Label();
        statement.setText(RequestCipher.decode(question.getStatement()));
        GridPane.setConstraints(statement, 0, count++);
        super.getChildren().add(statement);

        Label code = new Label();
        code.setText(RequestCipher.decode(question.getCode()));
        GridPane.setConstraints(code, 0, count++);
        super.getChildren().add(code);

        Label selection = new Label();
        selection.setText(RequestCipher.decode(question.getSelections()));
        GridPane.setConstraints(selection, 0, count++);
        super.getChildren().add(selection);

        for (Answer ans : question.getAnswer()) {
            Label aid = new Label();
            aid.setText(RequestCipher.decode(ans.getId()));

            Label avalue = new Label();
            avalue.setText(RequestCipher.decode(ans.getValue()));

            HBox answer = new HBox();
            answer.getChildren().add(aid);
            answer.getChildren().add(avalue);

            GridPane.setConstraints(answer, 0, count++);
            super.getChildren().add(answer);
        }

        Label solution = new Label();
        solution.setText(RequestCipher.decode(question.getSolution()));
        GridPane.setConstraints(solution, 0, count++);
        super.getChildren().add(solution);
    }
}
