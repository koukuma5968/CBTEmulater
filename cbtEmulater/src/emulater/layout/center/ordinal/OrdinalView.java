package emulater.layout.center.ordinal;

import emulater.layout.LayoutInterface;
import emulater.layout.xml.XmlElementInterfarcee;
import emulater.layout.xml.chapter.Chapter;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class OrdinalView extends VBox implements LayoutInterface {

    public OrdinalView() {
        super();
        super.getStyleClass().add("ordinal-view");

    }

    @Override
    public void setLayout(XmlElementInterfarcee xml) {

        Chapter chapter = (Chapter) xml;

        GridPane grid = new GridPane();
        grid.getStyleClass().add("ordinal-grid");

        chapter.getOrdinal().forEach(ordinal -> {

            Label title = this.getContents(Double.MAX_VALUE, "ordinal-title", ordinal.getTitle());

            VBox clauesGroup = new VBox();
            clauesGroup.getStyleClass().add("ordinal-clauesGroup");
            ordinal.getClause().forEach(clause -> {
                Label value = this.getContents(Double.MAX_VALUE, "ordinal-value", "■" + clause);
                VBox.setVgrow(value, Priority.ALWAYS);
                clauesGroup.getChildren().add(value);
            });

            VBox head = new VBox();
            head.getStyleClass().add("ordinal-head");
            head.setPrefWidth(300);

            VBox.setVgrow(title, Priority.ALWAYS);
            VBox.setVgrow(clauesGroup, Priority.ALWAYS);

            head.getChildren().addAll(title, clauesGroup);

            GridPane.setHgrow(head, Priority.ALWAYS);
            GridPane.setVgrow(head, Priority.ALWAYS);

            GridPane.setConstraints(head, (ordinal.getNumber()-1)%3, (ordinal.getNumber()-1)/3);
            grid.getChildren().add(head);

        });

        AnchorPane anc = new AnchorPane();

        AnchorPane.setLeftAnchor(grid, 0d);
        AnchorPane.setRightAnchor(grid, 0d);
        anc.getChildren().add(grid);

        super.getChildren().add(anc);

        VBox.setVgrow(this, Priority.ALWAYS);

    }

}
