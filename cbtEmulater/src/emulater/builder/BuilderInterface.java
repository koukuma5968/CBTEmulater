package emulater.builder;

import emulater.layout.xml.XmlElementInterfarcee;
import javafx.scene.Node;

public interface BuilderInterface {

    public Node getLayout(XmlElementInterfarcee xml);
}
