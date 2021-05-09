package emulater.event.review;

import emulater.application.EmulateStage;
import emulater.application.bean.CheckAnswerBean;
import emulater.application.layout.problem.ProblemView;
import emulater.application.layout.problem.center.QuestionPane;
import emulater.event.EventActionService;
import javafx.application.Platform;
import javafx.scene.control.TableView;

public class CheckAnswerReviewEventAction extends EventActionService {

    @Override
    protected void doEvent() {

        @SuppressWarnings("unchecked")
        TableView<CheckAnswerBean> table = (TableView<CheckAnswerBean>) super.getEvent().getSource();

        ProblemView view = (ProblemView) table.getScene().getRoot();
        QuestionPane que = view.getTargetQuestion(table.getSelectionModel().getSelectedItem().getNumber());
        EmulateStage stage = new EmulateStage();

        if (EmulateStage.checkShowStage()) {
            Platform.runLater(()-> {
                stage.showReview(que);
            });
        }
    }

}
