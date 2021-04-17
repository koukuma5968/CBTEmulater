package emulater.application.layout.problem.top;

import emulater.application.names.problem.TimerItem;
import emulater.xml.chapter.CertType;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class TimerPane extends HBox {

    public TimerPane() {
        super.getStyleClass().add(TimerItem.TIMER.getStyleName());
    }

    public void setCounter(String time) {

        super.getChildren().add(new Label(CertType.TIME.getTitle()));

        Text timecount = new Text();
        timecount.setText(time);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Integer.parseInt(time));
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), (event -> {
            timecount.setText(String.valueOf(Integer.parseInt(timecount.getText()) - 1));
        })));
        timeline.play();

        super.getChildren().add(timecount);
    }

}
