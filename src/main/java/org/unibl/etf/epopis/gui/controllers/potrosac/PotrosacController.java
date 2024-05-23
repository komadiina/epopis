package org.unibl.etf.epopis.gui.controllers.potrosac;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.controlsfx.control.spreadsheet.Grid;
import org.unibl.etf.epopis.db.querying.SQLDriver;
import org.unibl.etf.epopis.gui.views.GUI;
import org.unibl.etf.epopis.model.actors.*;
import org.unibl.etf.epopis.model.reflection.factories.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class PotrosacController {
    public Label statusPrikljucenjaLbl;
    public Label potrosnjaLbl;
    public Label info;
    public TextField idRacunaInput;
    private Potrosac entity;
    private Ormar entityOrmar;
    private List<Dokument> inbox = new ArrayList<>();

    public PotrosacController() {}

    public void pregledSanduceta(ActionEvent actionEvent) {
        try {
            inbox.clear();
            ResultSet rs = (ResultSet) (new SQLDriver<>(new DokumentFactory()))
                    .runQuery(
                            String.format("select * from dokument where POTROSAC_PIB = '%s'",
                                    this.entity.getPk_PIB()
                                    ));

            while (rs.next()) {
                Dokument entry = new Dokument(
                        rs.getInt("idDokument"),
                        rs.getString("poziv"),
                        rs.getDate("datumIzdavanja"),
                        rs.getString("KNJIGOVODJA_JMBG"),
                        rs.getString("POTROSAC_PIB"),
                        rs.getBoolean("placen")
                );

                ResultSet racuni = (ResultSet) (new SQLDriver<>(new RacunFactory()))
                        .runQuery(
                                String.format(
                                        "select * from racun where DOKUMENT_idDokument = '%d'",
                                        entry.getPk_idDokument()
                                )
                        );

                while (racuni.next()) {
                    inbox.add(new Racun(
                            racuni.getInt("DOKUMENT_idDokument"),
                            racuni.getDouble("potroseno"),
                            entry.getPoziv(),
                            entry.getDatumIzdavanja(),
                            entry.getFk_KNJIGOVODJA_JMBG(),
                            entry.getFk_POTROSAC_PIB(),
                            entry.getPlacen()
                    ));
                }

                ResultSet opomene = (ResultSet) (new SQLDriver<>(new OpomenaFactory()))
                        .runQuery(
                                String.format("select * from opomena where DOKUMENT_idDokument = '%d'",
                                        entry.getPk_idDokument()
                                )
                        );

                while (opomene.next()) {
                    inbox.add(new Opomena(
                        entry.getPoziv(),
                            entry.getDatumIzdavanja(),
                            entry.getFk_KNJIGOVODJA_JMBG(),
                            entry.getFk_POTROSAC_PIB(),
                            entry.getPlacen(),
                            opomene.getDouble("dugovanje"),
                            opomene.getDate("rok")
                    ));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Postansko sanduce");
        alert.setHeaderText(null);

        ListView<String> lista = new ListView<>();

        for (Dokument dok : inbox)
            lista.getItems().add(dok.toString());

        ScrollPane sp = new ScrollPane(lista);
        sp.setFitToWidth(true);
        sp.setFitToHeight(true);

        VBox vbox = new VBox(sp);
        vbox.setSpacing(10);

        DialogPane dp = alert.getDialogPane();
        dp.setPrefWidth(600);
        dp.setPrefHeight(300);
        dp.setContent(vbox);

        alert.showAndWait();
    }

    public void platiRacun(ActionEvent actionEvent) {
        try {
            SQLDriver<Racun> racunSQLDriver = new SQLDriver<>(new RacunFactory());
            racunSQLDriver.runQuery(
                    String.format("update dokument set placen = '1' where idDokument = '%s'",
                            idRacunaInput.getText())
            );
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    public void zatraziIskljucenje(ActionEvent actionEvent) {
       if (this.entityOrmar.getIskljucen()) {
           Alert alert  = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Zahtjev za iskljucenje");
           alert.setHeaderText(null);
           alert.setContentText("Nije moguce zatraziti iskljucenje!");
           alert.showAndWait();
       } else {
           Zahtjev iskljucenje = new Zahtjev(
                   true,
                   Date.valueOf(LocalDate.now()),
                   this.entity.getFk_DISTRIBUTER_idDistributer(),
                   this.entity.getPk_PIB()
                   );

           try {
               SQLDriver<Zahtjev> zahtjevSQLDriver = new SQLDriver<>(new ZahtjevFactory());
               zahtjevSQLDriver.runQuery(
                       String.format(
                               "insert into zahtjev (iskljucenje, datum, DISTRIBUTER_idDistributer, POTROSAC_PIB) values ('%s', '%s', '%s', '%s')",
                               iskljucenje.getIskljucenje() ? "1" : "0",
                               iskljucenje.getDatum(),
                               iskljucenje.getFk_DISTRIBUTER_idDistributer(),
                               iskljucenje.getFk_POTROSAC_PIB()
                               )
               );
           } catch (SQLException ex) {
               ex.printStackTrace();
           }
       }
    }

    public void zatraziPrikljucenje(ActionEvent actionEvent) {
        if (!this.entityOrmar.getIskljucen()) {
            Alert alert  = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Zahtjev za prikljucenje");
            alert.setHeaderText(null);
            alert.setContentText("Nije moguce zatraziti prikljucenje!");
            alert.showAndWait();
        } else {
            Zahtjev prikljucenje = new Zahtjev(
                    false,
                    Date.valueOf(LocalDate.now()),
                    this.entity.getFk_DISTRIBUTER_idDistributer(),
                    this.entity.getPk_PIB()
            );

            try {
                SQLDriver<Zahtjev> zahtjevSQLDriver = new SQLDriver<>(new ZahtjevFactory());
                zahtjevSQLDriver.runQuery(
                        String.format(
                                "insert into zahtjev (iskljucenje, datum, DISTRIBUTER_idDistributer, POTROSAC_PIB) values ('%s', '%s', '%s', '%s')",
                                prikljucenje.getIskljucenje() ? "1" : "0",
                                prikljucenje.getDatum(),
                                prikljucenje.getFk_DISTRIBUTER_idDistributer(),
                                prikljucenje.getFk_POTROSAC_PIB()
                        )
                );
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void init() {
        setOrmar();
        setStatusPrikljucenja();
        setPotrosnja();
        setInfo();
    }

    private void setOrmar() {
        SQLDriver<Ormar> driver = new SQLDriver<>(new OrmarFactory());
        try {
            ResultSet rs = (ResultSet) driver.runQuery(
                    String.format("select * from ormar where POTROSAC_PIB = '%s'",
                            entity.getPk_PIB())
            );
            this.entityOrmar = new Ormar();
            this.entityOrmar.parse(rs);

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void setStatusPrikljucenja() {
        statusPrikljucenjaLbl.setText(this.entityOrmar.getIskljucen() ? "Iskljucen!" : "Prikljucen.");
    }

    private void setPotrosnja() {
        this.potrosnjaLbl.setText(String.format("%.2f kWh",this.entityOrmar.getBrojilo()));
    }

    private void setInfo() {
        this.info.setText(String.format("%s (%s) | %s | %s",
                this.entity.getNaziv(),
                this.entity.getPk_PIB(),
                this.entity.getTelefon(),
                this.entity.getFk_MJESTO_posta()
        ));
    }
}
