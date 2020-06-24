package by.balashevich.jaggedarray.exception;

public class InvalidArrayDataException extends Exception {
    public InvalidArrayDataException() {
        super();
    }

    public InvalidArrayDataException(String message) {
        super(message);
    }

    public InvalidArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidArrayDataException(Throwable cause) {
        super(cause);
    }
}
