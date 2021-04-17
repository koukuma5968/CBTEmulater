package emulater.util;

import java.io.File;
import java.net.URL;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class StyleUtil {

    private static File css;

    static {
        URL url = StyleUtil.class.getResource("css/");
        css = new File(url.getFile());
    }

    public static void setStylesheetFiles(Scene scene) {

        ObservableList<String> style = scene.getStylesheets();
        style.clear();
        for (File f : css.listFiles()) {
            style.addAll(f.toURI().toString());
        }
    }

    public static Image getSystemIcon() {
        return new Image(StyleUtil.class.getResourceAsStream("icon/favicon.png"));
    }
}
