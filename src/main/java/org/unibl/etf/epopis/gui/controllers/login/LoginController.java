package org.unibl.etf.epopis.gui.controllers.login;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.unibl.etf.epopis.app.users.UserPotrosac;
import org.unibl.etf.epopis.gui.views.GUI;
import org.unibl.etf.epopis.gui.views.login.LoginGUI;
import org.unibl.etf.epopis.gui.views.login.menu.LoginDistributerGUI;
import org.unibl.etf.epopis.gui.views.login.menu.LoginElektricarGUI;
import org.unibl.etf.epopis.gui.views.login.menu.LoginKnjigovodjaGUI;
import org.unibl.etf.epopis.gui.views.login.menu.LoginPotrosacGUI;
import org.unibl.etf.epopis.model.exceptions.RegisterException;

import java.io.IOException;

public class LoginController {
    public TextField lozinka;
    public TextField pib;
    public Label statusRegistracije;
    public TextField naziv;
    public TextField posta;
    public TextField telefon;
    public TextField idDistributer;

    public void prijavaPotrosac(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            GUI current = new LoginGUI(stage);
            current.hide();
            GUI gui = new LoginPotrosacGUI(stage);
            gui.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void prijavaElektricar(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            GUI current = new LoginGUI(stage);
            current.hide();
            GUI gui = new LoginElektricarGUI(stage);
            gui.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void prijavaDistributer(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            GUI current = new LoginGUI(stage);
            current.hide();
            GUI gui = new LoginDistributerGUI(stage);
            gui.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void prijavaKnjigovodja(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            GUI current = new LoginGUI(stage);
            current.hide();
            GUI gui = new LoginKnjigovodjaGUI(stage);
            gui.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void registrujSe(ActionEvent actionEvent) {
        System.out.println(pib.getText());
        System.out.println(lozinka.getText());
        System.out.println(naziv.getText());
        System.out.println(posta.getText());
        System.out.println(telefon.getText());
        System.out.println(Integer.parseInt(idDistributer.getText()));

        try {
            if (UserPotrosac.register(
                    pib.getText(),
                    naziv.getText(),
                    telefon.getText(),
                    posta.getText(),
                    lozinka.getText(),
                    Integer.parseInt(idDistributer.getText()))
            )  {
                statusRegistracije.setText("Uspjesno ste registrovani! Molimo Vas prijavite se.");
            }
        } catch (RegisterException ex) {
            statusRegistracije.setText(ex.getLocalizedMessage());
        }
    }
}
