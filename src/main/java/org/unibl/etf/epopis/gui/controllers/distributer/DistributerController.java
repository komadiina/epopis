package org.unibl.etf.epopis.gui.controllers.distributer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import lombok.Getter;
import lombok.Setter;
import org.unibl.etf.epopis.db.querying.SQLDriver;
import org.unibl.etf.epopis.model.actors.Distributer;
import org.unibl.etf.epopis.model.actors.Zahtjev;
import org.unibl.etf.epopis.model.reflection.factories.DistributerFactory;
import org.unibl.etf.epopis.model.reflection.factories.ZahtjevFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DistributerController {
    public TextField odobriZahtjevTF;
    public TextField odbijZahtjevTF;
    public Label info;

    private Distributer entity;
    private List<Zahtjev> inbox = new ArrayList<>();

    public void pregledajZahtjeve(ActionEvent actionEvent) {
        // pregled aktivnih zahtjeva
        try {
            inbox.clear();
            ResultSet rs = (ResultSet) (new SQLDriver<>(new ZahtjevFactory()))
                    .runQuery(
                            String.format("select * from zahtjev where DISTRIBUTER_idDistributer = '%d'",
                                    this.entity.getPk_idDistributer()
                            )
                    );

            while (rs.next()) {
                Zahtjev ent = new Zahtjev(
                        rs.getBoolean("iskljucenje"),
                        rs.getDate("datum"),
                        rs.getInt("DISTRIBUTER_idDistributer"),
                        rs.getString("POTROSAC_PIB")
                );
                ent.setPk_idZahtjev(rs.getInt("idZahtjev"));

                Boolean odobren = rs.getBoolean("odobren");
                if (!rs.wasNull())
                    ent.setOdobren(odobren);

                inbox.add(ent);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        System.out.println(inbox);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Postansko sanduce");
        alert.setHeaderText(null);

        ListView<String> lista = new ListView<>();
        for (Zahtjev zahtjev : inbox)
            lista.getItems().add(zahtjev.toString());

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

    public void odobriZahtjev(ActionEvent actionEvent) {
        manipZahtjev(odobriZahtjevTF.getText(), true);
    }

    public void odbijZahtjev(ActionEvent actionEvent) {
        manipZahtjev(odbijZahtjevTF.getText(), false);
    }

    public void init() {
        initInfo();
    }

    private void manipZahtjev(String id, Boolean status) {
        try {
            System.out.println("ID: " + id);
            SQLDriver<Zahtjev> zahtjevSQLDriver = new SQLDriver<>(new ZahtjevFactory());
            Object result = zahtjevSQLDriver.runQuery(String.format(
                    "update zahtjev set odobren = %s where idZahtjev = '%s'",
                    status ? "1" : "0",
                    id
            ));
            System.out.println(result);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void initInfo() {

        this.info.setText(String.format(
                "%s (%s) | %.4f kW | %d | %s | %s",
                entity.getNaziv(),
                entity.getPk_idDistributer(),
                entity.getNapon(),
                entity.getFk_SNABDJEVAC_idSnabdjevac(),
                entity.getTelefon(),
                entity.getFk_MJESTO_posta()
        ));
    }
}
