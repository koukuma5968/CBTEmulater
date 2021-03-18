package emulater.layout.menu.right;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ReductionButton extends Button {

    public ReductionButton() {
        super();
        init();
    }

    private void init() {

        super.setText("―");
        super.getStyleClass().add("reduction-button");
        super.setOnMouseClicked(event -> {

            Stage stage = (Stage) ((ReductionButton) event.getSource()).getScene().getWindow();
            if (stage.isIconified()) {
                stage.setIconified(false);
            } else {
                stage.setIconified(true);
            }
        });
    }
}
