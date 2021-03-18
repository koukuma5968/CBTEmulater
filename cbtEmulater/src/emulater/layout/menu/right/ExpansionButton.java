package emulater.layout.menu.right;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ExpansionButton extends Button {

    public ExpansionButton() {
        super();
        init();
    }

    private void init() {

        super.setText("□");
        super.getStyleClass().add("expansion-button");
        super.setOnMouseClicked(event -> {

            Stage stage = (Stage) ((ExpansionButton) event.getSource()).getScene().getWindow();
            if (stage.isFullScreen()) {
                stage.setFullScreen(false);
            } else {
                stage.setFullScreen(true);
            }
        });
    }
}
