package emulater.application.layout.problem;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import emulater.application.layout.chapter.center.exam.ExecutionBox;
import emulater.application.layout.problem.center.QuestionPane;
import emulater.application.layout.problem.top.ProblemMenu;
import emulater.application.names.problem.ProblemItem;
import emulater.util.FileUtile;
import emulater.xml.problem.Problem;
import javafx.scene.layout.BorderPane;

public class ProblemView extends BorderPane {

    private List<Problem> problem = null;

    public ProblemView() {
        super();
        super.getStyleClass().add(ProblemItem.VIEW_TITLE.getStyleName());
    }

    public void setLayout(ExecutionBox exe) {

        ProblemMenu menu = new ProblemMenu();
        menu.setMenu(exe);

        super.setTop(menu);

        Path failePath = Paths.get(exe.getPath());
        File files = failePath.toFile().getAbsoluteFile();

        this.problem = new ArrayList<Problem>();

        for (File f : files.listFiles()) {
            problem.add((Problem) FileUtile.readProblemFile(Problem.class, f.getPath()));
        }

        QuestionPane que = new QuestionPane();
        que.initLayout(exe.getExplanatory());

        super.setCenter(que);

    }

}
