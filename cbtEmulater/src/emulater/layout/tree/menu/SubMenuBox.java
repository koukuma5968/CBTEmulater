package emulater.layout.tree.menu;

import javafx.geometry.Orientation;
import javafx.scene.layout.TilePane;

public class SubMenuBox extends TilePane {

    public SubMenuBox() {
        super(Orientation.VERTICAL);
        super.getStyleClass().add("submenu");
        init();
    }

    private void init() {

        for (SubMenuItemNames item : SubMenuItemNames.values()) {

            SubMenuItem sub = new SubMenuItem();
            sub.setItem(item);

            super.getChildren().add(sub);
        }

    }

}
