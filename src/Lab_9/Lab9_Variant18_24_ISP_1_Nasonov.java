package Lab_9;

import java.util.ArrayList;

public class Lab9_Variant18_24_ISP_1_Nasonov {
    void main() {
        // 1. Создание ArrayList и добавление не менее 5 объектов
        ArrayList<Department> departments = new ArrayList<>();
        departments.add(new Department("Отдел продаж", 25, 2500000));
        departments.add(new Department("IT-отдел", 18, 3200000));
        departments.add(new Department("HR-отдел", 8, 650000));
        departments.add(new Department("Финансовый отдел", 12, 1800000));
        departments.add(new Department("Отдел маркетинга", 15, 1450000));

        for (Department dept : departments) {
            dept.calculateEfficiency();
        }

        // 2. Вывод всего списка через for
        System.out.println("[Вывод списка через for]");
        for (int i = 0; i < departments.size(); i++) {
            System.out.println((i + 1) + ". " + departments.get(i).getInfo());
        }

        // 2. Вывод всего списка через for-each
        System.out.println("\n[Вывод списка через for-each]");
        for (Department dept : departments) {
            System.out.println(dept.getInfo());
        }

        // 3. Добавление объекта в начало и в конец списка
        System.out.println("\n[Добавление объекта в начало и в конец]");
        departments.add(0, new Department("Юридический отдел", 6, 920000)); // в начало
        departments.add(new Department("Отдел логистики", 10, 1100000));     // в конец

        departments.get(0).calculateEfficiency();
        departments.get(departments.size() - 1).calculateEfficiency();

        System.out.println("Список после добавления:");
        for (Department dept : departments) {
            System.out.println(dept.getInfo());
        }

        // 4. Удаление одного элемента по индексу и одного — по значению
        System.out.println("\n[Удаление элементов]");
        System.out.println("Удаляем элемент с индексом 2:");
        departments.remove(2);

        System.out.println("Удаляем объект по значению (Финансовый отдел):");
        Department toRemove = new Department("Финансовый отдел", 12, 1800000);
        departments.remove(toRemove);

        System.out.println("Список после удаления:");
        for (Department dept : departments) {
            System.out.println(dept.getInfo());
        }

        // 5. Вывод текущего размера списка
        System.out.println("\n[Текущий размер списка]");
        System.out.println("Размер списка: " + departments.size());

        // 6. Получение элемента по индексу и вывод одного из его полей
        System.out.println("\n[Получение элемента по индексу]");
        if (departments.size() > 1) {
            Department selected = departments.get(1);
            System.out.println("Элемент с индексом 1: " + selected.getName());
        }

        // 7. Изменение одного поля у выбранного объекта через set()
        System.out.println("\n[Изменение объекта через set()]");
        if (departments.size() > 0) {
            Department modified = departments.get(0);
            modified.setBudget(1500000);
            modified.calculateEfficiency();
            departments.set(0, modified);
            System.out.println("Обновлённый элемент с индексом 0:");
            System.out.println(departments.get(0).getInfo());
        }

        // 8. Поиск первого объекта, у которого бюджет больше заданного числа
        System.out.println("\n[Поиск объекта по условию]");
        double threshold = 2000000;
        Department found = null;
        for (Department dept : departments) {
            if (dept.getBudget() > threshold) {
                found = dept;
                break;
            }
        }
        if (found != null) {
            System.out.println("Первый отдел с бюджетом больше " + threshold + ":");
            System.out.println(found.getInfo());
        } else {
            System.out.println("Отдел с бюджетом больше " + threshold + " не найден.");
        }

        // 9. Проверка наличия конкретного объекта (contains)
        System.out.println("\n[Проверка наличия объекта]");
        Department check = new Department("IT-отдел", 18, 3200000);
        boolean exists = departments.contains(check);
        System.out.println("Содержится ли объект \"IT-отдел\": " + exists);

        // 10. Очистка списка и вывод размера
        System.out.println("\n[Очистка списка]");
        departments.clear();
        System.out.println("Размер списка после clear(): " + departments.size());
    }
}