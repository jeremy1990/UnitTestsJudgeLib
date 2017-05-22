package example.unit.tests.judge;

/**
 * A {@code UnitTestsJudgeException} is thrown, when any exception
 * is happened in this library.
 */
public class UnitTestsJudgeException extends RuntimeException {
    /**
     * @param message exception message.
     */
    public UnitTestsJudgeException(final String message) {
        this(message, null);
    }

    /**
     * @param message exception message.
     * @param cause exception cause.
     */
    public UnitTestsJudgeException(final String message,
                                   final Throwable cause) {
        super(message, cause);
    }
}
