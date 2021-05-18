package emulater.event.problem.question;

import emulater.application.layout.problem.ProblemView;
import emulater.application.layout.problem.bottom.GradingButton;
import emulater.application.layout.problem.top.ProblemMenu;
import emulater.application.layout.problem.top.TimerPane;
import emulater.event.EventActionService;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.stage.Stage;

public class GradingEventAction extends EventActionService {

    @Override
    protected void doEvent() {

        ProblemView view = (ProblemView) ((GradingButton) super.getEvent().getSource()).getScene().getRoot();
        TimerPane timerpane = (TimerPane) ((ProblemMenu) view.getTop()).getChildren().get(1);
        Stage stage = (Stage) view.getScene().getWindow();

        Platform.runLater(()-> {
            Timeline timeline = timerpane.getTimeline();
            timeline.stop();
            view.setGrading();
            stage.setFullScreen(false);
        });


    }
}
