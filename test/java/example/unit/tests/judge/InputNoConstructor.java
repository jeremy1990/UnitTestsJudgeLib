package example.unit.tests.judge;

public class InputNoConstructor implements InputOutput {
    public final static InputNoConstructor input = new InputNoConstructor();
    private InputNoConstructor() {}

    @Override
    public InputOutput parseString(String str)
            throws UnitTestsJudgeException {
        return null;
    }
}
