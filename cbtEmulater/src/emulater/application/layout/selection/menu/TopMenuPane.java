package emulater.application.layout.selection.menu;

import emulater.application.layout.selection.menu.center.EmulaterTitle;
import emulater.application.layout.selection.menu.right.RigthPane;
import emulater.application.names.chapter.TopMenuItemNames;
import emulater.event.EventListener;
import emulater.event.stage.TopMenuEventHandler;
import javafx.scene.layout.BorderPane;

public class TopMenuPane extends BorderPane {

    public TopMenuPane() {
        super();
        super.getStyleClass().add(TopMenuItemNames.MENU.getStyleName());
        init();
    }

    private void init() {

        super.setRight(new RigthPane());
        super.setLeft(new EmulaterTitle());

        for (EventListener event : TopMenuEventHandler.values()) {
            super.addEventHandler(event.getEventType(), event.getEvent());
        }
    }

}
