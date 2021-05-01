package emulater.application.layout.grad.top;

import emulater.application.names.problem.TerminationItem;
import emulater.event.EventListener;
import emulater.event.review.CloseReviewEventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ReviewCloseButton extends HBox {

    public ReviewCloseButton() {
        super();
        super.getStyleClass().add(TerminationItem.VIEW.getStyleName());
    }

    public void setButton() {

        ImageView image = new ImageView();
        image.getStyleClass().add(TerminationItem.IMAGE.getStyleName());
        super.getChildren().add(image);

        Label start = new Label();
        start.setText("閉じる");
        start.getStyleClass().add(TerminationItem.LABEL.getStyleName());
        super.getChildren().add(start);

        for (EventListener handler : CloseReviewEventHandler.values()) {
            super.addEventHandler(handler.getEventType(), handler.getEvent());
        }

    }
}
