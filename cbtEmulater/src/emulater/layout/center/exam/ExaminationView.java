package emulater.layout.center.exam;

import emulater.event.EventListener;
import emulater.event.exam.exe.ExecutionEventHandler;
import emulater.layout.LayoutInterface;
import emulater.layout.xml.XmlElementInterfarcee;
import emulater.layout.xml.chapter.Chapter;
import emulater.layout.xml.chapter.Examination;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ExaminationView extends HBox implements LayoutInterface {

    public ExaminationView() {
        super();
    }

    @Override
    public void setLayout(XmlElementInterfarcee xml) {

        Chapter chapter = (Chapter) xml;

        Examination exam = chapter.getExamination();

        exam.getExecution().forEach(exe -> {

            Button button = new Button();
            button.setText(exe.getTitle());

            for (EventListener event : ExecutionEventHandler.values()) {
                button.addEventHandler(event.getEventType(), event.getEvent());
            }

            super.getChildren().add(button);

        });
    }

}
