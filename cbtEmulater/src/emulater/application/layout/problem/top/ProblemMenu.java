package emulater.application.layout.problem.top;

import emulater.application.layout.chapter.center.exam.ExecutionBox;
import emulater.application.names.problem.ProblemItem;
import javafx.scene.layout.HBox;

public class ProblemMenu extends HBox {

    public ProblemMenu() {
        super();
        super.getStyleClass().add(ProblemItem.MENU_VIEW.getStyleName());
    }

    public void setMenu(ExecutionBox exe) {

        CertificationName certName = new CertificationName();
        certName.setCertName(exe.getName());

        super.getChildren().add(certName);

        TimerPane timer = new TimerPane();
        timer.setCounter(exe.getTime());

        super.getChildren().add(timer);

    }
}
