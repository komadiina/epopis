package epopis.model.reflection.exceptions;

import org.apache.commons.lang3.exception.UncheckedException;

public class InvalidPrimaryKeyTypeException extends UncheckedException {
    public InvalidPrimaryKeyTypeException(String cause) {
        super(new Throwable(cause));
    }
    public InvalidPrimaryKeyTypeException(Throwable cause) { super(cause); }
}
