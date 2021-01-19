package emulater.layout.menu;

import javafx.application.Platform;
import javafx.scene.control.Button;

public class Topmenu extends Button {

	public Topmenu() {
		super();
		init();
	}

	private void init() {

		super.getStyleClass().add("close-button");
		super.setText("close");
		super.setOnAction(e -> {
			Platform.exit();
	        System.exit(0);
		});

	}
}
