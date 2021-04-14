package emulater.event.exam.exe;

import emulater.application.EmulateStage;
import emulater.application.layout.chapter.center.exam.ExecutionBox;
import javafx.application.Platform;
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

                ExecutionBox exe = (ExecutionBox) event.getSource();

                Platform.runLater(()-> {
                    EmulateStage preStage = new EmulateStage();
                    preStage.problemStart(exe);
                });

                return Boolean.TRUE;

            }

        };
    }

}
