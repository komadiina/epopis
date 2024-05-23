package org.unibl.etf.epopis.db.querying;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    List<T> getAll() throws SQLException;
    int create(T m) throws SQLException;
    T read(Object id) throws SQLException;
    int update(T m, Object id) throws SQLException;
    int delete(Object id) throws SQLException;

    Object runQuery(String query) throws SQLException;
}
