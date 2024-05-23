package org.unibl.etf.epopis.db.querying;

import org.unibl.etf.epopis.db.DBUtil;
import org.unibl.etf.epopis.model.reflection.Factory;
import org.unibl.etf.epopis.model.reflection.Parser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// T implements Parser<T>
// T obj -> obj.parse(ResultSet rs)
// return T;

public class SQLDriver<T extends Parser> implements DAO<T> {
    private final Factory<T> factory;
    private Connection c;
    private Statement s;

    public SQLDriver(Factory<T> factory) {
        this.factory = factory;
    }

    @Override
    public List<T> getAll() throws SQLException {
        StatementEngine<T> se = new StatementEngine<>();
        T instance = factory.create();
        String SQL_QUERY = se.generateSelectAll(instance);
        List<T> results = new ArrayList<>();
        Object result = ExecuteQuery(SQL_QUERY);

        if (result == null) {
            System.err.printf("(SQLDriver::getAll, %s) Received result == null...\n",
                    instance.getClass().getSimpleName()
                    );
            return null;
        } else {
            try {
                while (((ResultSet)result).next()) {
                    T newObject = factory.create();
                    newObject.parse((ResultSet)result);
                    results.add(newObject);
                }
            } catch (SQLException ex) {
                System.err.printf("(SQLDriver::getAll, %s) SQLException occurred: %s (%d)\n",
                            instance.getClass().getSimpleName(),
                        ex.getMessage(),
                        ex.getErrorCode()
                        );

                // Return the current state of parsed results
                return results;
            } finally {
                close(c, s, (ResultSet)result);
            }
        }

        return results;
    }

    @Override
    public T read(Object id) throws SQLException {
        StatementEngine<T> se = new StatementEngine<>();
        T instance = factory.create(id);
        String SQL_QUERY = se.generateSelect(instance);
        Object result = ExecuteQuery(SQL_QUERY);

        if (result == null) {
            System.err.printf("(SQLDriver::read, %s) Received result == null, id=%s\n",
                    instance.getClass().getSimpleName(),
                    id
            );

            return null;
        } else try {
            instance.parse((ResultSet) result);
        } catch (SQLException ex) {
            System.err.printf("(SQLDriver::read, %s) Could not parse object: %s (%d)\n",
                    instance.getClass().getSimpleName(),
                    ex.getMessage(),
                    ex.getErrorCode()
                    );
            return null;
        } finally {
            close(c, s, (ResultSet) result);
        }

        return instance;
    }

    @Override
    public int create(T m) throws SQLException {
        StatementEngine<T> se = new StatementEngine<>();
        String SQL_QUERY = se.generateInsert(m);
        Object result = ExecuteQuery(SQL_QUERY);

        if (result == null) {
            System.err.printf("(SQLDriver::create, %s) Received result == null, m=%s\n",
                        m.getClass().getSimpleName(),
                        m
                    );

            close(c, s);
            return -1;
        }

        close(c,s);
        return (int)result;
    }

    @Override
    public int update(T m, Object id) throws SQLException {
        // replace db entry of PK(id) with values(m)
        StatementEngine<T> se = new StatementEngine<>();
        String SQL_QUERY = se.generateUpdate(m, id);
        Object result = ExecuteQuery(SQL_QUERY);

        if (result == null) {
            System.err.printf("(SQLDriver::update, %s) Received result == null for id=%s...\n",
                    m.getClass().getSimpleName(),
                    id
            );

            close(c, s);
            return -1;
        }

        return (int)result;
    }

    @Override
    public int delete(Object id) throws SQLException {
        StatementEngine<T> se = new StatementEngine<>();
        T instance = factory.create(id);
        String SQL_QUERY = se.generateDelete(instance);
        Object result = ExecuteQuery(SQL_QUERY);

        if (result == null) {
            System.err.printf("(SQLDriver::delete, %s) Received result == null...\n",
                    instance.getClass().getSimpleName()
            );

            close(c, s);
            return -1;
        }

        close(c,s);
        return (int)result;
    }

    @Override
    public Object runQuery(String query) throws SQLException {
        return ExecuteQuery(query);
    }

    private Object ExecuteQuery(String SQL_QUERY) throws SQLException {
        Object result;
        try {
            c = DBUtil.getConnection();
            s = c.createStatement();

            if (s.execute(SQL_QUERY))
                result = s.getResultSet();
            else
                result = s.getUpdateCount();
        } catch (SQLException ex) {
            System.err.printf("SQLException occurred: %s (%d), QUERY=%s\n",
                    ex.getMessage(),
                    ex.getErrorCode(),
                    SQL_QUERY
                    );
            throw ex;
        }

        return result;
    }

    private void close(Connection c, Statement s) {
        try {
            s.close();
            c.close();
        } catch (SQLException ex) {
            System.err.printf("(SQLDriver::close) SQLException occurred: %s (%d)\n",
                    ex.getMessage(),
                    ex.getErrorCode()
            );
        }
    }

    private void close(Connection c, Statement s, ResultSet rs) {
        try {
            rs.close();
            s.close();
            c.close();
        } catch (SQLException ex) {
            System.err.printf("(SQLDriver::close) SQLException occurred: %s (%d)\n",
                    ex.getMessage(),
                    ex.getErrorCode()
            );
        }
    }
}
