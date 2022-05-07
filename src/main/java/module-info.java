module pl.dabkowski.edprojfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;
    requires android.json;
    requires javafx.web;

    opens pl.dabkowski.edp to javafx.fxml;
    exports pl.dabkowski.edp;
    exports pl.dabkowski.edp.gui;
    opens pl.dabkowski.edp.gui to javafx.fxml;
}