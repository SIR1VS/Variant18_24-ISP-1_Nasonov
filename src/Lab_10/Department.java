package Lab_10;

public abstract class Department extends OrganizationalUnit {
    private int numberOfEmployees;
    private double budget;
    private double efficiency;

    public Department(String name, String status, int numberOfEmployees, double budget) {
        super(name, status);
        setNumberOfEmployees(numberOfEmployees);
        setBudget(budget);
        this.efficiency = 0.0;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public double getBudget() {
        return budget;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        if (numberOfEmployees < 0) {
            this.numberOfEmployees = 0;
        } else {
            this.numberOfEmployees = numberOfEmployees;
        }
    }

    public void setBudget(double budget) {
        if (budget < 0) {
            this.budget = 0;
        } else {
            this.budget = budget;
        }
    }

    protected void setEfficiency(double efficiency) {
        if (efficiency < 0) {
            this.efficiency = 0;
        } else if (efficiency > 100) {
            this.efficiency = 100;
        } else {
            this.efficiency = efficiency;
        }
    }

    public void updateBudget(double amount) {
        setBudget(this.budget + amount);
    }

    public String getDepartmentInfo() {
        return getBasicInfo() + String.format(" | Сотрудников: %d | Бюджет: %.2f | Эффективность: %.1f%%",
                numberOfEmployees, budget, efficiency);
    }

    @Override
    public void calculateEfficiency() {
        if (numberOfEmployees == 0) {
            setEfficiency(0);
            return;
        }
        double budgetPerEmployee = budget / numberOfEmployees;
        double calculated = Math.min(100.0, budgetPerEmployee / 1000.0 * 50.0);
        setEfficiency(calculated);
    }

    public abstract double calculateWorkload();
}