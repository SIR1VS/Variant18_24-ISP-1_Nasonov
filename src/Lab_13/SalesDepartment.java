package Lab_13;

public class SalesDepartment extends OrganizationalUnit implements Evaluable {
    private int numberOfEmployees;
    private double budget;
    private double salesVolume;
    private double efficiency;

    public SalesDepartment(String name, String status, int numberOfEmployees,
                           double budget, double salesVolume) {
        super(name, status);
        setNumberOfEmployees(numberOfEmployees);
        setBudget(budget);
        setSalesVolume(salesVolume);
        this.efficiency = 0.0;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public double getBudget() {
        return budget;
    }

    public double getSalesVolume() {
        return salesVolume;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = Math.max(0, numberOfEmployees);
    }

    public void setBudget(double budget) {
        this.budget = Math.max(0, budget);
    }

    public void setSalesVolume(double salesVolume) {
        this.salesVolume = Math.max(0, salesVolume);
    }

    // Реализация абстрактного метода родителя
    @Override
    public void calculateEfficiency() {
        if (numberOfEmployees == 0) {
            efficiency = 0;
            return;
        }
        double base = Math.min(70.0, (budget / numberOfEmployees) / 1000.0 * 40.0);
        double bonus = Math.min(30.0, salesVolume / 100000.0 * 15.0);
        efficiency = base + bonus;
    }

    // Реализация методов интерфейса
    @Override
    public double getEfficiency() {
        return efficiency;
    }

    @Override
    public String generateReport() {
        return String.format(
                "Отчёт отдела продаж \"%s\":\n" +
                        "  Сотрудников: %d\n" +
                        "  Бюджет: %.2f\n" +
                        "  Объём продаж: %.2f\n" +
                        "  Эффективность: %.1f%%",
                getName(), numberOfEmployees, budget, salesVolume, efficiency
        );
    }

    // Переопределение дефолтного метода интерфейса
    @Override
    public String getEvaluationSummary() {
        return String.format(
                "Отдел продаж \"%s\": эффективность %s. Рекомендация: %s",
                getName(),
                Evaluable.formatEfficiency(efficiency),
                efficiency >= 70 ? "поддерживать текущий уровень" : "увеличить объём продаж"
        );
    }

    // Собственный метод класса
    public double getAverageSalesPerEmployee() {
        if (numberOfEmployees == 0) {
            return 0.0;
        }
        return salesVolume / numberOfEmployees;
    }
}