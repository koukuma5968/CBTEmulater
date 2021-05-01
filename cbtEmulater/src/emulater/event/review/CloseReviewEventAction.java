package emulater.event.review;

import emulater.application.EmulateStage;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;

public class CloseReviewEventAction extends Service<Boolean> {

    public CloseReviewEventAction(Event event) {
        this.event = event;
    }

    private Event event;

    @Override
    protected Task<Boolean> createTask() {

        return new Task<Boolean>() {

            @Override
            protected Boolean call() throws Exception {

                Platform.runLater(()-> {
                    EmulateStage.closeReview();
                });
                return Boolean.TRUE;

            }

        };
    }

}
