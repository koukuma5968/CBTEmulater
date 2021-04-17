package emulater.application.layout.selection.chapter.tree.item;

import emulater.xml.tree.Target;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;

public class TargetItem extends TreeItem<Label> {

    private String Path;

    public TargetItem(Target target) {
        super();
        Label l = new Label();
        l.getStyleClass().add("target-item");
        l.setText(target.getName());
        super.setValue(l);

        setPath(target.getPath());
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }
}
