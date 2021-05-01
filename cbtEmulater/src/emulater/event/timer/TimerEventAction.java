package emulater.event.timer;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;

public class TimerEventAction extends Service<Boolean> {

    public TimerEventAction(Event event) {
        this.event = event;
    }

    private Event event;

    @Override
    protected Task<Boolean> createTask() {

        return new Task<Boolean>() {

            @Override
            protected Boolean call() throws Exception {

                event.getSource();
//                timecount.setText(now.minusSeconds(1l).format(DateTimeFormatter.ofPattern("hh時mm分ss秒")));

                return Boolean.TRUE;

            }
        };
    }

}
