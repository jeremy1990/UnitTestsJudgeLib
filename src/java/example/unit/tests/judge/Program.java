package example.unit.tests.judge;

/**
 * A {@code program} implements an algorithm which can be tested by
 * a {@link Judge} automatically to know how many test cases are passed.
 *
 * @param <I> input type.
 * @param <O> output type.
 */
public interface Program<I extends InputOutput,
        O extends InputOutput> {
    /**
     * Entry of the program.
     *
     * @param input input of the program.
     * @return output of the program.
     */
    O main(final I input);

    /**
     * A piece of description to describe
     * what this program is done.
     *
     * @return the description.
     */
    String getDescription();
}
