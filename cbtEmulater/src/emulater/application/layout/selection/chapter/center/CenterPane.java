package emulater.application.layout.selection.chapter.center;

import emulater.application.layout.selection.chapter.center.cert.CertificationPane;
import emulater.application.layout.selection.chapter.center.exam.ExaminationPane;
import emulater.application.layout.selection.chapter.center.ordinal.OrdinalPane;
import emulater.application.names.chapter.CenterPaneNames;
import emulater.util.JAXBUtil;
import emulater.xml.chapter.Chapter;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CenterPane extends VBox {

    public CenterPane() {
        super();
        super.getStyleClass().add(CenterPaneNames.VIEW.getStyleName());
        Label l = new Label("左のリストから選択");
        l.getStyleClass().add("init-title");
        super.getChildren().add(l);
    }

    public void setChapter(String path) {

        super.getChildren().clear();

        Chapter chapter = getCapterList(path);

        CertificationPane cert = new CertificationPane();
        cert.setLayout(chapter);
        super.getChildren().add(cert);

        OrdinalPane ordinal = new OrdinalPane();
        ordinal.setLayout(chapter.getOrdinal());
        super.getChildren().add(ordinal);

        ExaminationPane exam = new ExaminationPane();
        exam.setLayout(path, chapter);
        super.getChildren().add(exam);
    }

    protected Chapter getCapterList(String path) {
        return (Chapter) JAXBUtil.getXmlObject(Chapter.class, JAXBUtil.PROBLEM_ROOT + path + JAXBUtil.CHAPTER_LIST);
    }

}
