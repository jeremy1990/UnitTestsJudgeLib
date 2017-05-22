package example.unit.tests.judge.sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class MaxTriangleCircumferenceTest {
    private MaxTriangleCircumference circumference;
    @Before
    public void setUp() {
        circumference = new MaxTriangleCircumference();
    }

    @Test
    public void testMain_null() {
        Boolean actual = circumference.main((TriangleEdges) null);
        Assert.assertEquals("Null input: ",
                false,
                actual.getValue());
    }

    @Test
    public void testMain_true() {
        TriangleEdges edges = Mockito.mock(TriangleEdges.class);
        int[] ints = new int[] {2, 4, 5, 6, 10};
        List<Integer> list = new ArrayList<>();
        for (int num: ints) {
            list.add(num);
        }
        Mockito.doReturn(list)
                .when(edges)
                .getEdges();

        Boolean actual = circumference.main(edges);
        Assert.assertEquals("Input 2,4,5,6,10: ",
                true,
                actual.getValue());
    }

    @Test
    public void testMain_false() {
        TriangleEdges edges = Mockito.mock(TriangleEdges.class);
        int[] ints = new int[] {4, 5, 10};
        List<Integer> list = new ArrayList<>();
        for (int num: ints) {
            list.add(num);
        }
        Mockito.doReturn(list)
                .when(edges)
                .getEdges();

        Boolean actual = circumference.main(edges);
        Assert.assertEquals("Input 4,5,10: ",
                false,
                actual.getValue());
    }

    @Test
    public void testGetDescription() {
        Assert.assertEquals("Max Triangle Circumference:",
                circumference.getDescription());
    }
}
