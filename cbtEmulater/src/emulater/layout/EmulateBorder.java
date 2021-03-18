package emulater.layout;

import emulater.layout.center.ChapterView;
import emulater.layout.menu.TopMenuPane;
import emulater.layout.tree.LeftView;
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
        TopMenuPane top = new TopMenuPane();
        super.setTop(top);
    }

    private void setLeft() {

        super.setLeft(new LeftView());
//        super.setMargin(super.getLeft(), new Insets(0, 10, 0, 0));
    }

    private void setCenter() {
        super.setCenter(new ChapterView());
    }

    public void setItemView(String Path) {
        ((ChapterView) super.getCenter()).setChapter(Path);
    }

}
