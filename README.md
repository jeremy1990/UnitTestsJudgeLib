This program gives an example for how to write unit tests
using JUnit + Hamcrest + Mockito + PowerMock + Jacoco.
It also gives an example for how to use SpringJUnit4ClassRunner
to run the tests.

Classes in example.unit.tests.judge package shows a simple judge program
which can runs and verifies how many test cases passing for a piece of code.

Classes in example.unit.tests.judge.sample packages shows a example for
how to use this judge program to run and verify a program.

To run the program, [Gradle](https://gradle.org/install) is needed.

After installation, run
```
gradle run
```
to see the example result in
[example.unit.tests.judge.sample.MaxTriangleCircumference.main](https://github.com/jeremy1990/UnitTestsJudgeLib/blob/master/src/java/example/unit/tests/judge/sample/MaxTriangleCircumference.java#L41-L52)

run
```
gradle test
gradle jacocoTestReport
```
to see the coverage report of unit tests.
The HTML report is located at build/reports/jacoco/test/html.
