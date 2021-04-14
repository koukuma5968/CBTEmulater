package emulater.application.layout.menu.right;

import emulater.event.EventListener;
import emulater.event.expansion.ExpansionButtonEventHandler;
import javafx.scene.control.Button;

public class ExpansionButton extends Button {

    public ExpansionButton() {
        super();
        init();
    }

    private void init() {

        super.setText("□");
        super.getStyleClass().add("expansion-button");

        for (EventListener event : ExpansionButtonEventHandler.values()) {
            super.addEventHandler(event.getEventType(), event.getEvent());
        }
    }
}
