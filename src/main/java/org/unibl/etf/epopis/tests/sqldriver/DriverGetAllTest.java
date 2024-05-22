package org.unibl.etf.epopis.tests.sqldriver;

import org.unibl.etf.epopis.model.actors.Potrosac;
import org.unibl.etf.epopis.model.reflection.factories.PotrosacFactory;
import org.unibl.etf.epopis.db.querying.SQLDriver;

import java.util.ArrayList;
import java.util.List;

public class DriverGetAllTest {
    public static void main(String[] args) {
        List<Potrosac> potrosacList;
        SQLDriver<Potrosac> potrosacSQLDriver = new SQLDriver<>(new PotrosacFactory());
        potrosacList = potrosacSQLDriver.getAll();
        for (Potrosac p : potrosacList)
            System.out.println(p);
    }
}
