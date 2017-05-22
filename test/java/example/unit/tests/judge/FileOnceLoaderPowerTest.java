package example.unit.tests.judge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * PowerMock cannot work with Jacoco.
 * https://github.com/jacoco/eclemma/issues/15
 *
 * http://stackoverflow.com/questions/23983740/
 * unable-to-get-jacoco-to-work-with-powermockito-using-offline-instrumentation
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(FileOnceLoader.class)
public class FileOnceLoaderPowerTest {
    private static final String LARGE_FILE_NAME = "large_file.txt";
    private static final String READ_LINE_FAIL = "read_line_fail.txt";

    @Test(expected = UnitTestsJudgeException.class)
    public void testConstructor_largeFile() throws Exception {
        File file = PowerMockito.mock(File.class);
        PowerMockito.whenNew(File.class)
                .withArguments(LARGE_FILE_NAME)
                .thenReturn(file);
        PowerMockito.when(file.length())
                .thenReturn(2L * 1024 * 1024);
        new FileOnceLoader(LARGE_FILE_NAME);
    }

    @Test(expected = UnitTestsJudgeException.class)
    public void testConstructor_readLineFail() throws Exception {
        File file =
                PowerMockito.mock(File.class);
        PowerMockito.whenNew(File.class)
                .withArguments(READ_LINE_FAIL)
                .thenReturn(file);
        FileReader fileReader =
                PowerMockito.mock(FileReader.class);
        PowerMockito.whenNew(FileReader.class)
                .withArguments(file)
                .thenReturn(fileReader);
        BufferedReader bufferedReader =
                PowerMockito.mock(BufferedReader.class);
        PowerMockito.whenNew(BufferedReader.class)
                .withArguments(fileReader)
                .thenReturn(bufferedReader);
        PowerMockito.when(bufferedReader.readLine())
                .thenThrow(IOException.class);

        new FileOnceLoader(READ_LINE_FAIL);
    }
}
