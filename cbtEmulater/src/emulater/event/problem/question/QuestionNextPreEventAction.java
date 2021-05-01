package emulater.event.problem.question;

import emulater.application.layout.problem.ProblemView;
import emulater.application.layout.problem.bottom.NextPreviousBox;
import emulater.application.layout.problem.bottom.NextPreviousButton;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;

public class QuestionNextPreEventAction extends Service<Boolean> {

    public QuestionNextPreEventAction(Event event) {
        this.event = event;
    }

    private Event event;

    @Override
    protected Task<Boolean> createTask() {

        return new Task<Boolean>() {

            @Override
            protected Boolean call() throws Exception {

                NextPreviousButton npButton = (NextPreviousButton) event.getSource();
                ProblemView view = (ProblemView) ((NextPreviousBox) npButton.getParent()).getParent();

                Platform.runLater(()-> {

                    switch (npButton.getBoxStyle()) {

                        case PRE_BOX :
                            view.setPrevious();
                            break;

                        case NEXT_BOX :
                            view.setNext();
                            break;

                        default:
                            break;
                    }
                });

                return Boolean.TRUE;

            }

        };
    }

}
