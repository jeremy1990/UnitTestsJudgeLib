package example.unit.tests.judge.sample;

import example.unit.tests.judge.UnitTestsJudgeException;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TriangleEdgesTest {
    @Test(expected = UnitTestsJudgeException.class)
    public void testParseString_null() {
        TriangleEdges edges = new TriangleEdges();
        edges.parseString(null);
    }

    @Test(expected = UnitTestsJudgeException.class)
    public void testParseString_lessThan3() {
        TriangleEdges edges = new TriangleEdges();
        edges.parseString("3,5");
    }

    @Test
    public void testParseString_normal() {
        TriangleEdges edges = new TriangleEdges();
        TriangleEdges ret = (TriangleEdges) edges.parseString("2,3,4,5,10");
        Assert.assertEquals(edges, ret);
        List<Integer> edgeList = ret.getEdges();
        Assert.assertEquals(5, edgeList.size());

        Integer[] ints = new Integer[] {2, 3, 4, 5, 10};
        List<Integer> expected = new ArrayList<>();
        for (Integer num : ints)
            expected.add(num);
        Assert.assertEquals(expected, edgeList);
        MatcherAssert.assertThat("Return result: ",
                expected,
                Matchers.hasItem(10));
    }

    @Test
    public void testEquals_null() {
        TriangleEdges edges = new TriangleEdges();
        boolean actual = edges.equals(null);
        Assert.assertEquals(false, actual);
    }

    @Test
    public void testEquals_wrongType() {
        TriangleEdges edges = new TriangleEdges();
        boolean actual = edges.equals(new Boolean());
        Assert.assertEquals(false, actual);
    }

    @Test
    public void testHashCode() {
        TriangleEdges edges = new TriangleEdges();
        TriangleEdges ret = (TriangleEdges) edges.parseString("2,3,4,5,10");
        Set<TriangleEdges> sets = new HashSet<>();
        sets.add(edges);
        sets.add(ret);
        Assert.assertEquals(1, sets.size());
    }
}
