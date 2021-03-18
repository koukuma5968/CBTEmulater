package emulater.event.storage;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;

public class StorageEventAction extends Service<Boolean> {

    public StorageEventAction(Event event) {
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
