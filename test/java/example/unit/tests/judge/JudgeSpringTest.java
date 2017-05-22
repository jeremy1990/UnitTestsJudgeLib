package example.unit.tests.judge;

import example.unit.tests.judge.mocks.MockedLoaders;
import example.unit.tests.judge.mocks.MockedPrograms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:unittests.xml")
public class JudgeSpringTest extends AbstractJUnit4SpringContextTests {
    @Resource
    MockedLoaders loaders;

    @Resource
    MockedPrograms programs;

    @Test
    public void testJudge_noCase() {
        Loader caseLoader = loaders.getFalseCaseLoader();
        Loader answerLoader = loaders.getTrueAnswerLoader();
        Program<InputOutput, InputOutput> program =
                programs.getNoCaseProgram();

        Judge<InputOutput, InputOutput> judge =
                new Judge<>(caseLoader, answerLoader);
        judge.judge(program, InputOutput.class, InputOutput.class);
    }

    @Test
    public void testJudge_noAnswer() {
        Loader caseLoader = loaders.getTrueCaseLoader();
        Loader answerLoader = loaders.getFalseAnswerLoader();
        Program<InputOutput, InputOutput> program =
                programs.getNoAnswerProgram();

        Judge<InputOutput, InputOutput> judge =
                new Judge<>(caseLoader, answerLoader);
        judge.judge(program, InputOutput.class, InputOutput.class);
    }

    @Test
    public void testJudge() {
        Loader caseLoader = loaders.getNormalCaseLoader();
        Loader answerLoader = loaders.getNormalAnswerLoader();
        Program<Input, Output> program =
                programs.getGeneralProgram();

        Judge<Input, Output> judge =
                new Judge<>(caseLoader, answerLoader);
        judge.judge(program, Input.class, Output.class);
    }

    @Test
    public void testJudge_nullOutput() {
        Loader caseLoader = loaders.getNormalCaseLoader();
        Loader answerLoader = loaders.getNormalAnswerLoader();
        Program<Input, Output> program =
                programs.getNullOutputProgram();

        Judge<Input, Output> judge =
                new Judge<>(caseLoader, answerLoader);
        judge.judge(program, Input.class, Output.class);
    }

    @Test
    public void testJudge_neAnswer() {
        Loader caseLoader = loaders.getNormalCaseLoader();
        Loader answerLoader = loaders.getNormalAnswerLoader();
        Program<Input, Output> program =
                programs.getNeAnswerProgram();

        Judge<Input, Output> judge =
                new Judge<>(caseLoader, answerLoader);
        judge.judge(program, Input.class, Output.class);
    }

    @Test(expected = UnitTestsJudgeException.class)
    public void testJudge_noSuchMethod() {
        Loader caseLoader = loaders.getNormalCaseLoader();
        Loader answerLoader = loaders.getNormalAnswerLoader();
        Program<InputNoConstructor, Output> program =
                programs.getNoConstructorProgram();

        Judge<InputNoConstructor, Output> judge =
                new Judge<>(caseLoader, answerLoader);
        judge.judge(program, InputNoConstructor.class, Output.class);
    }

    @Test(expected = UnitTestsJudgeException.class)
    public void testJudge_parseFail() {
        Loader caseLoader = loaders.getNormalCaseLoader();
        Loader answerLoader = loaders.getExceptionLoader();
        Program<Input, Output> program =
                programs.getParseFailProgram();

        Judge<Input, Output> judge =
                new Judge<>(caseLoader, answerLoader);
        judge.judge(program, Input.class, Output.class);
    }
}
