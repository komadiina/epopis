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

    public void transition(GUI other) {
        this.hide();
        this.getStage().setScene(other.getStage().getScene());
        other.show();
    }

    abstract protected void load() throws IOException;
}
