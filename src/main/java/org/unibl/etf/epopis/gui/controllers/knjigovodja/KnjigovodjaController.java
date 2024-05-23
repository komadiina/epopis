package org.unibl.etf.epopis.gui.controllers.knjigovodja;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import lombok.Getter;
import lombok.Setter;
import org.unibl.etf.epopis.db.querying.SQLDriver;
import org.unibl.etf.epopis.model.actors.Knjigovodja;
import org.unibl.etf.epopis.model.actors.Opomena;
import org.unibl.etf.epopis.model.actors.Predracun;
import org.unibl.etf.epopis.model.actors.Racun;
import org.unibl.etf.epopis.model.reflection.factories.OpomenaFactory;
import org.unibl.etf.epopis.model.reflection.factories.PredracunFactory;
import org.unibl.etf.epopis.model.reflection.factories.RacunFactory;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class KnjigovodjaController {
    public TextField obradaPredracunaTF;
    public TextField slanjeRacunaTF;
    public TextField slanjeOpomeneTF;
    public TextField slanjeOpomeneRokTF;
    public Label info;
    private Knjigovodja entity;

    List<Predracun> predracuni = new ArrayList<>();
    List<Racun> racuni = new ArrayList<>();
    List<Opomena> opomene = new ArrayList<>();
    List<Racun> kasnjenja = new ArrayList<>();

    public void init() {
        info.setText(String.format("%s %s (%s) | PIB: %s",
                entity.getIme(),
                entity.getPrezime(),
                entity.getPk_JMBG(),
                entity.getPIB()
        ));
    }

    public void pregledPredracuna(ActionEvent actionEvent) {
        initPredracuni();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Postansko sanduce");
        alert.setHeaderText(null);

        ListView<String> lista = new ListView<>();

        for (Predracun pr : predracuni)
            lista.getItems().add(pr.toString());

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

    public void pregledRacuna(ActionEvent actionEvent) {
        initRacuni();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Postansko sanduce");
        alert.setHeaderText(null);

        ListView<String> lista = new ListView<>();

        for (Racun rac : racuni)
            lista.getItems().add(rac.toString());

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

    public void pregledOpomena(ActionEvent actionEvent) {
        initOpomene();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Postansko sanduce");
        alert.setHeaderText(null);

        ListView<String> lista = new ListView<>();

        for (Opomena op : opomene)
            lista.getItems().add(op.toString());

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

    public void provjeraKasnjenja(ActionEvent actionEvent) {
        initKasnjenja();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Postansko sanduce");
        alert.setHeaderText(null);

        ListView<String> lista = new ListView<>();

        for (Racun r : kasnjenja)
            lista.getItems().add(r.toString());

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

    public void obradaPredracuna(ActionEvent actionEvent) {
        // kreiranje dokumenta (racuna) na osnovu predracuna
        try {
            String idPredracuna = obradaPredracunaTF.getText();
            Predracun pr = (new SQLDriver<>(new PredracunFactory()))
                    .read(Integer.parseInt(idPredracuna));
            System.out.println(pr);

            // previd za poziv lol
            // napraviti vezu izmedju knjigovodja i distributer
            // queryati za kv.iddistributer = d.iddistributer
            // uzeti d.telefon i unijeti (ndms sad)

            String query = String.format(
                    "insert into dokument (poziv, datumIzdavanja, KNJIGOVODJA_JMBG, POTROSAC_PIB, placen) " +
                            "values ('051300201', '%s', '%s', '%s', 0)",
                    Date.valueOf(LocalDate.now()),
                    this.entity.getPk_JMBG(),
                    pr.getFk_POTROSAC_PIB()
            );
            (new SQLDriver<>(new RacunFactory())).runQuery(query);
            ResultSet rs =
                    (ResultSet)(new SQLDriver<>(new RacunFactory()))
                            .runQuery("select idDokument from dokument");

            int idDokumenta = -1;
            while (rs.next()) {
                idDokumenta = rs.getInt(1);
            }

            query = String.format(
              "insert into racun (potroseno, DOKUMENT_idDokument) values ('%.4f', %d)",
                    pr.getPotroseno(),
                    idDokumenta
            );
            (new SQLDriver<>(new RacunFactory()))
                    .runQuery(query);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void slanjeOpomene(ActionEvent actionEvent) {
        // kreiranje dokumenta (opomene) na osnovu predracuna
        try {
            String idPredracuna = slanjeOpomeneTF.getText();
            Predracun pr = (new SQLDriver<>(new PredracunFactory()))
                    .read(Integer.parseInt(idPredracuna));
            System.out.println(pr);

            // previd za poziv lol
            // napraviti vezu izmedju knjigovodja i distributer
            // queryati za kv.iddistributer = d.iddistributer
            // uzeti d.telefon i unijeti (ndms sad)

            String query = String.format(
                    "insert into dokument (poziv, datumIzdavanja, KNJIGOVODJA_JMBG, POTROSAC_PIB, placen) " +
                            "values ('051300201', '%s', '%s', '%s', 0)",
                    Date.valueOf(LocalDate.now()),
                    this.entity.getPk_JMBG(),
                    pr.getFk_POTROSAC_PIB()
            );
            (new SQLDriver<>(new RacunFactory())).runQuery(query);
            ResultSet rs =
                    (ResultSet)(new SQLDriver<>(new RacunFactory()))
                            .runQuery("select idDokument from dokument");

            int idDokumenta = -1;
            while (rs.next()) {
                idDokumenta = rs.getInt(1);
            }

            query = String.format(
                    "insert into opomena (dugovanje, rok, DOKUMENT_idDokument) values ('%.3f', '%s', %d)",
                    pr.getPotroseno(),
                    slanjeOpomeneRokTF.getText(),
                    idDokumenta
            );
            (new SQLDriver<>(new RacunFactory()))
                    .runQuery(query);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void initPredracuni() {
        try {
            predracuni.clear();

            ResultSet rs = (ResultSet) (new SQLDriver<>(new PredracunFactory()))
                    .runQuery(
                            String.format("select * from predracun where KNJIGOVODJA_JMBG = '%s'",
                                    this.entity.getPk_JMBG())
                    );

            while (rs.next()) {
                predracuni.add(
                        new Predracun(
                                rs.getInt("idPredracun"),
                                rs.getDouble("potroseno"),
                                rs.getString("ELEKTRICAR_JMBG"),
                                rs.getString("KNJIGOVODJA_JMBG"),
                                rs.getString("POTROSAC_PIB")
                        )
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void initOpomene() {
        try {
            opomene.clear();

            SQLDriver<Opomena> driver = new SQLDriver<>(new OpomenaFactory());
            String query = String.format("select d.*, o.dugovanje, o.rok " +
                            "from opomena o " +
                            "join dokument d " +
                            "on o.DOKUMENT_idDokument = d.idDokument " +
                            "where d.KNJIGOVODJA_JMBG = '%s'",
                    this.entity.getPk_JMBG()
            );

            ResultSet rs = (ResultSet) driver.runQuery(query);

            while (rs.next()) {
                opomene.add(new Opomena(
                        rs.getString("poziv"),
                        rs.getDate("datumIzdavanja"),
                        rs.getString("KNJIGOVODJA_JMBG"),
                        rs.getString("POTROSAC_PIB"),
                        rs.getBoolean("placen"),
                        rs.getDouble("dugovanje"),
                        rs.getDate("rok")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void initRacuni() {
        try {
            racuni.clear();

            String query = String.format(
                    "select d.*, r.potroseno from racun r " +
                            "join dokument d on r.DOKUMENT_idDokument = d.idDokument" +
                            " where d.KNJIGOVODJA_JMBG = '%s'",
                    entity.getPk_JMBG()
            );

            ResultSet rs = (ResultSet) (new SQLDriver<>(new PredracunFactory()))
                    .runQuery(query);

            while (rs.next()) {
                Racun r = new Racun(
                        rs.getInt("idDokument"),
                        rs.getDouble("potroseno"),
                        rs.getString("poziv"),
                        rs.getDate("datumIzdavanja"),
                        rs.getString("KNJIGOVODJA_JMBG"),
                        rs.getString("POTROSAC_PIB"),
                        rs.getBoolean("placen")
                );
                racuni.add(r);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void initKasnjenja() {
        try {
            racuni.clear();
            predracuni.clear();
            String query = String.format(
                    "select d.*, r.potroseno from racun r " +
                            "join dokument d on r.DOKUMENT_idDokument = d.idDokument" +
                            " where d.KNJIGOVODJA_JMBG = '%s' and d.placen = 0",
                    entity.getPk_JMBG()
            );
            ResultSet rs = (ResultSet) (new SQLDriver<>(new PredracunFactory()))
                    .runQuery(query);

            while (rs.next()) {
                Racun r = new Racun(
                        rs.getInt("idDokument"),
                        rs.getDouble("potroseno"),
                        rs.getString("poziv"),
                        rs.getDate("datumIzdavanja"),
                        rs.getString("KNJIGOVODJA_JMBG"),
                        rs.getString("POTROSAC_PIB"),
                        rs.getBoolean("placen")
                );
                kasnjenja.add(r);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
