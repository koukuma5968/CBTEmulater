package emulater.event.review;

import emulater.application.EmulateStage;
import emulater.application.layout.problem.ProblemView;
import emulater.application.layout.problem.center.QuestionPane;
import emulater.application.names.problem.CheckAnswerBean;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class CheckAnswerReviewEventAction extends Service<Boolean> {

    public CheckAnswerReviewEventAction(Event event) {
        this.event = event;
    }

    private Event event;

    @Override
    protected Task<Boolean> createTask() {

        return new Task<Boolean>() {

            @SuppressWarnings("unchecked")
            @Override
            protected Boolean call() throws Exception {

                if (((MouseEvent) event).getClickCount() == 2) {

                    TableView<CheckAnswerBean> table = (TableView<CheckAnswerBean>) event.getSource();

                    ProblemView view = (ProblemView) table.getScene().getRoot();
                    QuestionPane que = view.getTargetQuestion(table.getSelectionModel().getSelectedItem().getNumber());
                    EmulateStage stage = new EmulateStage();

                    if (EmulateStage.checkShowStage()) {
                        Platform.runLater(()-> {
                            stage.showReview(que);
                        });
                    }
                }
                return Boolean.TRUE;

            }

        };
    }

}
