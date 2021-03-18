package emulater.event.exam;

import emulater.layout.EmulateBorder;
import emulater.layout.tree.LeftView;
import emulater.layout.tree.item.QualificationList;
import emulater.layout.tree.menu.SubMenuItem;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;

public class ExaminationEventAction extends Service<Boolean> {

    public ExaminationEventAction(Event event) {
        this.event = event;
    }

    private Event event;

    @Override
    protected Task<Boolean> createTask() {

        return new Task<Boolean>() {

            @Override
            protected Boolean call() throws Exception {

                LeftView left = (LeftView) ((EmulateBorder) ((SubMenuItem) event.getSource()).getScene().getRoot()).getLeft();
                QualificationList qua = (QualificationList) left.getCenter();

                Platform.runLater(() -> qua.setCategory());

                return Boolean.TRUE;

            }
        };
    }

}
