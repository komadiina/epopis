module org.unibl.etf.epopis {
    requires java.sql;

    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    requires org.apache.commons.lang3;
    requires static lombok;

    opens org.unibl.etf.epopis to javafx.fxml;
    exports org.unibl.etf.epopis;
    exports org.unibl.etf.epopis.gui to javafx.graphics;
}