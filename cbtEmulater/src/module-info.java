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
    opens emulater.xml.tree;
    opens emulater.xml.chapter;
    opens emulater.xml.problem;
    opens emulater.application.bean;
}