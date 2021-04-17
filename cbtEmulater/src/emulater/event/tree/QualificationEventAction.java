package emulater.event.tree;

import emulater.application.layout.selection.SelectionView;
import emulater.application.layout.selection.chapter.tree.item.QualificationList;
import emulater.application.layout.selection.chapter.tree.item.TargetItem;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class QualificationEventAction extends Service<Boolean> {

    public QualificationEventAction(Event event) {
        this.event = event;
    }

    private Event event;

    @Override
    protected Task<Boolean> createTask() {

        return new Task<Boolean>() {

            @Override
            protected Boolean call() throws Exception {

                TreeItem<Label> item = ((QualificationList) event.getSource()).getSelectionModel().getSelectedItem();

                if (item instanceof TargetItem) {
                    if (event instanceof KeyEvent) {

                        switch(((KeyEvent) event).getCode()) {
                            case ENTER :
                                doEvent((TargetItem) item);
                                break;
                            default:
                                break;
                        }
                    } else if (event instanceof MouseEvent) {
                        if (((MouseEvent)event).getClickCount() == 2) {
                            doEvent((TargetItem) item);
                        }
                    };
                }
                return Boolean.TRUE;
            }

        };
    }

    private void doEvent(TargetItem item) {

        Platform.runLater(() -> {
            Scene scene = ((QualificationList) event.getSource()).getScene();
            SelectionView parent = (SelectionView) scene.getRoot();
            parent.setItemView(item.getPath());
        });

    }
}
