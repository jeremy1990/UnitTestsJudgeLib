package example.unit.tests.judge.mocks;

import example.unit.tests.judge.Input;
import example.unit.tests.judge.InputNoConstructor;
import example.unit.tests.judge.InputOutput;
import example.unit.tests.judge.Output;
import example.unit.tests.judge.Program;
import org.mockito.Mockito;

public class MockedPrograms {
    public Program getNoCaseProgram() {
        Program<InputOutput, InputOutput> program =
                Mockito.mock(Program.class);
        Mockito.when(program.getDescription())
                .thenReturn("Program Description noCase: ");
        return program;
    }

    public Program getNoAnswerProgram() {
        Program<InputOutput, InputOutput> program =
                Mockito.mock(Program.class);
        Mockito.when(program.getDescription())
                .thenReturn("Program Description noAnswer: ");
        return program;
    }

    public Program getGeneralProgram() {
        Program<Input, Output> program =
                Mockito.mock(Program.class);
        Mockito.when(program.getDescription())
                .thenReturn("Program Description: ");
        Mockito.when(program.main(Input.input))
                .thenReturn(Output.output);
        return program;
    }

    public Program getNullOutputProgram() {
        Program<Input, Output> program =
                Mockito.mock(Program.class);
        Mockito.when(program.getDescription())
                .thenReturn("Program Description nullOutput: ");
        Mockito.when(program.main(Input.input))
                .thenReturn(null);
        return program;
    }

    public Program getNeAnswerProgram() {
        Program<Input, Output> program =
                Mockito.mock(Program.class);
        Mockito.when(program.getDescription())
                .thenReturn("Program Description neAnswer: ");
        Mockito.when(program.main(Input.input))
                .thenReturn(new Output());
        return program;
    }

    public Program getNoConstructorProgram() {
        Program<InputNoConstructor, Output> program =
                Mockito.mock(Program.class);
        Mockito.when(program.getDescription())
                .thenReturn("Program Description noConstructor: ");
        Mockito.when(program.main(InputNoConstructor.input))
                .thenReturn(new Output());
        return program;
    }

    public Program getParseFailProgram() {
        Program<Input, Output> program =
                Mockito.mock(Program.class);
        Mockito.when(program.getDescription())
                .thenReturn("Program Description parseFail: ");
        Mockito.when(program.main(Input.input))
                .thenReturn(Output.output);
        return program;
    }
}
