package emulater.application.layout.problem.center;

import emulater.application.names.problem.QuestionItem;
import emulater.util.RequestCipher;
import emulater.xml.problem.Question;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;

public class SolutionSelectBox extends HBox {

    public SolutionSelectBox() {
        super();
        super.getStyleClass().add(QuestionItem.SOLUTION.getStyleName());
    }

    public void setSelectBox(Question question) {

        question.getAnswer().stream().forEach(ans -> {

            CheckBox check = new CheckBox();
            check.getStyleClass().add(QuestionItem.SOLUTION_CHECK.getStyleName());
            check.setText(RequestCipher.decode(ans.getId()));
            super.getChildren().add(check);

        });
    }

}
