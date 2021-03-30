package emulater.event.exam.exe;

import emulater.application.layout.problem.ProblemView;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class ExecutionEventAction extends Service<Boolean> {

    public ExecutionEventAction(Event event) {
        this.event = event;
    }

    private Event event;

    @Override
    protected Task<Boolean> createTask() {

        return new Task<Boolean>() {

            @Override
            protected Boolean call() throws Exception {

                start();

                return Boolean.TRUE;

            }

            private void start() {

                ProblemView pane = new ProblemView();

                Scene scene = new Scene(pane);

                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setFullScreen(true);
                stage.setFullScreenExitHint("");
                stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
                stage.showAndWait();

            }

        };
    }

}
