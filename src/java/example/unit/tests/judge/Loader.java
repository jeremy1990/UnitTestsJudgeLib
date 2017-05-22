package example.unit.tests.judge;

/**
 * A {@code Loader} instance is used to load a list of cases or answers
 * from a given storage which can be a file or a remote database table.
 *
 * Each case or answer is a record of type {@code String}.
 *
 * A {@link Judge} instance holds a case loader and a answer loader
 * to test if the given {@link Program} gives the right answer.
 *
 * @see FileOnceLoader
 */
public interface Loader {
    /**
     * Tests if there is still a record.
     *
     * @return true if there is still a record.
     */
    boolean hasNext();

    /**
     * Loads the next record.
     *
     * @return the next record. Null if there is no record anyM more.
     */
    String next();
}
