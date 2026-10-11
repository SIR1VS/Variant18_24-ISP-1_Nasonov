package Lab_8;

public class ITDepartment extends Department {
    private int numberOfProjects;

    public ITDepartment(String name, int numberOfEmployees, double budget, int numberOfProjects) {
        super(name, numberOfEmployees, budget);
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

    public double getProjectsPerEmployee() {
        if (getNumberOfEmployees() == 0) {
            return 0.0;
        }
        return (double) numberOfProjects / getNumberOfEmployees();
    }

    @Override
    public void calculateEfficiency() {
        double baseEfficiency;
        if (getNumberOfEmployees() == 0) {
            baseEfficiency = 0;
        } else {
            double budgetPerEmployee = getBudget() / getNumberOfEmployees();
            baseEfficiency = Math.min(60.0, budgetPerEmployee / 1000.0 * 35.0);
        }
        double load = getProjectsPerEmployee();
        double projectContribution;
        if (load >= 1.5 && load <= 2.5) {
            projectContribution = 40.0;
        } else if (load > 0) {
            projectContribution = Math.max(0, 40.0 - Math.abs(load - 2.0) * 15.0);
        } else {
            projectContribution = 0;
        }
        setEfficiency(Math.min(100.0, baseEfficiency + projectContribution));
    }

    @Override
    public String getInfo() {
        return super.getInfo() + String.format(" | Проектов: %d | Проектов/сотрудник: %.2f", numberOfProjects, getProjectsPerEmployee());
    }
}