package emulater.application.layout.selection.chapter.tree;

import emulater.application.layout.selection.chapter.tree.item.QualificationList;
import emulater.application.layout.selection.chapter.tree.menu.SubMenuBox;
import javafx.scene.layout.BorderPane;

public class LeftPane extends BorderPane {

    public LeftPane() {
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
