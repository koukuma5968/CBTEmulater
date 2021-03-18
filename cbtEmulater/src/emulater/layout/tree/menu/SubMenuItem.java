package emulater.layout.tree.menu;

import emulater.event.EventListener;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class SubMenuItem extends HBox {

    public SubMenuItem() {
        super.getStyleClass().add("submenu-item");
    }

    protected void setItem(SubMenuItemNames item) {

        ImageView itemView = new ImageView();
        itemView.getStyleClass().add(item.getStyleName());

        Label itemLabel = new Label();
        itemLabel.setText(item.getText());
        itemLabel.getStyleClass().add("sub-text");

        super.getChildren().add(itemView);
        super.getChildren().add(itemLabel);

        for (EventListener event : item.getHandler()) {
            super.addEventHandler(event.getEventType(), event.getEvent());
        }
    }

}
