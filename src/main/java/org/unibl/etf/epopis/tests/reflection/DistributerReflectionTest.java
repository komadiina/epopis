package org.unibl.etf.epopis.tests.reflection;

import org.unibl.etf.epopis.model.actors.Distributer;
import org.unibl.etf.epopis.model.actors.Potrosac;
import org.unibl.etf.epopis.db.querying.StatementEngine;

public class DistributerReflectionTest {
    public static void main(String[] args) {
        Distributer d = new Distributer("distrib", 220.0, "065686717", 1, "78420", "test");
        StatementEngine<Distributer> dse = new StatementEngine<>();

        System.out.println(dse.generateInsert(d));
        System.out.println(dse.generateUpdate(d, null));
        System.out.println(dse.generateSelect(d));
        System.out.println("============================");

        Potrosac p = new Potrosac("1507001101472", "osmica", "066315889", "78420", "test", 1);
        StatementEngine<Potrosac> pse = new StatementEngine<>();

        System.out.println(pse.generateInsert(p));
        System.out.println(pse.generateUpdate(p, p.getPk_PIB()));
        System.out.println(pse.generateSelect(p));

        System.out.println("============================");

        Distributer d2 = new Distributer(125);
        System.out.println(dse.generateInsert(d2));
        System.out.println(dse.generateUpdate(d2, null));
        System.out.println(dse.generateSelect(d2));
    }
}
