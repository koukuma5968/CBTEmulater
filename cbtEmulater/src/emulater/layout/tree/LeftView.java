package emulater.layout.tree;

import emulater.layout.tree.item.QualificationList;
import emulater.layout.tree.menu.SubMenuBox;
import javafx.scene.layout.BorderPane;

public class LeftView extends BorderPane {

    public LeftView() {
        super();
        setSubMenuItem();
        setQualification();
    }

    private void setSubMenuItem() {

        SubMenuBox sub = new SubMenuBox();
        super.setLeft(sub);

    }

    private void setQualification() {

        QualificationList tree = new QualificationList();

        super.setCenter(tree);

    }
}
