package example.unit.tests.judge;

import org.junit.Test;
import org.mockito.Mockito;

public class JudgeTest {
    /**
     * http://stackoverflow.com/questions/16043819/junit-testing-void-methods
     */
    @Test
    public void testJudge_noCase() {
        Loader caseLoader =
                Mockito.mock(Loader.class);
        Mockito.when(caseLoader.hasNext())
                .thenReturn(false);
        Loader answerLoader =
                Mockito.mock(Loader.class);
        Mockito.when(answerLoader.hasNext())
                .thenReturn(true);
        Program<InputOutput, InputOutput> program =
                Mockito.mock(Program.class);
        Mockito.when(program.getDescription())
                .thenReturn("Program Description noCase: ");

        Judge<InputOutput, InputOutput> judge =
                new Judge<>(caseLoader, answerLoader);
        judge.judge(program, InputOutput.class, InputOutput.class);
    }

    @Test
    public void testJudge_noAnswer() {
        Loader caseLoader =
                Mockito.mock(Loader.class);
        Mockito.when(caseLoader.hasNext())
                .thenReturn(true);
        Loader answerLoader =
                Mockito.mock(Loader.class);
        Mockito.when(answerLoader.hasNext())
                .thenReturn(false);
        Program<InputOutput, InputOutput> program =
                Mockito.mock(Program.class);
        Mockito.when(program.getDescription())
                .thenReturn("Program Description noAnswer: ");

        Judge<InputOutput, InputOutput> judge =
                new Judge<>(caseLoader, answerLoader);
        judge.judge(program, InputOutput.class, InputOutput.class);
    }

    @Test
    public void testJudge() {
        Loader caseLoader =
                Mockito.mock(Loader.class);
        Mockito.when(caseLoader.hasNext())
                .thenReturn(true)
                .thenReturn(false);
        Mockito.when(caseLoader.next())
                .thenReturn("input");

        Loader answerLoader =
                Mockito.mock(Loader.class);
        Mockito.when(answerLoader.hasNext())
                .thenReturn(true)
                .thenReturn(false);
        Mockito.when(answerLoader.next())
                .thenReturn("output");

        Program<Input, Output> program =
                Mockito.mock(Program.class);
        Mockito.when(program.getDescription())
                .thenReturn("Program Description: ");
        Mockito.when(program.main(Input.input))
                .thenReturn(Output.output);

        Judge<Input, Output> judge =
                new Judge<>(caseLoader, answerLoader);
        judge.judge(program, Input.class, Output.class);
    }

    @Test
    public void testJudge_nullOutput() {
        Loader caseLoader =
                Mockito.mock(Loader.class);
        Mockito.when(caseLoader.hasNext())
                .thenReturn(true)
                .thenReturn(false);
        Mockito.when(caseLoader.next())
                .thenReturn("input");

        Loader answerLoader =
                Mockito.mock(Loader.class);
        Mockito.when(answerLoader.hasNext())
                .thenReturn(true)
                .thenReturn(false);
        Mockito.when(answerLoader.next())
                .thenReturn("output");

        Program<Input, Output> program =
                Mockito.mock(Program.class);
        Mockito.when(program.getDescription())
                .thenReturn("Program Description nullOutput: ");
        Mockito.when(program.main(Input.input))
                .thenReturn(null);

        Judge<Input, Output> judge =
                new Judge<>(caseLoader, answerLoader);
        judge.judge(program, Input.class, Output.class);
    }

    @Test
    public void testJudge_neAnswer() {
        Loader caseLoader =
                Mockito.mock(Loader.class);
        Mockito.when(caseLoader.hasNext())
                .thenReturn(true)
                .thenReturn(false);
        Mockito.when(caseLoader.next())
                .thenReturn("input");

        Loader answerLoader =
                Mockito.mock(Loader.class);
        Mockito.when(answerLoader.hasNext())
                .thenReturn(true)
                .thenReturn(false);
        Mockito.when(answerLoader.next())
                .thenReturn("output");

        Program<Input, Output> program =
                Mockito.mock(Program.class);
        Mockito.when(program.getDescription())
                .thenReturn("Program Description neAnswer: ");
        Mockito.when(program.main(Input.input))
                .thenReturn(new Output());

        Judge<Input, Output> judge =
                new Judge<>(caseLoader, answerLoader);
        judge.judge(program, Input.class, Output.class);
    }

    @Test(expected = UnitTestsJudgeException.class)
    public void testJudge_noSuchMethod() {
        Loader caseLoader =
                Mockito.mock(Loader.class);
        Mockito.when(caseLoader.hasNext())
                .thenReturn(true)
                .thenReturn(false);
        Mockito.when(caseLoader.next())
                .thenReturn("input");

        Loader answerLoader =
                Mockito.mock(Loader.class);
        Mockito.when(answerLoader.hasNext())
                .thenReturn(true)
                .thenReturn(false);
        Mockito.when(answerLoader.next())
                .thenReturn("output");

        Program<InputNoConstructor, Output> program =
                Mockito.mock(Program.class);
        Mockito.when(program.getDescription())
                .thenReturn("Program Description noConstructor: ");
        Mockito.when(program.main(InputNoConstructor.input))
                .thenReturn(new Output());

        Judge<InputNoConstructor, Output> judge =
                new Judge<>(caseLoader, answerLoader);
        judge.judge(program, InputNoConstructor.class, Output.class);
    }

    @Test(expected = UnitTestsJudgeException.class)
    public void testJudge_parseFail() {
        Loader caseLoader =
                Mockito.mock(Loader.class);
        Mockito.when(caseLoader.hasNext())
                .thenReturn(true)
                .thenReturn(false);
        Mockito.when(caseLoader.next())
                .thenReturn("input");

        Loader answerLoader =
                Mockito.mock(Loader.class);
        Mockito.when(answerLoader.hasNext())
                .thenReturn(true)
                .thenReturn(false);
        Mockito.when(answerLoader.next())
                .thenReturn("exception");

        Program<Input, Output> program =
                Mockito.mock(Program.class);
        Mockito.when(program.getDescription())
                .thenReturn("Program Description parseFail: ");
        Mockito.when(program.main(Input.input))
                .thenReturn(Output.output);

        Judge<Input, Output> judge =
                new Judge<>(caseLoader, answerLoader);
        judge.judge(program, Input.class, Output.class);
    }
}

