package emulater.util;

import java.io.File;
import java.net.URL;

import javafx.collections.ObservableList;
import javafx.scene.Scene;

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
}
