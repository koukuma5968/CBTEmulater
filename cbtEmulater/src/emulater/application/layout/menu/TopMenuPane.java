package emulater.application.layout.menu;

import emulater.application.layout.menu.center.TopMenuItem;
import emulater.application.layout.menu.right.RigthPane;
import emulater.event.EventListener;
import emulater.event.stage.TopMenuEventHandler;
import javafx.scene.layout.BorderPane;

public class TopMenuPane extends BorderPane {

    public TopMenuPane() {
        super();
        super.getStyleClass().add("topmenu");
        init();
    }

    private void init() {

        super.setRight(new RigthPane());
        super.setCenter(new TopMenuItem());

        for (EventListener event : TopMenuEventHandler.values()) {
            super.addEventHandler(event.getEventType(), event.getEvent());
        }
    }

}
