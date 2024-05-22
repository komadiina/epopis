package org.unibl.etf.epopis.gui;

import javafx.application.Application;
import javafx.stage.Stage;
import org.unibl.etf.epopis.gui.views.AdminGUI;
import org.unibl.etf.epopis.gui.views.GUI;

public class Admin extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GUI window = new AdminGUI(stage);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
