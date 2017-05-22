package example.unit.tests.judge.sample;

import example.unit.tests.judge.InputOutput;
import example.unit.tests.judge.UnitTestsJudgeException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriangleEdges implements InputOutput {
    private List<Integer> edges;

    /**
     * Accepted strings are:
     * "2,3,4,5,10".
     *
     * After parsing:
     * edges are in ascending order.
     *
     * @param str a record loaded by a {@link example.unit.tests.judge.Loader}.
     * @return
     * @throws UnitTestsJudgeException
     */
    @Override
    public InputOutput parseString(final String str)
            throws UnitTestsJudgeException {
        if (str == null) {
            throw new UnitTestsJudgeException(
                    "String cannot be null.");
        }

        String[] splitted = str.split(",");
        if (splitted.length < 3) {
            throw new UnitTestsJudgeException("Array length is at least 3.");
        }

        edges = new ArrayList<>();
        for (int i = 0; i < splitted.length; ++i) {
            edges.add(Integer.parseInt(splitted[i]));
        }
        Collections.sort(edges);
        return this;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }

        if (! (obj instanceof TriangleEdges)) {
            return false;
        }

        TriangleEdges te = (TriangleEdges) obj;
        return edges.equals(te.getEdges());
    }

    @Override
    public int hashCode() {
        return edges.hashCode();
    }

    public List<Integer> getEdges() {
        return edges;
    }
}
