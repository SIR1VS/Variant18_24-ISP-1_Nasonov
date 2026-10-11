package Lab_10;

public class SalesDepartment extends Department {
    private double salesVolume;

    public SalesDepartment(String name, String status, int numberOfEmployees, double budget, double salesVolume) {
        super(name, status, numberOfEmployees, budget);
        setSalesVolume(salesVolume);
    }

    public double getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(double salesVolume) {
        if (salesVolume < 0) {
            this.salesVolume = 0;
        } else {
            this.salesVolume = salesVolume;
        }
    }

    @Override
    public void calculateEfficiency() {
        double base;
        if (getNumberOfEmployees() == 0) {
            base = 0;
        } else {
            double budgetPerEmployee = getBudget() / getNumberOfEmployees();
            base = Math.min(70.0, budgetPerEmployee / 1000.0 * 40.0);
        }
        double salesBonus = Math.min(30.0, salesVolume / 100000.0 * 15.0);
        setEfficiency(base + salesBonus);
    }

    @Override
    public double calculateWorkload() {
        if (getNumberOfEmployees() == 0) {
            return 0.0;
        }
        return salesVolume / getNumberOfEmployees();
    }

    @Override
    public String generateReport() {
        return String.format(
                "Отчёт отдела продаж \"%s\":\n" +
                        "  Сотрудников: %d\n" +
                        "  Бюджет: %.2f\n" +
                        "  Объём продаж: %.2f\n" +
                        "  Эффективность: %.1f%%\n" +
                        "  Нагрузка (продажи/сотрудник): %.2f",
                getName(), getNumberOfEmployees(), getBudget(),
                salesVolume, getEfficiency(), calculateWorkload()
        );
    }
}