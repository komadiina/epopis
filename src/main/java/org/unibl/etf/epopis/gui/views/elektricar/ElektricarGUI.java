package org.unibl.etf.epopis.gui.views.elektricar;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.unibl.etf.epopis.db.querying.SQLDriver;
import org.unibl.etf.epopis.gui.Main;
import org.unibl.etf.epopis.gui.controllers.elektricar.ElektricarController;
import org.unibl.etf.epopis.gui.views.GUI;
import org.unibl.etf.epopis.model.actors.Distributer;
import org.unibl.etf.epopis.model.actors.Elektricar;
import org.unibl.etf.epopis.model.reflection.factories.DistributerFactory;
import org.unibl.etf.epopis.model.reflection.factories.ElektricarFactory;

import java.io.IOException;
import java.sql.SQLException;

@Getter
@Setter
public class ElektricarGUI extends GUI {
    private Elektricar entity;
    private String entityJMBG;
    private ElektricarController controller;

    public ElektricarGUI(Stage stage) throws IOException {
        super(stage);
    }

    public ElektricarGUI(Stage stage, String jmbg) throws IOException {
        super(stage);
        this.entityJMBG = jmbg;
        initEntity(this.entityJMBG);
    }

    @Override
    protected void load() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/org/unibl/etf/epopis/elektricar/fx-elektricar-menu.fxml"));
        Scene scene = new Scene(loader.load(), 405, 270);
        this.stage.setTitle("Elektricarski meni");
        this.stage.setScene(scene);

        this.controller = loader.getController();
        this.controller.setEntity(entity);
    }

    private void initEntity(String entityID) {
        SQLDriver<Elektricar> driver = new SQLDriver<>(new ElektricarFactory());
        try {
            setEntity(driver.read(entityID));

            if (this.controller != null) {
                this.controller.setEntity(entity);
                this.controller.init();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
