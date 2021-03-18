package emulater.layout.center;

import emulater.builder.BuilderInterface;
import emulater.builder.chapter.ChapterBuilder;
import emulater.layout.xml.chapter.Chapter;
import emulater.util.JAXBUtil;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ChapterView extends VBox {

    public ChapterView() {
        super();
        super.getStyleClass().add("chapter-view");
        Label l = new Label("左のリストから選択");
        l.getStyleClass().add("init-title");
        super.getChildren().add(l);
    }

    public void setChapter(String path) {

        super.getChildren().clear();

        Chapter chapter = getCapterList(path);

        for (BuilderInterface builder : ChapterBuilder.values()) {
            Node layout = builder.getLayout(chapter);
            super.getChildren().add(layout);
        }

    }

    protected Chapter getCapterList(String path) {
        return (Chapter) JAXBUtil.getXmlObject(Chapter.class, "prop/problem/" + path + "/chapter/ChapterList.xml");
    }

}
