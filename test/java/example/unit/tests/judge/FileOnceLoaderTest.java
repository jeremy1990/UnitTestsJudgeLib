package example.unit.tests.judge;

import org.junit.Assert;
import org.junit.Test;

public class FileOnceLoaderTest {
    @Test(expected = UnitTestsJudgeException.class)
    public void testConstructor_nullFileName() {
        new FileOnceLoader(null);
    }

    @Test(expected = UnitTestsJudgeException.class)
    public void testConstructor_nonExistFileName() {
        new FileOnceLoader("non_exist_file.txt");
    }

    @Test
    public void testHasNext() {
        Loader loader = new FileOnceLoader(
                "build/resources/test/three_records.txt");
        Assert.assertEquals(true, loader.hasNext());
        loader.next();
        loader.next();
        loader.next();
        Assert.assertEquals(false, loader.hasNext());
    }

    @Test
    public void testHasNext_noNext() {
        Loader loader = new FileOnceLoader(
                "build/resources/test/empty.txt");
        Assert.assertEquals(false, loader.hasNext());
    }

    @Test
    public void testNext() {
        Loader loader = new FileOnceLoader(
                "build/resources/test/three_records.txt");
        Assert.assertEquals("2,3,4,5,10", loader.next());
    }

    @Test
    public void testNext_nullNext() {
        Loader loader = new FileOnceLoader(
                "build/resources/test/empty.txt");
        Assert.assertEquals(null, loader.next());
    }
}
