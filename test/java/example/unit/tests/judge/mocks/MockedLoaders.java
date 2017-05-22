package example.unit.tests.judge.mocks;

import example.unit.tests.judge.Loader;
import org.mockito.Mockito;

public class MockedLoaders {
    public Loader getNormalCaseLoader() {
        Loader caseLoader =
                Mockito.mock(Loader.class);
        Mockito.when(caseLoader.hasNext())
                .thenReturn(true)
                .thenReturn(false);
        Mockito.when(caseLoader.next())
                .thenReturn("input");
        return caseLoader;
    }

    public Loader getNormalAnswerLoader() {
        Loader answerLoader =
                Mockito.mock(Loader.class);
        Mockito.when(answerLoader.hasNext())
                .thenReturn(true)
                .thenReturn(false);
        Mockito.when(answerLoader.next())
                .thenReturn("output");
        return answerLoader;
    }

    public Loader getExceptionLoader() {
        Loader answerLoader =
                Mockito.mock(Loader.class);
        Mockito.when(answerLoader.hasNext())
                .thenReturn(true)
                .thenReturn(false);
        Mockito.when(answerLoader.next())
                .thenReturn("exception");
        return answerLoader;
    }

    public Loader getFalseCaseLoader() {
        Loader caseLoader =
                Mockito.mock(Loader.class);
        Mockito.when(caseLoader.hasNext())
                .thenReturn(false);
        return caseLoader;
    }

    public Loader getTrueAnswerLoader() {
        Loader answerLoader =
                Mockito.mock(Loader.class);
        Mockito.when(answerLoader.hasNext())
                .thenReturn(true);
        return answerLoader;
    }

    public Loader getTrueCaseLoader() {
        Loader caseLoader =
                Mockito.mock(Loader.class);
        Mockito.when(caseLoader.hasNext())
                .thenReturn(true);
        return caseLoader;
    }

    public Loader getFalseAnswerLoader() {
        Loader answerLoader =
                Mockito.mock(Loader.class);
        Mockito.when(answerLoader.hasNext())
                .thenReturn(false);
        return answerLoader;
    }
}
