package emulater.event.problem.question;

import java.time.LocalTime;

import emulater.application.layout.problem.ProblemView;
import emulater.application.layout.problem.bottom.StartLabelBox;
import emulater.application.layout.problem.top.ProblemMenu;
import emulater.application.layout.problem.top.TimerPane;
import emulater.util.Constant;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class QuestionStartEventAction extends Service<Boolean> {

    public QuestionStartEventAction(Event event) {
        this.event = event;
    }

    private Event event;

    @Override
    protected Task<Boolean> createTask() {

        return new Task<Boolean>() {

            @Override
            protected Boolean call() throws Exception {

                StartLabelBox startbox = (StartLabelBox) event.getSource();
                ProblemView view = (ProblemView) startbox.getParent();
                TimerPane timerpane = (TimerPane) ((ProblemMenu) view.getTop()).getChildren().get(1);

                Platform.runLater(()-> {
                    view.setNext();
                    Timeline timeline = timerpane.getTimeline();
                    timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), (event -> {
                        Text text = (Text) timerpane.getChildren().get(1);
                        LocalTime timer = timerpane.getTimer().minusSeconds(1l);
                        if (timer.getHour() == 12 && timer.getMinute() == 0 && timer.getSecond() == 0) {
                            GradingEventAction action = new GradingEventAction(event);
                            action.start();
                        } else {
                            timerpane.setTimer(timer);
                            text.setText(timerpane.getTimer().format(Constant.TIME_FORMAT));
                        }
                    })));
                    timeline.play();
                });

                return Boolean.TRUE;

            }

        };
    }

}
