package emulater.application.layout.problem.center;

import emulater.application.names.problem.QuestionItem;
import emulater.util.RequestCipher;
import emulater.xml.problem.Question;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class QuestionItemBox extends BorderPane {

    public QuestionItemBox() {
        super();
        super.getStyleClass().add(QuestionItem.QUEST_BOX.getStyleName());
    }

    public void setIrem(Question question) {

        Label statement = new Label();
        statement.getStyleClass().add(QuestionItem.STATEMENT.getStyleName());
        statement.setText(RequestCipher.decode(question.getStatement()));
        super.setTop(statement);

        String codetext = RequestCipher.decode(question.getCode());
        if (!"".equals(codetext)) {

            CodeField code = new CodeField();
            code.setCode(codetext);
            code.getStyleClass().add(QuestionItem.CODE.getStyleName());

            super.setCenter(code);

            AnswerItemBox answer  = new AnswerItemBox();
            answer.setAnswer(question.getAnswer());

            super.setBottom(answer);

        } else {
            AnswerItemBox answer  = new AnswerItemBox();
            answer.setAnswer(question.getAnswer());

            super.setCenter(answer);
        }

    }
}
