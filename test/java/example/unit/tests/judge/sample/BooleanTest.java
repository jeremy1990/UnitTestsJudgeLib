package example.unit.tests.judge.sample;

import example.unit.tests.judge.UnitTestsJudgeException;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class BooleanTest {
    @Test(expected = UnitTestsJudgeException.class)
    public void testParseString_null() {
        Boolean bool = new Boolean();
        bool.parseString(null);
    }

    @Test
    public void testParseString_true() {
        Boolean bool = new Boolean();
        bool.parseString("True");
        Assert.assertEquals(true, bool.getValue());
    }

    @Test
    public void testParseString_false() {
        Boolean bool = new Boolean();
        Boolean ret = (Boolean) bool.parseString("false");
        Assert.assertEquals(ret, bool);
        Assert.assertEquals(false, bool.getValue());
    }

    @Test(expected = UnitTestsJudgeException.class)
    public void testParseString_wrongStr() {
        Boolean bool = new Boolean();
        bool.parseString("false1");
    }

    @Test
    public void testEquals_null() {
        Boolean bool = new Boolean();
        boolean actual = bool.equals(null);
        Assert.assertEquals(false, actual);
    }

    @Test
    public void testEquals_wrongType() {
        Boolean bool = new Boolean();
        boolean actual = bool.equals(new TriangleEdges());
        Assert.assertEquals(false, actual);
    }

    @Test
    public void testEquals_notEqual() {
        Boolean bool = new Boolean();
        bool.withValue(true);
        Boolean boolFalse = new Boolean();
        boolFalse.parseString("false");
        boolean actual = bool.equals(boolFalse);
        Assert.assertEquals(false, actual);
    }

    @Test
    public void testHashCode() {
        Boolean bool = new Boolean();
        bool.withValue(true);
        Boolean boolFalse = new Boolean();
        boolFalse.parseString("false");
        Boolean boolFalse2 = new Boolean();
        boolFalse2.parseString("faLse");
        Set<Boolean> sets = new HashSet<>();
        sets.add(bool);
        sets.add(boolFalse);
        sets.add(boolFalse2);
        Assert.assertEquals(2, sets.size());
    }
}
