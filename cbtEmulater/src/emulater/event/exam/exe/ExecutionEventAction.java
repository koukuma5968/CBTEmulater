package emulater.event.exam.exe;

import emulater.application.ProblemStatge;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;

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

                new ProblemStatge().start();

                return Boolean.TRUE;

            }
        };
    }

}
