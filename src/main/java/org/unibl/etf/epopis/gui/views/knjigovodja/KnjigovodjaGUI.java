package org.unibl.etf.epopis.gui.views.knjigovodja;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.unibl.etf.epopis.db.querying.SQLDriver;
import org.unibl.etf.epopis.gui.Main;
import org.unibl.etf.epopis.gui.controllers.knjigovodja.KnjigovodjaController;
import org.unibl.etf.epopis.gui.controllers.potrosac.PotrosacController;
import org.unibl.etf.epopis.gui.views.GUI;
import org.unibl.etf.epopis.model.actors.Knjigovodja;
import org.unibl.etf.epopis.model.actors.Potrosac;
import org.unibl.etf.epopis.model.reflection.factories.KnjigovodjaFactory;
import org.unibl.etf.epopis.model.reflection.factories.PotrosacFactory;

import java.io.IOException;
import java.sql.SQLException;

@Getter
@Setter
public class KnjigovodjaGUI extends GUI {
    private Knjigovodja entity = null;
    private String entityJMBG;
    private KnjigovodjaController controller;

    public KnjigovodjaGUI(Stage stage) throws IOException {
        super(stage);
    }

    public KnjigovodjaGUI(Stage stage, String entityJMBG) throws IOException {
        super(stage);
        this.entityJMBG = entityJMBG;
        initEntity(this.entityJMBG);
    }

    @Override
    protected void load() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/org/unibl/etf/epopis/knjigovodja/fx-knjigovodja-menu.fxml"));
        Scene scene = new Scene(loader.load(), 541, 245);
        this.stage.setTitle("Knjigovodstveni meni");
        this.stage.setScene(scene);

        this.controller = loader.getController();
        this.controller.setEntity(this.entity);
    }

    private void initEntity(String entityJMBG) {
        SQLDriver<Knjigovodja> driver = new SQLDriver<Knjigovodja>(new KnjigovodjaFactory());
        try {
            setEntity(driver.read(entityJMBG));

            if (this.controller != null) {
                this.controller.setEntity(this.entity);
                this.controller.init();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
