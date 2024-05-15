package epopis.tests.sqldriver;

import epopis.model.actors.Potrosac;
import epopis.model.reflection.factories.PotrosacFactory;
import epopis.db.querying.SQLDriver;

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
