package org.unibl.etf.epopis.gui.controllers.login.menu;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.unibl.etf.epopis.gui.controllers.login.Validator;
import org.unibl.etf.epopis.gui.views.GUI;
import org.unibl.etf.epopis.gui.views.knjigovodja.KnjigovodjaGUI;
import org.unibl.etf.epopis.gui.views.login.menu.LoginKnjigovodjaGUI;
import org.unibl.etf.epopis.gui.views.login.menu.LoginPotrosacGUI;
import org.unibl.etf.epopis.gui.views.potrosac.PotrosacGUI;

import java.io.IOException;

public class KnjigovodjaLoginController {
    public TextField password;
    public TextField username;
    public Label response;

    public void login(ActionEvent actionEvent) {
        if (Validator.validateCredentials(
                "knjigovodja",
                "JMBG",
                "lozinka",
                username.getText(),
                password.getText(),
                response)) {
            try {
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                GUI current = new LoginKnjigovodjaGUI(stage);
                current.hide();
                GUI gui = new KnjigovodjaGUI(stage, username.getText());
                gui.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else response.setText("Invalid credentials.");
    }
}
