package emulater.application;

import emulater.layout.problem.ProblemView;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class ProblemStatge {

    public void start() {

        ProblemView pane = new ProblemView();

        Scene scene = new Scene(pane);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.showAndWait();

    }

}
