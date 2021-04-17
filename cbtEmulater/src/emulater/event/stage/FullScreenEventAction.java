package emulater.event.stage;

import emulater.application.layout.selection.menu.right.ExpansionButton;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
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

                if (event.getSource() instanceof ExpansionButton || event.getClickCount() == 2) {
                    screenChange();
                }

                return Boolean.TRUE;
            }

            private void screenChange() {
                Stage stage = (Stage) ((Region) event.getSource()).getScene().getWindow();
                Platform.runLater(()-> stage.setFullScreen(stage.isFullScreen() ? false:true));
            }
        };

    }

}
