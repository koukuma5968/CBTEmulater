package emulater.application.layout.grad.center;

import emulater.application.layout.grad.top.ReviewCloseButton;
import emulater.application.layout.problem.center.QuestionPane;
import emulater.application.layout.problem.center.SolutionSelectBox;
import emulater.event.EventListener;
import emulater.event.stage.TopMenuEventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class ReviewPane extends BorderPane {

    public void setReview(QuestionPane que) {

        ReviewCloseButton close = new ReviewCloseButton();
        close.setButton();

        AnchorPane anc = new AnchorPane();
        AnchorPane.setRightAnchor(close, 10d);
        AnchorPane.setTopAnchor(close, 10d);
        AnchorPane.setBottomAnchor(close, 10d);
        anc.getChildren().add(close);

        for (EventListener handler : TopMenuEventHandler.values()) {
            anc.addEventHandler(handler.getEventType(), handler.getEvent());
        }

        super.setTop(anc);

        SolutionSelectBox solBox = (SolutionSelectBox) que.getBottom();
        solBox.getChildren().forEach(check -> {
            ((CheckBox) check).setDisable(true);
        });

        super.setCenter(que);

    }
}
