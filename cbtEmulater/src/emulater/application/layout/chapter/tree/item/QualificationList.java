package emulater.application.layout.chapter.tree.item;

import emulater.event.tree.QualificationEventHandler;
import emulater.util.JAXBUtil;
import emulater.xml.tree.Category;
import emulater.xml.tree.Qualification;
import emulater.xml.tree.Target;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class QualificationList extends TreeView<Label> {

    public QualificationList() {

        super();
        super.getStyleClass().add("treelist-pane");
    }

    public void setCategory() {

        TreeItem<Label> root = new TreeItem<Label>();

        Qualification itemBean = (Qualification) JAXBUtil.getXmlObject(Qualification.class, "prop/menu/QualificationList.xml");

        for (Category category : itemBean.getCategory()) {

            Label catel = new Label(category.getName());
            catel.getStyleClass().add("cate-item");

            TreeItem<Label> cate = new TreeItem<Label>(catel);

            for (Target target : category.getTarget()) {

                cate.getChildren().add(new TargetItem(target));

            }

            root.getChildren().add(cate);

        }

        super.setRoot(root);
        super.setShowRoot(false);

        for (QualificationEventHandler handler : QualificationEventHandler.values()) {
            super.addEventHandler(handler.getEventType(), handler.getEvent());
        }

    }

}
