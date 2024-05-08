package epopis.model.reflection;

import org.apache.commons.lang3.exception.UncheckedException;

public class InvalidPrimaryKeyType extends UncheckedException {

    public InvalidPrimaryKeyType(String cause) {
        super(new Throwable(cause));
    }
    public InvalidPrimaryKeyType(Throwable cause) { super(cause); }
}
