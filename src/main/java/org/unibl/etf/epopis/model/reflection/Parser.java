package org.unibl.etf.epopis.model.reflection;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Parser {
    void parse(ResultSet rs) throws SQLException;
}
