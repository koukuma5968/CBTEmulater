package emulater.application.layout.problem;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import emulater.application.layout.grad.center.CheckAnswerPane;
import emulater.application.layout.problem.bottom.NextPreviousBox;
import emulater.application.layout.problem.bottom.StartLabelBox;
import emulater.application.layout.problem.center.QuestionPane;
import emulater.application.layout.problem.top.ProblemMenu;
import emulater.application.layout.selection.chapter.center.exam.ExecutionBox;
import emulater.application.names.problem.CheckAnswerBean;
import emulater.application.names.problem.ProblemItem;
import emulater.application.names.problem.QuestionItem;
import emulater.util.FileUtile;
import emulater.xml.problem.Problem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ProblemView extends BorderPane {

    private List<Map<String, Pane>> problemViewList = new ArrayList<Map<String, Pane>>();
    private int position = -1;
    private final String qKey = "question";
    private final String npKey = "nextprevious";

    public ProblemView() {
        super();
        super.getStyleClass().add(ProblemItem.VIEW_TITLE.getStyleName());
    }

    public void setLayout(ExecutionBox exe) {

        ProblemMenu menu = new ProblemMenu();
        menu.setMenu(exe);

        super.setTop(menu);

        initProblem(exe);

        QuestionPane que = new QuestionPane(QuestionItem.VIEW_TITLE_INI);
        que.initLayout(exe.getExplanatory());

        super.setCenter(que);

        StartLabelBox startBox = new StartLabelBox();
        startBox.setRunBox();

        super.setBottom(startBox);
    }

    private void initProblem(ExecutionBox exe) {

        Path failePath = Paths.get(exe.getPath());
        File files = failePath.toFile().getAbsoluteFile();

        List<Problem> problemList = new ArrayList<Problem>();

        for (File f : files.listFiles()) {
            problemList.add((Problem) FileUtile.readProblemFile(Problem.class, f.getPath()));
        }
        Collections.shuffle(problemList);

        int count = 0;

        Iterator<Problem> it = problemList.iterator();

        while (it.hasNext()) {

            Map<String, Pane> paneMap = new HashMap<String, Pane>();

            Problem problem = it.next();

            QuestionPane que = new QuestionPane(QuestionItem.VIEW_TITLE);
            que.setQuestion(count, problem.getQuestion());

            paneMap.put(this.qKey, que);

            NextPreviousBox npBox = new NextPreviousBox();
            npBox.setNextPrevious(count, problemList.size());

            paneMap.put(this.npKey, npBox);

            count++;

            problemViewList.add(paneMap);
        }
    }

    public void setGrading() {

        ObservableList<CheckAnswerBean> beanList = FXCollections.observableArrayList();

        problemViewList.forEach(paneMap -> {

            QuestionPane que = (QuestionPane) paneMap.get(this.qKey);
            beanList.add(que.getCheckAnswer());

        });

        CheckAnswerPane answer = new CheckAnswerPane();
        answer.setAnswer(beanList);

        AnchorPane anc = new AnchorPane();
        AnchorPane.setTopAnchor(answer, 0d);
        AnchorPane.setLeftAnchor(answer, 0d);
        AnchorPane.setRightAnchor(answer, 0d);
        AnchorPane.setBottomAnchor(answer, 0d);
        anc.getChildren().add(answer);

        super.setCenter(anc);
        super.setBottom(null);
    }

    public QuestionPane getTargetQuestion(String targetNum) {

        Stream<Map<String, Pane>> stream = problemViewList.stream().filter(paneMap -> {
            QuestionPane que = (QuestionPane) paneMap.get(this.qKey);
            String num = ((Label) que.getTop()).getText();
            return targetNum.equals(num);
        });

        return (QuestionPane) stream.findFirst().get().get(this.qKey);
    }

    public void setNext() {
        setProblem(++this.position);
    }

    public void setPrevious() {
        setProblem(--this.position);
    }

    private void setProblem(int index) {
        super.setCenter(this.problemViewList.get(index).get(this.qKey));
        super.setBottom(this.problemViewList.get(index).get(this.npKey));
    }
}
