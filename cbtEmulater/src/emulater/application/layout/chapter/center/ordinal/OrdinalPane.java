package emulater.application.layout.chapter.center.ordinal;

import java.util.List;

import emulater.application.names.chapter.OrdinalItem;
import emulater.xml.chapter.Ordinal;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class OrdinalPane extends VBox {

    public OrdinalPane() {
        super();
        super.getStyleClass().add(OrdinalItem.VIEW_TITLE.getStyleName());

    }

    public void setLayout(List<Ordinal> ordinalList) {

        super.getChildren().add(getheader(ordinalList));

        VBox.setVgrow(this, Priority.ALWAYS);

    }

    private AnchorPane getheader(List<Ordinal> ordinalList) {

        GridPane grid = new GridPane();
        grid.getStyleClass().add(OrdinalItem.TOP_TITLE.getStyleName());

        ordinalList.forEach(ordinal -> {

            VBox head = new VBox();
            head.getStyleClass().add(OrdinalItem.ORDINAL_HEAD.getStyleName());
            head.setPrefWidth(300);

            VBox clauesGroup = new VBox();
            clauesGroup.getStyleClass().add(OrdinalItem.ORDINAL_ITEM.getStyleName());
            ordinal.getClause().forEach(clause -> {
                clauesGroup.getChildren().add(getContents(OrdinalItem.ITEM_VALUE, "■" + clause));
            });
            VBox.setVgrow(clauesGroup, Priority.ALWAYS);

            head.getChildren().addAll(getContents(OrdinalItem.ITEM_TITLE, ordinal.getTitle()), clauesGroup);

            GridPane.setHgrow(head, Priority.ALWAYS);
            GridPane.setVgrow(head, Priority.ALWAYS);

            GridPane.setConstraints(head, (ordinal.getNumber()-1)%4, (ordinal.getNumber()-1)/4);
            grid.getChildren().add(head);

        });

        AnchorPane anc = new AnchorPane();

        AnchorPane.setLeftAnchor(grid, 0d);
        AnchorPane.setRightAnchor(grid, 0d);
        anc.getChildren().add(grid);

        return anc;

    }

    private Label getContents(OrdinalItem item, String value) {

        Label l = new Label();
        l.getStyleClass().add(item.getStyleName());
        l.setMaxWidth(item.getMaxWidth());
        l.setText(value);

        VBox.setVgrow(l, Priority.ALWAYS);

        return l;
    }

}
