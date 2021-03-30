package emulater.application.layout.chapter.center.exam;

import emulater.application.names.Examinationtem;
import emulater.event.EventListener;
import emulater.event.exam.exe.ExecutionEventHandler;
import emulater.xml.chapter.Examination;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ExaminationPane extends HBox {

    public ExaminationPane() {
        super();
        super.getStyleClass().add(Examinationtem.VIEW_TITLE.getStyleName());
    }

    public void setLayout(Examination exam) {

        exam.getExecution().forEach(exe -> {

            Button button = new Button();
            button.getStyleClass().add(Examinationtem.ITEM_VALUE.getStyleName());
            button.setText(exe.getTitle());

            for (EventListener event : ExecutionEventHandler.values()) {
                button.addEventHandler(event.getEventType(), event.getEvent());
            }

            super.getChildren().add(button);

        });
    }

}
