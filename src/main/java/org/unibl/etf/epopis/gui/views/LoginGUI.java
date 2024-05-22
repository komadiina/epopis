package org.unibl.etf.epopis.gui.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.unibl.etf.epopis.gui.Main;

import java.io.IOException;

public class LoginGUI extends GUI {
    public LoginGUI(Stage stage) throws IOException {
        super(stage);
    }

    @Override
    protected void load() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/org/unibl/etf/epopis/fx-login-menu.fxml"));
        Scene scene = new Scene(loader.load(), 583, 311);
        this.stage.setTitle("ePopis");
        this.stage.setScene(scene);
    }
}
