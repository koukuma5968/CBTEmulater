package emulater.event.arrivals;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;

public class ArrivalsEventAction extends Service<Boolean> {

    public ArrivalsEventAction(Event event) {
        this.event = event;
    }

    private Event event;

    @Override
    protected Task<Boolean> createTask() {

        return new Task<Boolean>() {

            @Override
            protected Boolean call() throws Exception {

                return Boolean.TRUE;

            }
        };
    }

}
