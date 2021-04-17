package emulater.event.problem.question;

import emulater.event.EventListener;
import emulater.event.problem.term.TerminationEventAction;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public enum QuestionStartEventHandler implements EventListener {

    KEY_PRES(KeyEvent.KEY_PRESSED),
    MOUSE_CLICK(MouseEvent.MOUSE_CLICKED);

    private QuestionStartEventHandler(EventType<? extends Event> type) {
        this.type = type;
    }

    private EventType<? extends Event> type;

    @Override
    public EventType<? extends Event> getEventType() {
        return this.type;
    }

    @Override
    public EventHandler<Event> getEvent() {

        EventHandler<Event> handler = (event-> {
            TerminationEventAction action = new TerminationEventAction(event);
            action.start();
        });

        return handler;
    }
}
