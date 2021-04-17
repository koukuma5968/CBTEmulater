package emulater.application.layout.selection;

import emulater.application.layout.selection.chapter.center.CenterPane;
import emulater.application.layout.selection.chapter.tree.LeftPane;
import emulater.application.layout.selection.menu.TopMenuPane;
import javafx.scene.layout.BorderPane;

public class SelectionView extends BorderPane {

    public SelectionView() {
        super();
        super.getStyleClass().add("selection-pane");
        init();
    }

    private void init() {
        setMenu();
        setLeft();
        setCenter();
    }

    private void setMenu() {
        super.setTop(new TopMenuPane());
    }

    private void setLeft() {

        super.setLeft(new LeftPane());
    }

    private void setCenter() {
        super.setCenter(new CenterPane());
    }

    public void setItemView(String Path) {
        ((CenterPane) super.getCenter()).setChapter(Path);
    }

}
