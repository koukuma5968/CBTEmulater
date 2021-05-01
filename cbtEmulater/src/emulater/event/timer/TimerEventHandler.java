package emulater.event.timer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;

public enum TimerEventHandler {

    ACTION(ActionEvent.ACTION);

    TimerEventHandler(EventType<ActionEvent> type) {
        this.type = type;
    }

    private EventType<ActionEvent> type;

    public EventType<ActionEvent> getEventType() {
        return this.type;
    }

    public EventHandler<ActionEvent> getEvent() {

        EventHandler<ActionEvent> handler = (event-> {
            TimerEventAction action = new TimerEventAction(event);
            action.start();
        });

        return handler;
    }

}
