package Lab_12;

import java.util.ArrayList;

public class Lab12_Variant18_24_ISP_1_Nasonov {
    public static void printUnitInfo(OrganizationalUnit unit) {
        System.out.println("Информация об объекте:");
        System.out.println("  " + unit.getBasicInfo());
        unit.calculateEfficiency();
        System.out.println("  Отчёт:");
        System.out.println(unit.generateReport());
        System.out.println();
    }

    public static void processUnits(OrganizationalUnit[] units) {
        System.out.println("[Обработка массива организационных единиц]");
        for (OrganizationalUnit unit : units) {
            System.out.println(unit.generateReport());
            System.out.println("----------------------------------------");
        }
    }

    public static void calculateAllEfficiencies(ArrayList<OrganizationalUnit> list) {
        System.out.println("[Расчёт эффективности для всех объектов]");
        for (OrganizationalUnit unit : list) {
            unit.calculateEfficiency();
            System.out.printf("%s → эффективность: %.1f%%%n", unit.getName(), (unit instanceof Department) ? ((Department) unit).getEfficiency() : 0.0);
        }
    }

    void main () {
        SalesDepartment sales = new SalesDepartment("Отдел продаж", "Активен", 25, 2500000, 18500000);

        ITDepartment it = new ITDepartment("IT-отдел", "Активен", 18, 3200000, 42);

        SalesDepartment sales2 = new SalesDepartment("Региональный отдел продаж", "Активен", 12, 980000, 5400000);

        System.out.println("[Вызов через общий метод, принимающий массив базового типа]");
        OrganizationalUnit[] units = {sales, it, sales2};
        processUnits(units);

        System.out.println("\n[Полиморфизм через ArrayList]");
        ArrayList<OrganizationalUnit> list = new ArrayList<>();
        list.add(sales);
        list.add(it);
        list.add(sales2);

        calculateAllEfficiencies(list);

        System.out.println("\n[Полиморфизм через переменную базового типа]");
        OrganizationalUnit unit;

        unit = sales;
        System.out.println("Реальный тип: " + unit.getClass().getSimpleName());
        System.out.println(unit.generateReport());

        unit = it;
        System.out.println("\nРеальный тип: " + unit.getClass().getSimpleName());
        System.out.println(unit.generateReport());

        System.out.println("\n[Метод, принимающий один объект базового типа]");
        printUnitInfo(sales);
        printUnitInfo(it);

        System.out.println("\n[Один и тот же вызов — разное поведение]");
        OrganizationalUnit[] mixed = {sales, it};
        for (OrganizationalUnit u : mixed) {
            System.out.print(u.getName() + " → нагрузка: ");
            if (u instanceof Department) {
                System.out.printf("%.2f%n", ((Department) u).calculateWorkload());
            }
        }

        System.out.println("\n[Статический метод]");
        System.out.println("Всего создано единиц: " + OrganizationalUnit.getTotalUnitsCreated());
    }
}