package Lab_13;

public interface Evaluable {
    // Абстрактные методы интерфейса
    double getEfficiency();

    String generateReport();

    // Дефолтный метод
    default String getEvaluationSummary() {
        return String.format("Оценка эффективности: %.1f%%. Статус: требует анализа.", getEfficiency());
    }

    // Статический метод интерфейса
    static String formatEfficiency(double value) {
        if (value >= 80) {
            return "Высокая (" + String.format("%.1f", value) + "%)";
        } else if (value >= 50) {
            return "Средняя (" + String.format("%.1f", value) + "%)";
        } else {
            return "Низкая (" + String.format("%.1f", value) + "%)";
        }
    }
}