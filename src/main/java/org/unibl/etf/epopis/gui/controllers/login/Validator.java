package org.unibl.etf.epopis.gui.controllers.login;

import javafx.scene.control.Label;
import org.unibl.etf.epopis.db.querying.SQLDriver;
import org.unibl.etf.epopis.model.reflection.factories.PotrosacFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Validator {
    static boolean validateCredentials(String table, String fieldname1, String fieldname2, String username, String password, Label lbl) {
        SQLDriver<?> driver = new SQLDriver<>(new PotrosacFactory());
        try {
            String query = String.format(String.format("select * from %s where %s = '%s' and %s = '%s'",
                    table, fieldname1, username, fieldname2, password
            ));
            System.out.println(query);
            ResultSet rs = (ResultSet)driver.runQuery(query);
            if (rs.next())
                return true;
        } catch (SQLException ex) {
            lbl.setText(ex.getMessage());
        }

        return false;
    }
}
