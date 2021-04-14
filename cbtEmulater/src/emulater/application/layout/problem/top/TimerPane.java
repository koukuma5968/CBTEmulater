package emulater.application.layout.problem.top;

import emulater.application.names.problem.TimerItem;
import emulater.xml.chapter.CertType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TimerPane extends VBox {

    public TimerPane() {
        super.getStyleClass().add(TimerItem.TIMER.getStyleName());
    }

    public void setCounter(String time) {

        super.getChildren().add(new Label(CertType.TIME.getTitle()));

    }

}
