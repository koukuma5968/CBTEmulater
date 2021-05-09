package emulater.event.problem.term;

import emulater.application.EmulateStage;
import emulater.application.layout.problem.top.TerminationButton;
import emulater.event.EventActionService;
import javafx.application.Platform;

public class TerminationEventAction extends EventActionService {

    @Override
    protected void doEvent() {

        TerminationButton term = (TerminationButton) super.getEvent().getSource();

        Platform.runLater(()-> {
            EmulateStage preStage = new EmulateStage();
            preStage.reStart(term);
        });

    }

}
