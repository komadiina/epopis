package org.unibl.etf.epopis.gui;

import javafx.application.Application;
import javafx.stage.Stage;
import org.unibl.etf.epopis.gui.views.GUI;
import org.unibl.etf.epopis.gui.views.LoginGUI;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GUI window = new LoginGUI(stage);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
