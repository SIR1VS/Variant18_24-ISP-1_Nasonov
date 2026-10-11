package Lab_7;

public class Formatter {
    private String name;
    protected int operationCount;

    public Formatter() {
        this.name = "BasicFormatter";
        this.operationCount = 0;
    }

    public Formatter(String name) {
        this.name = (name != null && !name.isEmpty()) ? name : "BasicFormatter";
        this.operationCount = 0;
    }

    public String format(int value) {
        operationCount++;
        return "INT[" + value + "]";
    }

    public String format(double value) {
        operationCount++;
        return String.format("DBL[%.2f]", value);
    }

    public String format(String value) {
        operationCount++;
        return "STR[" + (value != null ? value : "null") + "]";
    }

    @Override
    public String toString() {
        return "Formatter{name='" + name + "', operations=" + operationCount + "}";
    }

    public int getOperationCount() {
        return operationCount;
    }

    protected void resetCounter() {
        operationCount = 0;
    }

    String getName() {
        return name;
    }
}