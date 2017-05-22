package example.unit.tests.judge;

public class Input implements InputOutput {
    public static final Input input = new Input();

    @Override
    public InputOutput parseString(String str)
            throws UnitTestsJudgeException {
        if ("input".equals(str)) {
            return input;
        } else {
            return this;
        }
    }
}
