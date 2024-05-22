package org.unibl.etf.epopis.gui.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.unibl.etf.epopis.gui.Main;

import java.io.IOException;

public class ElektricarGUI extends GUI {

    public ElektricarGUI(Stage stage) throws IOException {
        super(stage);
    }

    @Override
    protected void load() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/org/unibl/etf/epopis/fx-elektricar-menu.fxml"));
        Scene scene = new Scene(loader.load(), 541, 400);
        this.stage.setTitle("Elektricarski meni");
        this.stage.setScene(scene);
    }
}