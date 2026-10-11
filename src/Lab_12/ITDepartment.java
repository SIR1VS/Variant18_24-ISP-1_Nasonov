package Lab_12;

public class ITDepartment extends Department {
    private int numberOfProjects;

    public ITDepartment(String name, String status, int numberOfEmployees, double budget, int numberOfProjects) {
        super(name, status, numberOfEmployees, budget);
        setNumberOfProjects(numberOfProjects);
    }

    public int getNumberOfProjects() {
        return numberOfProjects;
    }

    public void setNumberOfProjects(int numberOfProjects) {
        if (numberOfProjects < 0) {
            this.numberOfProjects = 0;
        } else {
            this.numberOfProjects = numberOfProjects;
        }
    }

    @Override
    public void calculateEfficiency() {
        double base;
        if (getNumberOfEmployees() == 0) {
            base = 0;
        } else {
            double budgetPerEmployee = getBudget() / getNumberOfEmployees();
            base = Math.min(60.0, budgetPerEmployee / 1000.0 * 35.0);
        }
        double load = calculateWorkload();
        double projectBonus;
        if (load >= 1.5 && load <= 2.5) {
            projectBonus = 40.0;
        } else if (load > 0) {
            projectBonus = Math.max(0, 40.0 - Math.abs(load - 2.0) * 15.0);
        } else {
            projectBonus = 0;
        }
        setEfficiency(Math.min(100.0, base + projectBonus));
    }

    @Override
    public double calculateWorkload() {
        if (getNumberOfEmployees() == 0) {
            return 0.0;
        }
        return (double) numberOfProjects / getNumberOfEmployees();
    }

    @Override
    public String generateReport() {
        return String.format(
                "Отчёт IT-отдела \"%s\":\n" +
                        "  Сотрудников: %d\n" +
                        "  Бюджет: %.2f\n" +
                        "  Количество проектов: %d\n" +
                        "  Эффективность: %.1f%%\n" +
                        "  Нагрузка (проектов/сотрудник): %.2f",
                getName(), getNumberOfEmployees(), getBudget(),
                numberOfProjects, getEfficiency(), calculateWorkload()
        );
    }
}