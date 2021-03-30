package emulater.application.layout;

import emulater.application.layout.chapter.center.CenterPane;
import emulater.application.layout.chapter.tree.LeftPane;
import emulater.application.layout.menu.TopMenuPane;
import javafx.scene.layout.BorderPane;

public class EmulateBorder extends BorderPane {

    public EmulateBorder() {
        super();
        super.getStyleClass().add("emulater-pane");
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
