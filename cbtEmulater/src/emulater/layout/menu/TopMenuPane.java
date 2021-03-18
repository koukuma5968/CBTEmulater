package emulater.layout.menu;

import emulater.layout.menu.center.TopMenuItem;
import emulater.layout.menu.right.RigthPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TopMenuPane extends BorderPane {

    public TopMenuPane() {
        super();
        super.getStyleClass().add("topmenu");
        init();
        //        super.setMargin(super.getRight(), new Insets(10, 10, 10, 10));
    }

    private double dragX = 0;
    private double dragY = 0;

    private void init() {

        super.setRight(new RigthPane());
        super.setCenter(new TopMenuItem());

        super.setOnMousePressed(press -> {

            Stage stage = (Stage) ((TopMenuPane) press.getSource()).getScene().getWindow();
            dragX = stage.getX() - press.getScreenX();
            dragY = stage.getY() - press.getScreenY();

        });

        super.setOnMouseDragged(drag -> {

            if (drag.isPrimaryButtonDown()) {

                Stage stage = (Stage) ((TopMenuPane) drag.getSource()).getScene().getWindow();
                System.out.println(drag.getScreenX() + dragX);
                System.out.println(drag.getScreenY() + dragY);
                stage.setX(drag.getScreenX() + dragX);
                stage.setY(drag.getScreenY() + dragY);

            }

        });

        super.setOnMouseClicked(click -> {

        	if (click.getClickCount() == 2) {
                Stage stage = (Stage) ((TopMenuPane) click.getSource()).getScene().getWindow();
                if (stage.isFullScreen()) {
                    stage.setFullScreen(false);
                } else {
                    stage.setFullScreen(true);
                }
            }
        });
    }

}
