package org.unibl.etf.epopis.gui.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.unibl.etf.epopis.gui.Main;

import java.io.IOException;
import java.net.URL;

public class PotrosacGUI extends GUI {
    public PotrosacGUI(Stage stage) throws IOException {
        super(stage);
    }

    @Override
    protected void load() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/org/unibl/etf/epopis/fx-potrosac-menu.fxml"));
        Scene scene = new Scene(loader.load(), 541, 253);
        stage.setTitle("Potrosacki meni");
        stage.setScene(scene);
    }
}
