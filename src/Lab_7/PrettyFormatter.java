package Lab_7;

public class PrettyFormatter extends Formatter {
    private final String prefix;
    private final String suffix;

    public PrettyFormatter() {
        super("PrettyFormatter");
        this.prefix = "*** ";
        this.suffix = " ***";
    }

    public PrettyFormatter(String prefix, String suffix) {
        super("PrettyFormatter");
        this.prefix = (prefix != null) ? prefix : "*** ";
        this.suffix = (suffix != null) ? suffix : " ***";
    }

    @Override
    public String format(String value) {
        operationCount++;
        String content = (value != null) ? value : "null";
        return prefix + content + suffix;
    }

    @Override
    public String toString() {
        return "PrettyFormatter{name='" + getName()
                + "', operations=" + getOperationCount()
                + ", framing='" + prefix.trim() + "..." + suffix.trim() + "'}";
    }
}
