package emulater.event.problem.question;

import emulater.application.layout.problem.ProblemView;
import emulater.application.layout.problem.bottom.GradingButton;
import emulater.application.layout.problem.bottom.NextPreviousBox;
import emulater.application.layout.problem.top.ProblemMenu;
import emulater.application.layout.problem.top.TimerPane;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;

public class GradingEventAction extends Service<Boolean> {

    public GradingEventAction(Event event) {
        this.event = event;
    }

    private Event event;

    @Override
    protected Task<Boolean> createTask() {

        return new Task<Boolean>() {

            @Override
            protected Boolean call() throws Exception {

                GradingButton gButton = (GradingButton) event.getSource();
                ProblemView view = (ProblemView) ((NextPreviousBox) gButton.getParent()).getParent();
                TimerPane timerpane = (TimerPane) ((ProblemMenu) view.getTop()).getChildren().get(1);

                Platform.runLater(()-> {
                    Timeline timeline = timerpane.getTimeline();
                    timeline.stop();
                    view.setGrading();
                });

                return Boolean.TRUE;

            }

        };
    }

}
