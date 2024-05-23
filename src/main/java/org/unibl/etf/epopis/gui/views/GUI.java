package org.unibl.etf.epopis.gui.views;

import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
@Setter
abstract public class GUI {
    protected Stage stage;

    public GUI(Stage stage) throws IOException {
        this.stage = stage;
        load();
    }

    public void show() {
        this.stage.show();
    }

    public void hide() {
        this.stage.hide();
    }

    public static void transition(GUI from, GUI to) {
        from.hide();
        to.show();
    }

    public static void transition(Stage stage, GUI from, GUI to) {
        from.setStage(stage);
        to.setStage(stage);

        from.hide();
        to.show();
    }

    abstract protected void load() throws IOException;
}
