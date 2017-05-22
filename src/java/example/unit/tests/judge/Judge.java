package example.unit.tests.judge;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * A {@code Judge} instance is used to judge how many cases are correct.
 * All cases are loaded by a caseLoader.
 *
 * @param <I> input type.
 * @param <O> output type.
 */
public class Judge<I extends InputOutput, O extends InputOutput> {
    private Loader caseLoader;
    private Loader answerLoader;

    /**
     * Initialises the caseLoader to load cases.
     * Initialises the answerLoader to load correct answers.
     *
     * @param caseLoader
     * @param answerLoader
     */
    public Judge(final Loader caseLoader,
                 final Loader answerLoader) {
        this.caseLoader = caseLoader;
        this.answerLoader = answerLoader;
    }

    /**
     * Judge how many cases are correct.
     *
     * @param program program written by user.
     * @param iClass program input type.
     * @param oClass program output type.
     */
    public void judge(final Program<I, O> program,
                 final Class<I> iClass,
                 final Class<O> oClass)
            throws UnitTestsJudgeException {
        int count = 0;
        int correct = 0;
        while (caseLoader.hasNext() &&
                answerLoader.hasNext()) {
            String inputStr = caseLoader.next();
            I input = (I) getInputOutput(iClass, inputStr);

            O output = program.main(input);

            String answerStr = answerLoader.next();
            O answer = (O) getInputOutput(oClass, answerStr);

            if (output != null && output.equals(answer)) {
                correct++;
            }
            count++;
        }

        System.out.println(program.getDescription());
        System.out.println("Pass " + correct + "/" + count);
    }

    private InputOutput getInputOutput(
            final Class<? extends InputOutput> clazz,
            final String value) {
        try {
            Constructor<?> iConstructor = clazz.getConstructor();
            InputOutput instance = (InputOutput) iConstructor.newInstance();
            instance = instance.parseString(value);
            return instance;
        } catch (NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException
                | InstantiationException e) {
            throw new UnitTestsJudgeException(
                    "Fail to initialise object of type "
                    + clazz.getSimpleName());
        } catch (UnitTestsJudgeException e) {
            throw new UnitTestsJudgeException(
                    "Fail to parse object of type "
                    + clazz.getSimpleName());
        }
    }
}
