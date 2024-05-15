package epopis.model.reflection.exceptions;

import org.apache.commons.lang3.exception.UncheckedException;

import java.sql.SQLException;

public class InvalidResultSetException extends SQLException {
    public InvalidResultSetException(String cause) {
        super(new Throwable(cause));
    }
    public InvalidResultSetException(Throwable cause) { super(cause); }
}
