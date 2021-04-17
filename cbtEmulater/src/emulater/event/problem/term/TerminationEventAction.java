package emulater.event.problem.term;

import emulater.application.EmulateStage;
import emulater.application.layout.problem.top.TerminationButton;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;

public class TerminationEventAction extends Service<Boolean> {

    public TerminationEventAction(Event event) {
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
                    EmulateStage preStage = new EmulateStage();
                    preStage.reStart(term);
                });

                return Boolean.TRUE;

            }

        };
    }

}
