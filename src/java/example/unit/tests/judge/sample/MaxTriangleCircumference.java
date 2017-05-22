package example.unit.tests.judge.sample;

import example.unit.tests.judge.FileOnceLoader;
import example.unit.tests.judge.Judge;
import example.unit.tests.judge.Loader;
import example.unit.tests.judge.Program;

import java.util.Collections;
import java.util.List;

/**
 * This program solve a problem that given a set of integers,
 * can we know if there exists three integers which can form
 * a triangle. If there are such three integers, return true,
 * otherwise return false.
 */
public class MaxTriangleCircumference
        implements Program<TriangleEdges, Boolean> {
    @Override
    public Boolean main(final TriangleEdges input) {
        if (input == null) {
            return new Boolean().withValue(false);
        }

        List<Integer> edges = input.getEdges();
        Collections.sort(edges);
        int n = edges.size();
        for (int k = n - 1; k >= 2; --k) {
            if (edges.get(k-2) + edges.get(k-1) > edges.get(k)) {
                return new Boolean().withValue(true);
            }
        }
        return new Boolean().withValue(false);
    }

    @Override
    public String getDescription() {
        return "Max Triangle Circumference:";
    }

    public static void main(String[] args) {
        Loader caseLoader = new FileOnceLoader(
                "build/resources/main/cases.txt");
        Loader answerLoader = new FileOnceLoader(
                "build/resources/main/answers.txt");
        Judge<TriangleEdges, Boolean> judge =
                new Judge<>(caseLoader, answerLoader);
        MaxTriangleCircumference maxTriangleCircumference =
                new MaxTriangleCircumference();
        judge.judge(maxTriangleCircumference,
                TriangleEdges.class, Boolean.class);
    }
}
