package example.unit.tests.judge.sample;

import example.unit.tests.judge.InputOutput;
import example.unit.tests.judge.UnitTestsJudgeException;

public class Boolean implements InputOutput {
    private boolean value;

    /**
     * Accepted strings are:
     * "true"
     * "false".
     *
     * @param str a record loaded by a {@link example.unit.tests.judge.Loader}.
     * @return
     * @throws UnitTestsJudgeException
     */
    @Override
    public InputOutput parseString(String str)
            throws UnitTestsJudgeException {
        if (str == null) {
            throw new UnitTestsJudgeException(
                    "String cannot be null.");
        }

        if ("true".equals(str.toLowerCase())) {
            value = true;
        } else if ("false".equals(str.toLowerCase())) {
            value = false;
        } else {
            throw new UnitTestsJudgeException(
                    "Invalid boolean value.");
        }
        return this;
    }

    public boolean getValue() {
        return value;
    }

    public Boolean withValue(final boolean value) {
        this.value = value;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (! (obj instanceof Boolean)) {
            return false;
        }

        Boolean value = (Boolean) obj;
        return this.value == value.getValue();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + (value ? 1 : 0);
        return result;
    }
}
