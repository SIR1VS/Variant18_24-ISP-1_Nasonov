package Lab_9;

public class Department {
    private String name;
    private int numberOfEmployees;
    private double budget;
    private double efficiency;

    public Department(String name, int numberOfEmployees, double budget) {
        setName(name);
        setNumberOfEmployees(numberOfEmployees);
        setBudget(budget);
        this.efficiency = 0.0;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Без названия";
        } else {
            this.name = name.trim();
        }
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

    public void calculateEfficiency() {
        if (numberOfEmployees == 0) {
            setEfficiency(0);
            return;
        }
        double budgetPerEmployee = budget / numberOfEmployees;
        double calculated = Math.min(100.0, budgetPerEmployee / 1000.0 * 50.0);
        setEfficiency(calculated);
    }

    public String getInfo() {
        return String.format(
                "Отдел: %s | Сотрудников: %d | Бюджет: %.2f | Эффективность: %.1f%%",
                name, numberOfEmployees, budget, efficiency
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Department other = (Department) obj;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}