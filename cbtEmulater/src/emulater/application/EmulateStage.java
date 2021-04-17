package emulater.application;

import emulater.application.layout.problem.ProblemView;
import emulater.application.layout.problem.top.TerminationButton;
import emulater.application.layout.selection.SelectionView;
import emulater.application.layout.selection.chapter.center.exam.ExecutionBox;
import emulater.util.StyleUtil;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EmulateStage extends Application {

    public EmulateStage() {
        super();
    }

    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws Exception {

        SelectionView pane = new SelectionView();

        Scene scene = new Scene(pane);
        ObservableList<String> style = scene.getStylesheets();
        style.clear();

        StyleUtil.setStylesheetFiles(scene);

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.getIcons().add(StyleUtil.getSystemIcon());
//        stage.setMinWidth(1000);
        stage.setWidth(1000);
//        stage.setMinHeight(800);
        stage.setHeight(800);
        stage.setFullScreenExitHint("");
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        stage.show();
    }

    @SuppressWarnings("exports")
    public void problemStart(ExecutionBox exe) {

        ProblemView pane = new ProblemView();
        pane.setLayout(exe);

        Scene scene = exe.getScene();
        scene.setRoot(pane);

        Stage stage = (Stage) scene.getWindow();
        stage.setScene(scene);
        stage.setFullScreen(true);
//        stage.setFullScreenExitHint("");
//        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();

    }

    @SuppressWarnings("exports")
    public void reStart(TerminationButton term) {

        SelectionView pane = new SelectionView();

        Scene scene = term.getScene();
        scene.setRoot(pane);
        Stage stage = (Stage) scene.getWindow();
        stage.setScene(scene);
        stage.setFullScreen(false);
        stage.show();

    }
}
