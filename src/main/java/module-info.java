module pl.dabkowski.edprojfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;
    requires android.json;
    requires javafx.web;
    requires jakarta.persistence;

    opens pl.dabkowski.edp to javafx.fxml;
    exports pl.dabkowski.edp;
    opens pl.dabkowski.edp.gui to javafx.fxml;
    exports pl.dabkowski.edp.gui.controllers;
    opens pl.dabkowski.edp.gui.controllers to javafx.fxml;
    exports pl.dabkowski.edp.gui;
}