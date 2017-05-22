package example.unit.tests.judge;

public class Output implements InputOutput {
    public final static Output output = new Output();

    @Override
    public InputOutput parseString(String str)
            throws UnitTestsJudgeException {
        if ("output".equals(str)) {
            return output;
        } else {
            throw new UnitTestsJudgeException("parseString exception.");
        }
    }
}
