package emulater.event.stage;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StageMoveEventAction extends Service<Boolean> {

    public StageMoveEventAction(Event event) {
        this.event = (MouseEvent) event;
    }

    private MouseEvent event;

    private static double dragX = 0;
    private static double dragY = 0;

    @Override
    protected Task<Boolean> createTask() {

        return new Task<Boolean>() {

            @Override
            protected Boolean call() throws Exception {

                Stage stage = (Stage) ((Pane) event.getSource()).getScene().getWindow();

                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {

                    dragX = stage.getX() - event.getScreenX();
                    dragY = stage.getY() - event.getScreenY();

                } else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {

                    if (event.isPrimaryButtonDown()) {
                        stage.setX(event.getScreenX() + dragX);
                        stage.setY(event.getScreenY() + dragY);
                    }

                }

                return Boolean.TRUE;
            }

        };
    }

}
