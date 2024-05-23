package org.unibl.etf.epopis.gui.controllers.login.menu;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.unibl.etf.epopis.gui.controllers.login.Validator;
import org.unibl.etf.epopis.gui.views.GUI;
import org.unibl.etf.epopis.gui.views.login.menu.LoginPotrosacGUI;
import org.unibl.etf.epopis.gui.views.potrosac.PotrosacGUI;

import java.io.IOException;

public class PotrosacLoginController {
    public TextField username;
    public TextField password;
    public Label response;

    public void login(ActionEvent actionEvent) {
        if (Validator.validateCredentials(
                "potrosac",
                "PIB",
                "lozinka",
                username.getText(),
                password.getText(),
                response)) {
            try {
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                GUI from = new LoginPotrosacGUI(stage);
                PotrosacGUI to = new PotrosacGUI(stage, username.getText());

                GUI.transition(from, to);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else response.setText("Invalid credentials.");
    }
}
