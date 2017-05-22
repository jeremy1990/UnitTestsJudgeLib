package example.unit.tests.judge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A {@code FileOnceLoader} instance loads all the records into
 * memory once from a file, so it is suitable for file which is small.
 * The file length must less than 1MB.
 */
public class FileOnceLoader implements Loader {
    private static final int MAX_SIZE = 1024 * 1024;
    private List<String> records;
    private int current;

    /**
     * Initialize the {@code FileOnceLoader}.
     *
     * @param fileName the file name of the file that holds all the
     *                 records to be read from.
     * @throws UnitTestsJudgeException when fail to find or open file.
     */
    public FileOnceLoader(final String fileName)
            throws UnitTestsJudgeException {
        records = new ArrayList<>();
        loadFile(fileName);
        current = 0;
    }

    @Override
    public boolean hasNext() {
        return current < records.size();
    }

    @Override
    public String next() {
        if (hasNext()) {
            return records.get(current++);
        } else {
            return null;
        }
    }

    /**
     * Loads records into a list.
     *
     * @param fileName the file name of the file that holds all the
     *                 records to be read from.
     */
    private void loadFile(final String fileName) {
        if (fileName == null) {
            throw new UnitTestsJudgeException(
                    "File name couldn't be null.");
        }
        File file = new File(fileName);
        if (file.length() > MAX_SIZE) {
            throw new UnitTestsJudgeException(
                    "Cannot support file length > 1MB.");
        }

        try (FileReader fileReader =
                     new FileReader(file);
             BufferedReader bufferedReader =
                     new BufferedReader(fileReader)){
            String line;
            while((line = bufferedReader.readLine()) != null) {
                records.add(line.trim());
            }
        } catch (FileNotFoundException e) {
            throw new UnitTestsJudgeException(
                    "Cannot find file: " + fileName, e);
        } catch (IOException e) {
            throw new UnitTestsJudgeException(
                    "Cannot open file: " + fileName, e);
        }
    }
}
