package emulater.application.layout.grad.center;

import emulater.application.names.grad.CheckAnswerNames;
import emulater.application.names.problem.CheckAnswerBean;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class SolutionsNumBox extends VBox {

    public SolutionsNumBox() {
        super();
        super.getStyleClass().add(CheckAnswerNames.NUM_BOX.getStyleName());
    }

    public void setNumBox(ObservableList<CheckAnswerBean> beanList) {

        int anscount = beanList.filtered(bean -> "〇".equals(bean.getCorrection())).size();

        setLabel("正答数", CheckAnswerNames.TEXT_LABEL);

        setLabel(anscount + " / " + beanList.size() + " 問", CheckAnswerNames.NUM_LABEL);

        setLabel("正答率", CheckAnswerNames.TEXT_LABEL);

        setLabel((anscount * 100 / beanList.size()) + " %", CheckAnswerNames.NUM_LABEL);

    }

    private void setLabel(String text, CheckAnswerNames names) {

        Label label = new Label();
        label.getStyleClass().add(names.getStyleName());
        label.setText(text);

        AnchorPane anc = new AnchorPane();
        AnchorPane.setLeftAnchor(label, 50d);
        AnchorPane.setRightAnchor(label, 50d);
        anc.getChildren().add(label);

        super.getChildren().add(anc);

    }
}
