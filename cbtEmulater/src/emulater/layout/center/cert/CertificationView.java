package emulater.layout.center.cert;

import emulater.layout.LayoutInterface;
import emulater.layout.xml.XmlElementInterfarcee;
import emulater.layout.xml.chapter.Chapter;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class CertificationView extends BorderPane implements LayoutInterface {

    public CertificationView() {
        super();
        super.getStyleClass().add("cert-view");
    }

    @Override
    public void setLayout(XmlElementInterfarcee xml) {

        Chapter chapter = (Chapter) xml;

        Label top = getContents(Double.MAX_VALUE, "cert-view-title", chapter.getCertificationTitle());
        super.setTop(this.getAnchor(top, -1d , 0d, -1d, 0d));


        GridPane grid = new GridPane();
        grid.getStyleClass().add("cert-grid");

        chapter.getCertification().forEach(cert -> {

            Label title = getContents(Double.MAX_VALUE, "cert-title", cert.getCertType().getTitle());

            Label value = getContents(Double.MAX_VALUE, "cert-value", cert.getValue());

            VBox head = new VBox();
            head.getStyleClass().add("cert-head");
            VBox.setVgrow(title, Priority.ALWAYS);
            head.getChildren().add(title);
            VBox.setVgrow(value, Priority.ALWAYS);
            head.getChildren().add(value);

            GridPane.setHgrow(head, Priority.ALWAYS);
            GridPane.setVgrow(head, Priority.ALWAYS);

            GridPane.setConstraints(head, cert.getCertType().ordinal()%3, cert.getCertType().ordinal()/3);
            grid.getChildren().add(head);

        });

        super.setCenter(grid);

    }

}
