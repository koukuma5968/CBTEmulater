package emulater.layout;

import emulater.layout.xml.XmlElementInterfarcee;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public interface LayoutInterface {

    public void setLayout(XmlElementInterfarcee xml);

    public default Label getContents(double maxValue, String style, String title) {

        Label contents = new Label();
        contents.setMaxWidth(maxValue);
        contents.getStyleClass().add(style);
        contents.setText(title);

        return contents;
    }

    public default AnchorPane getAnchor(Node node, Double... insets ) {

        AnchorPane anc = new AnchorPane();

        if (insets[0] != -1) {
            AnchorPane.setTopAnchor(node, insets[0]);
        }

        if (insets[1] != -1) {
            AnchorPane.setRightAnchor(node, insets[1]);
        }

        if (insets[2] != -1) {
            AnchorPane.setBottomAnchor(node, insets[2]);
        }

        if (insets[3] != -1) {
            AnchorPane.setLeftAnchor(node, insets[3]);
        }

        anc.getChildren().add(node);

        return anc;

    }

}
