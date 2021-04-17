package emulater.event.exam;

import emulater.application.layout.selection.SelectionView;
import emulater.application.layout.selection.chapter.tree.LeftPane;
import emulater.application.layout.selection.chapter.tree.item.QualificationList;
import emulater.application.layout.selection.chapter.tree.menu.SubMenuItem;
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

                LeftPane left = (LeftPane) ((SelectionView) ((SubMenuItem) event.getSource()).getScene().getRoot()).getLeft();
                QualificationList qua = (QualificationList) left.getCenter();

                Platform.runLater(() -> qua.setCategory());

                return Boolean.TRUE;

            }
        };
    }

}
