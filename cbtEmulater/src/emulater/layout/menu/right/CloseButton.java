package emulater.layout.menu.right;

import javafx.application.Platform;
import javafx.scene.control.Button;

public class CloseButton extends Button {

    public CloseButton() {
        super();
        init();
    }

    private void init() {

        super.getStyleClass().add("close-button");
        super.setText("✕");
//        super.setPrefWidth(60);
//        super.setPrefHeight(40);
        super.setOnAction(e -> {
            Platform.exit();
            System.exit(0);
        });

    }
}
