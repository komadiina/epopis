package org.unibl.etf.epopis.model.reflection.exceptions;

import java.sql.SQLException;

public class InvalidResultSetException extends SQLException {
    public InvalidResultSetException(String cause) {
        super(new Throwable(cause));
    }
    public InvalidResultSetException(Throwable cause) { super(cause); }
}
