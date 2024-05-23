package org.unibl.etf.epopis.gui.views.distributer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.unibl.etf.epopis.db.querying.SQLDriver;
import org.unibl.etf.epopis.gui.Main;
import org.unibl.etf.epopis.gui.controllers.distributer.DistributerController;
import org.unibl.etf.epopis.gui.views.GUI;
import org.unibl.etf.epopis.model.actors.Distributer;
import org.unibl.etf.epopis.model.actors.Potrosac;
import org.unibl.etf.epopis.model.reflection.factories.DistributerFactory;
import org.unibl.etf.epopis.model.reflection.factories.PotrosacFactory;

import java.io.IOException;
import java.sql.SQLException;

@Getter
@Setter
public class DistributerGUI extends GUI {
    private Distributer entity;
    private String entityID;
    private DistributerController controller;

    public DistributerGUI(Stage stage) throws IOException {
        super(stage);
    }

    public DistributerGUI(Stage stage, String entityID) throws IOException {
        super(stage);

        this.entityID = entityID;
        initEntity(this.entityID);
    }

    @Override
    protected void load() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/org/unibl/etf/epopis/distributer/fx-distributer-menu.fxml"));
        Scene scene = new Scene(loader.load(), 470, 292);
        this.stage.setTitle("Distributerski meni");
        this.stage.setScene(scene);

        this.controller = loader.getController();
        this.controller.setEntity(entity);
    }

    private void initEntity(String entityID) {
        SQLDriver<Distributer> driver = new SQLDriver<Distributer>(new DistributerFactory());
        try {
            setEntity(driver.read(Integer.parseInt(entityID)));

            if (this.controller != null) {
                this.controller.setEntity(entity);
                this.controller.init();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
