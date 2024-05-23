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
    requires mysql.connector.j;

    opens org.unibl.etf.epopis to javafx.fxml;
    opens org.unibl.etf.epopis.gui.controllers.login to javafx.fxml;
    opens org.unibl.etf.epopis.gui.controllers.admin to javafx.fxml;
    opens org.unibl.etf.epopis.gui.controllers.potrosac to javafx.fxml;
    opens org.unibl.etf.epopis.gui.controllers.distributer to javafx.fxml;
    opens org.unibl.etf.epopis.gui.controllers.knjigovodja to javafx.fxml;
    opens org.unibl.etf.epopis.gui.controllers.elektricar to javafx.fxml;
    opens org.unibl.etf.epopis.gui.controllers.login.menu to javafx.fxml;

    exports org.unibl.etf.epopis;
    exports org.unibl.etf.epopis.gui to javafx.graphics;
    exports org.unibl.etf.epopis.gui.controllers.login to javafx.graphics, javafx.fxml;
    exports org.unibl.etf.epopis.gui.controllers.admin to javafx.graphics, javafx.fxml;
    exports org.unibl.etf.epopis.gui.controllers.potrosac to javafx.graphics, javafx.fxml;
    exports org.unibl.etf.epopis.gui.controllers.distributer to javafx.graphics, javafx.fxml;
    exports org.unibl.etf.epopis.gui.controllers.knjigovodja to javafx.graphics, javafx.fxml;
    exports org.unibl.etf.epopis.gui.controllers.elektricar to javafx.graphics, javafx.fxml;

    exports org.unibl.etf.epopis.gui.controllers.login.menu to javafx.fxml;
}