package emulater.event.stage;

import emulater.application.layout.menu.TopMenuPane;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FullScreenEventAction extends Service<Boolean> {

    public FullScreenEventAction(Event event) {
        this.event = (MouseEvent) event;
    }

    private MouseEvent event;

    @Override
    protected Task<Boolean> createTask() {

        return new Task<Boolean>() {

            @Override
            protected Boolean call() throws Exception {

                Stage stage = (Stage) ((TopMenuPane) event.getSource()).getScene().getWindow();

                if (event.getClickCount() == 2) {
                    if (stage.isFullScreen()) {
                        stage.setFullScreen(false);
                    } else {
                        stage.setFullScreen(true);
                    }
                }

                return Boolean.TRUE;
            }

        };
    }

}
