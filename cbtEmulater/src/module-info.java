/**
 *
 */
/**
 * @author user
 *
 */
module cbtEmulater {
    exports emulater.application;
    requires com.sun.xml.bind;
    requires javafx.graphics;
    requires javafx.controls;
    requires java.xml.bind;
    requires javafx.base;
    requires java.desktop;
    opens emulater.layout.xml.tree;
    opens emulater.layout.xml.chapter;
    opens emulater.layout.xml.problem;
}