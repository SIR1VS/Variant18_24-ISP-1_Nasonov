package Lab_10;

public class Lab10_Variant18_24_ISP_1_Nasonov {
    void main() {
        SalesDepartment sales = new SalesDepartment("Отдел продаж", "Активен", 25, 2500000, 18500000);

        ITDepartment it = new ITDepartment("IT-отдел", "Активен", 18, 3200000, 42);

        System.out.println("[Обычные методы]");
        System.out.println(sales.getBasicInfo());
        System.out.println(sales.getDepartmentInfo());
        System.out.println();
        System.out.println(it.getBasicInfo());
        System.out.println(it.getDepartmentInfo());

        System.out.println("\n[Абстрактные методы (переопределённые)]");
        sales.calculateEfficiency();
        it.calculateEfficiency();

        System.out.println("Эффективность отдела продаж: " + sales.getEfficiency() + "%");
        System.out.println("Эффективность IT-отдела: " + it.getEfficiency() + "%");

        System.out.println("\nНагрузка отдела продаж: " + sales.calculateWorkload());
        System.out.println("Нагрузка IT-отдела: " + it.calculateWorkload());

        System.out.println("\n[Отчёты]");
        System.out.println(sales.generateReport());
        System.out.println();
        System.out.println(it.generateReport());

        System.out.println("\n[Статические методы]");
        System.out.println("Всего создано организационных единиц: " + OrganizationalUnit.getTotalUnitsCreated());

        System.out.println("Проверка названия \"Отдел продаж\": " + OrganizationalUnit.isValidName("Отдел продаж"));
        System.out.println("Проверка пустого названия: " + OrganizationalUnit.isValidName(""));

        System.out.println("\n[Полиморфизм через ссылку]");
        OrganizationalUnit unit1 = sales;
        OrganizationalUnit unit2 = it;

        unit1.calculateEfficiency();
        unit2.calculateEfficiency();

        System.out.println(unit1.generateReport());
        System.out.println();
        System.out.println(unit2.generateReport());
    }
}