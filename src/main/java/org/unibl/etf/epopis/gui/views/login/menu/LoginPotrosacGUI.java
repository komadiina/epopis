package org.unibl.etf.epopis.gui.views.login.menu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.unibl.etf.epopis.gui.Main;
import org.unibl.etf.epopis.gui.views.login.LoginGUI;

import java.io.IOException;

public class LoginPotrosacGUI extends LoginGUI {
    public LoginPotrosacGUI(Stage stage) throws IOException {
        super(stage);
    }

    @Override
    protected void load() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/org/unibl/etf/epopis/login/fx-login-potrosac-menu.fxml"));
        Scene scene = new Scene(loader.load(), 350, 187);
        this.stage.setTitle("ePopis");
        this.stage.setScene(scene);
    }
}
