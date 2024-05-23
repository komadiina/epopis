package org.unibl.etf.epopis.tests.sqldriver;

import org.unibl.etf.epopis.model.actors.Potrosac;
import org.unibl.etf.epopis.model.reflection.factories.PotrosacFactory;
import org.unibl.etf.epopis.db.querying.SQLDriver;

import java.util.List;

public class DriverGetAllTest {
    public static void main(String[] args) {
        List<Potrosac> potrosacList;
        SQLDriver<Potrosac> potrosacSQLDriver = new SQLDriver<>(new PotrosacFactory());
        try {
            potrosacList = potrosacSQLDriver.getAll();
        } catch (java.sql.SQLException throwables) {
            throw new RuntimeException(throwables);
        }
        for (Potrosac p : potrosacList)
            System.out.println(p);
    }
}
