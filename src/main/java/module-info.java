module pl.dabkowski.edprojfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;
    requires android.json;


    opens pl.dabkowski.edp to javafx.fxml;
    exports pl.dabkowski.edp;
}