package emulater.application.layout.chapter;

import emulater.application.layout.chapter.center.CenterPane;
import emulater.application.layout.chapter.tree.LeftPane;
import javafx.scene.layout.BorderPane;

public class ChapterPane extends BorderPane {

    public ChapterPane() {
        super();
        super.getStyleClass().add("chapter-pane");
    }

    public void setChapter() {

        CenterPane center = new CenterPane();
        super.setCenter(center);

        LeftPane left = new LeftPane();
        super.setLeft(left);
    }

}
