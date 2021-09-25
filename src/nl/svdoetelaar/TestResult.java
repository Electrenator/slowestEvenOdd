package nl.svdoetelaar;

public class TestResult implements Comparable<TestResult> {
    private final long timing;
    private final boolean passedValidation;

    public TestResult(long timing, boolean passedValidation) {
        this.timing = timing;
        this.passedValidation = passedValidation;
    }

    public long getTiming() {
        return timing;
    }

    public boolean isPassedValidation() {
        return passedValidation;
    }

    @Override
    public int compareTo(TestResult o) {
        return Long.compare(timing, o.timing);
    }
}
