package Lab_8;

public class Lab8_Variant18_24_ISP_1_Nasonov {
    void main() {
        Department department = new Department("Общий отдел", 12, 850000);
        SalesDepartment sales = new SalesDepartment("Отдел продаж", 25, 2500000, 18500000);
        ITDepartment it = new ITDepartment("IT-отдел", 18, 3200000, 42);

        department.calculateEfficiency();
        sales.calculateEfficiency();
        it.calculateEfficiency();

        Department[] departments = {department, sales, it};

        System.out.println("Полиморфизм");
        for (Department dept : departments) {
            System.out.println(dept.getInfo());
        }

        System.out.println("\nИкапсуляция");

        System.out.println("\nОбновление бюджета отдела продаж (+300000)...");
        sales.updateBudget(300000);
        sales.calculateEfficiency();
        System.out.println(sales.getInfo());

        System.out.println("\nСпецифический метод SalesDepartment:");
        System.out.printf("Средние продажи на сотрудника: %.2f%n", sales.getAverageSalesPerEmployee());

        System.out.println("\nСпецифический метод ITDepartment:");
        System.out.printf("Проектов на сотрудника: %.2f%n", it.getProjectsPerEmployee());

        System.out.println("\nПопытка установить некорректные значения:");
        sales.setBudget(-50000);
        sales.setNumberOfEmployees(-10);
        sales.setSalesVolume(-1000);
        sales.calculateEfficiency();
        System.out.println(sales.getInfo());
    }
}