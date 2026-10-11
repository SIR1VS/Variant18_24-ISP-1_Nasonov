package Lab_8;

public class SalesDepartment extends Department {
    private double salesVolume;

    public SalesDepartment(String name, int numberOfEmployees, double budget, double salesVolume) {
        super(name, numberOfEmployees, budget);
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

    public double getAverageSalesPerEmployee() {
        if (getNumberOfEmployees() == 0) {
            return 0.0;
        }
        return salesVolume / getNumberOfEmployees();
    }

    @Override
    public void calculateEfficiency() {
        double baseEfficiency;
        if (getNumberOfEmployees() == 0) {
            baseEfficiency = 0;
        } else {
            double budgetPerEmployee = getBudget() / getNumberOfEmployees();
            baseEfficiency = Math.min(70.0, budgetPerEmployee / 1000.0 * 40.0);
        }
        double salesContribution = Math.min(30.0, salesVolume / 100000.0 * 15.0);
        setEfficiency(baseEfficiency + salesContribution);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + String.format(" | Объём продаж: %.2f | Средние продажи/сотрудник: %.2f", salesVolume, getAverageSalesPerEmployee());
    }
}