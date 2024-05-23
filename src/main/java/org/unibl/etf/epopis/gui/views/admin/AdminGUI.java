package org.unibl.etf.epopis.gui.views.admin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.unibl.etf.epopis.gui.Main;
import org.unibl.etf.epopis.gui.views.GUI;

import java.io.IOException;

public class AdminGUI extends GUI {
    public AdminGUI(Stage stage) throws IOException {
        super(stage);
    }

    @Override
    protected void load() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/org/unibl/etf/epopis/admin/fx-admin-menu.fxml"));
        Scene scene = new Scene(loader.load(), 322, 650);
        this.stage.setTitle("Administratorski panel");
        this.stage.setScene(scene);
    }
}
