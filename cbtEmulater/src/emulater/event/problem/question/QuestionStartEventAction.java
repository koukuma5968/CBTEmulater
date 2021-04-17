package emulater.event.problem.question;

import emulater.application.layout.problem.top.TerminationButton;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;

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

                TerminationButton term = (TerminationButton) event.getSource();

                Platform.runLater(()-> {
                });

                return Boolean.TRUE;

            }

        };
    }

}
