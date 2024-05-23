package org.unibl.etf.epopis.gui.controllers.elektricar;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import lombok.Getter;
import lombok.Setter;
import org.unibl.etf.epopis.db.querying.SQLDriver;
import org.unibl.etf.epopis.model.actors.Elektricar;
import org.unibl.etf.epopis.model.actors.Knjigovodja;
import org.unibl.etf.epopis.model.actors.Ormar;
import org.unibl.etf.epopis.model.actors.Zahtjev;
import org.unibl.etf.epopis.model.reflection.factories.KnjigovodjaFactory;
import org.unibl.etf.epopis.model.reflection.factories.OrmarFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class ElektricarController {
    public Label info;
    public TextField pibPotrosaca;
    public TextField jmbgKnjigovodje;

    private Elektricar entity;
    private List<Ormar> potrosnje = new ArrayList<>();
    private List<Knjigovodja> knjigovodje = new ArrayList<>();

    public void pregledPotrosnje(ActionEvent actionEvent) {
        // prikaz ormara
        try {
            potrosnje.clear();

            ResultSet rs = (ResultSet) (new SQLDriver<>(new OrmarFactory()))
                    .runQuery(String.format(
                            "select * from ormar"
                    ));

            while (rs.next()) {
                potrosnje.add(new Ormar(
                    rs.getBoolean("prikljucak"),
                    rs.getDouble("brojilo"),
                    rs.getBoolean("iskljucen"),
                    rs.getString("POTROSAC_PIB")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Postansko sanduce");
        alert.setHeaderText(null);

        ListView<String> lista = new ListView<>();
        for (Ormar o : potrosnje)
            lista.getItems().add(o.toString());

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

    public void pregledKnjigovodja(ActionEvent actionEvent) {
        // pregled knjigovdja
        try {
            knjigovodje.clear();

            ResultSet rs = (ResultSet) (new SQLDriver<>(new KnjigovodjaFactory()))
                    .runQuery(String.format(
                            "select * from knjigovodja"
                    ));

            while (rs.next()) {
                knjigovodje.add(new Knjigovodja(
                   rs.getString("jmbg"),
                   rs.getString("pib"),
                   rs.getString("ime"),
                   rs.getString("prezime")
                ));
            }
        } catch (SQLException ex) { ex.printStackTrace(); }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Postansko sanduce");
        alert.setHeaderText(null);

        ListView<String> lista = new ListView<>();
        for (Knjigovodja k : knjigovodje)
            lista.getItems().add(k.toString());

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

    public void izradaPredracuna(ActionEvent actionEvent) {
        try {
            // dohvatiti vrijednost brojila u ormaru na osnovu piba potrosaca
            String pib = pibPotrosaca.getText();
            String query = String.format(
                    "SELECT o.brojilo from ormar o " +
                            "join potrosac p " +
                            "on p.pib = o.potrosac_pib " +
                            "where p.pib = '%s'",
                    pib
            );
            ResultSet rs = (ResultSet)(new SQLDriver<>(new OrmarFactory()))
                    .runQuery(query);

            Double brojilo = 0.00;
            if (rs.next())
                brojilo = rs.getDouble(1);

            query = String.format(
                    "insert into predracun " +
                            "(potroseno, elektricar_jmbg, knjigovodja_jmbg, potrosac_pib) " +
                            "values (%.2f, '%s', '%s', '%s')",
                    brojilo,
                    this.entity.getPk_JMBG(),
                    jmbgKnjigovodje.getText(),
                    pib
            );
            (new SQLDriver<>(new OrmarFactory())).runQuery(query);
        } catch (SQLException ex) { ex.printStackTrace(); }
    }

    public void init() {
        this.info.setText(String.format(
                "%s %s (%s) | ID Distributera: %s",
                this.entity.getIme(),
                this.entity.getPrezime(),
                this.entity.getPk_JMBG(),
                this.entity.getFk_DISTRIBUTER_idDistributer()
        ));
    }
}
