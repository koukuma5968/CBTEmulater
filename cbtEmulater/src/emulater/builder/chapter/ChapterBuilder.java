package emulater.builder.chapter;

import java.lang.reflect.InvocationTargetException;

import emulater.builder.BuilderInterface;
import emulater.layout.LayoutInterface;
import emulater.layout.center.cert.CertificationView;
import emulater.layout.center.exam.ExaminationView;
import emulater.layout.center.ordinal.OrdinalView;
import emulater.layout.xml.XmlElementInterfarcee;
import javafx.scene.Node;

public enum ChapterBuilder implements BuilderInterface {

    CERT(CertificationView.class),
    ORDINAL(OrdinalView.class),
    EXAMINATION(ExaminationView.class);

    private ChapterBuilder(Class<? extends Node> node) {
        this.node = node;
    }

    private Class<? extends Node> node;

    @Override
    public Node getLayout(XmlElementInterfarcee xml) {

        LayoutInterface layout = null;

        try {

            layout = (LayoutInterface) this.node.getDeclaredConstructor().newInstance();
            layout.setLayout(xml);

        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }

        return (Node) layout;

    }
}
