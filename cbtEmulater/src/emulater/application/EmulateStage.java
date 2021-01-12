package emulater.application;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import emulater.layout.EmulateBorder;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class EmulateStage extends Application {

	public EmulateStage() {
		super();
	}

	@SuppressWarnings("exports")
	@Override
	public void start(Stage stage) throws Exception {

		EmulateBorder pane = new EmulateBorder();

		Scene scene = new Scene(pane);
		ObservableList<String> style = scene.getStylesheets();
		style.clear();
		Path path = Paths.get("prop/css/");
		File css = path.toFile().getAbsoluteFile();
		for (File f : css.listFiles()) {
			style.addAll(f.toURI().toString());
		}

		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

		stage.show();
	}

}
