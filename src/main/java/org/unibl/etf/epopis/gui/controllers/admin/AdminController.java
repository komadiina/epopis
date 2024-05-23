package org.unibl.etf.epopis.gui.controllers.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.unibl.etf.epopis.db.querying.SQLDriver;
import org.unibl.etf.epopis.model.reflection.factories.AdministratorFactory;

import java.io.IOException;
import java.sql.SQLException;

public class AdminController {
    public TextField addMjestoNaziv;
    public TextField addMjestoPosta;
    public TextField delMjestoPosta;
    public TextField addAdminKorisnickoIme;
    public TextField addAdminLozinka;
    public TextField addSnabdjevacNaziv;
    public TextField addSnabdjevacNapon;
    public TextField addSnabdjevacPosta;
    public TextField addSnabdjevacTelefon;
    public TextField addSnabdjevacLozinka;
    public TextField addDistributerNaziv;
    public TextField addDistributerNapon;
    public TextField addDistributerPosta;
    public TextField addDistributerTelefon;
    public TextField addDistributerLozinka;
    public TextField addDistributerIDSnabdjevac;
    public TextField delSnabdjevacID;
    public TextField delDistributerID;
    public TextField delAdminKorisnickoIme;

    public void dodajMjesto(ActionEvent actionEvent) {
        runQuery(String.format("insert into mjesto (naziv, posta) values ('%s', '%s')",
                addMjestoNaziv.getText(), addMjestoPosta.getText()));
    }

    public void izbrisiMjesto(ActionEvent actionEvent) {
        runQuery(String.format("delete * from mjesto where posta = '%s'", delMjestoPosta.getText()));
    }

    public void dodajSnabdjevaca(ActionEvent actionEvent) {
        runQuery(String.format(
                "insert int snabdjevac (naziv, napon, posta, telefon, lozinka) " +
                        "values ('%s', %.4f, '%s', '%s', '%s')",
                addSnabdjevacNaziv.getText(),
                Double.parseDouble(addSnabdjevacNapon.getText()),
                addSnabdjevacPosta.getText(),
                addSnabdjevacTelefon.getText(),
                addSnabdjevacLozinka.getText()
        ));
    }

    public void izbrisiSnabdjevaca(ActionEvent actionEvent) {
        runQuery(String.format("delete * from snabdjevac where idSnabdjevac = %d",
                Integer.parseInt(delSnabdjevacID.getText())));
    }

    public void dodajDistributera(ActionEvent actionEvent) {
        runQuery(String.format("insert into distributer " +
                "(naziv, napon, telefon, posta, lozinka, snabdjevac_idSnabdjevac) " +
                "values ('%s', '%.4f', '%s', '%s', '%s', %d)",
                addSnabdjevacNaziv.getText(),
                Double.parseDouble(addDistributerNapon.getText()),
                addDistributerTelefon.getText(),
                addSnabdjevacPosta.getText(),
                addDistributerLozinka.getText(),
                Integer.parseInt(addDistributerIDSnabdjevac.getText())
                ));
    }


    public void izbrisiDistributera(ActionEvent actionEvent) {
        runQuery(String.format("delete * from distributer where idDistributer = %d",
                Integer.parseInt(delDistributerID.getText())
                ));
    }

    public void dodajAdmina(ActionEvent actionEvent) {
        runQuery(String.format("insert into administrator (korisnickoIme, lozinka) " +
                "values ('%s', '%s')",
                addAdminKorisnickoIme.getText(),
                addAdminLozinka.getText()
        ));
    }

    public void izbrisiAdmina(ActionEvent actionEvent) {
        runQuery(String.format("delete * from admin where korisnickoIme = '%s'",
                delAdminKorisnickoIme.getText()
        ));
    }

    private void runQuery(String query) {
        try {
            (new SQLDriver<>(new AdministratorFactory()))
                    .runQuery(query);
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
}
