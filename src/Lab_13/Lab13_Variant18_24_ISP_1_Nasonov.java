package Lab_13;

public class Lab13_Variant18_24_ISP_1_Nasonov {
    void main () {
        SalesDepartment sales = new SalesDepartment("Отдел продаж", "Активен", 25, 2500000, 18500000);
        sales.calculateEfficiency();

        System.out.println("[Ссылка типа абстрактного класса (OrganizationalUnit)]");
        OrganizationalUnit unitRef = sales;

        System.out.println(unitRef.getBasicInfo());
        unitRef.calculateEfficiency();
        System.out.println("Статический метод класса: создано единиц = " + OrganizationalUnit.getTotalUnitsCreated());

        System.out.println("\n[Ссылка типа конкретного класса (SalesDepartment)]");
        System.out.println(sales.getBasicInfo());
        System.out.println("Средние продажи на сотрудника: " + sales.getAverageSalesPerEmployee());
        System.out.println(sales.generateReport());
        System.out.println(sales.getEvaluationSummary());

        System.out.println("\n[Ссылка типа интерфейса (Evaluable)]");
        Evaluable evalRef = sales;

        System.out.println("Эффективность через интерфейс: " + evalRef.getEfficiency() + "%");
        System.out.println(evalRef.generateReport());
        System.out.println(evalRef.getEvaluationSummary());

        System.out.println("Статический метод интерфейса: " + Evaluable.formatEfficiency(evalRef.getEfficiency()));

        System.out.println("\n[Полиморфизм]");
        OrganizationalUnit[] units = {sales};
        for (OrganizationalUnit u : units) {
            u.calculateEfficiency();
            System.out.println("Через OrganizationalUnit: " + u.getBasicInfo());
        }

        Evaluable[] evaluables = {sales};
        for (Evaluable e : evaluables) {
            System.out.println("Через Evaluable: " + e.getEvaluationSummary());
        }
    }
}