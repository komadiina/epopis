package org.unibl.etf.epopis.gui.views.potrosac;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.*;
import org.unibl.etf.epopis.db.querying.SQLDriver;
import org.unibl.etf.epopis.gui.Main;
import org.unibl.etf.epopis.gui.controllers.potrosac.PotrosacController;
import org.unibl.etf.epopis.gui.views.GUI;
import org.unibl.etf.epopis.model.actors.Ormar;
import org.unibl.etf.epopis.model.actors.Potrosac;
import org.unibl.etf.epopis.model.reflection.Parser;
import org.unibl.etf.epopis.model.reflection.factories.OrmarFactory;
import org.unibl.etf.epopis.model.reflection.factories.PotrosacFactory;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@Setter
@Getter
public class PotrosacGUI extends GUI {
    private Potrosac entity = null;
    private String entityPIB;
    private PotrosacController controller;

    public PotrosacGUI(Stage stage) throws IOException {
        super(stage);
    }

    public PotrosacGUI(Stage stage, String entityPIB) throws IOException {
        super(stage);
        this.entityPIB = entityPIB;
        initEntity(this.entityPIB);
    }

    @Override
    protected void load() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/org/unibl/etf/epopis/potrosac/fx-potrosac-menu.fxml"));
        Scene scene = new Scene(loader.load(), 536, 320);
        stage.setTitle("Potrosacki meni");
        stage.setScene(scene);

        this.controller = loader.getController();
        this.controller.setEntity(this.entity);
    }


    private void initEntity(String entityPIB) {
        SQLDriver<Potrosac> driver = new SQLDriver<Potrosac>(new PotrosacFactory());
        try {
            setEntity(driver.read(entityPIB));

            if (this.controller != null) {
                this.controller.setEntity(this.entity);
                this.controller.init();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
