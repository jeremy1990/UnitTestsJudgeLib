package example.unit.tests.judge;

/**
 * A {@code InputOutput} instance restrict the type of the input and output.
 * Each input and output type must implement methods in this interface.
 *
 * {@link Judge} uses {@code parseString} to convert a record loaded by
 * a {@link Loader} from {@code String} to the type user want.
 *
 * {@link #toString()}, {@link #equals(Object)}, {@link #hashCode()} are
 * required to be implemented subclasses.
 */
public interface InputOutput {
    /**
     * Parses a string record and convert it to the user input or output type.
     *
     * @param str a record loaded by a {@link Loader}.
     * @return instance has been assigned value.
     * @throws UnitTestsJudgeException when the string is not
     * the correct format as user expected.
     */
    InputOutput parseString(final String str)
            throws UnitTestsJudgeException;
}
