package Lab_11;

import java.util.LinkedList;

public class Lab11_Variant18_24_ISP_1_Nasonov {
    private static void printList(LinkedList<Department> list) {
        if (list.isEmpty()) {
            System.out.println("(список пуст)");
            return;
        }
        int index = 1;
        for (Department d : list) {
            System.out.printf("%2d. %s%n", index++, d.getInfo());
        }
    }

    void main () {
        // 1. Создание списка и добавление 7 элементов
        LinkedList<Department> departments = new LinkedList<>();
        departments.add(new Department("Финансы", 45, 2_500_000));
        departments.addFirst(new Department("Маркетинг", 28, 1_800_000));
        departments.addLast(new Department("IT", 62, 4_200_000));
        departments.add(new Department("HR", 15, 900_000));
        departments.addLast(new Department("Производство", 120, 7_500_000));
        departments.addFirst(new Department("Логистика", 35, 1_600_000));
        departments.add(new Department("Исследования", 22, 3_100_000));

        // 2. Вывод списка
        System.out.println("[Вывод списка]");
        printList(departments);

        // 3. Добавление элемента в начало и в конец, повторный вывод списка
        departments.addFirst(new Department("Юридический", 12, 750_000));
        departments.addLast(new Department("Безопасность", 18, 1_100_000));

        System.out.println("\n[После addFirst и addLast]");
        printList(departments);

        // 4. Удаление первого и последнего элемента
        Department removedFirst = departments.removeFirst();
        Department removedLast  = departments.removeLast();

        System.out.println("\nУдалён первый элемент : " + removedFirst.getInfo());
        System.out.println("Удалён последний элемент: " + removedLast.getInfo());

        System.out.println("\n[После removeFirst и removeLast]");
        printList(departments);

        // 5. Получение первого и последнего элемента без удаления
        Department first = departments.getFirst();
        Department last  = departments.getLast();

        System.out.println("\nПервый элемент (getFirst): " + first.getInfo());
        System.out.println("Последний элемент (getLast): " + last.getInfo());

        // 6. Поиск элемента, удовлетворяющего условию (кол-во сотрудников > 50)
        Department found = null;
        for (Department d : departments) {
            if (d.getNumberOfEmployees() > 50) {
                found = d;
                break;
            }
        }

        if (found != null) {
            System.out.println("\nПервый отдел с числом сотрудников > 50: " + found.getInfo());
        } else {
            System.out.println("\nОтдел с числом сотрудников > 50 не найден.");
        }

        // 7. Удаление элементов, удовлетворяющих условию (кол-во сотрудников > 50)
        LinkedList<Department> toRemove = new LinkedList<>();
        for (Department d : departments) {
            if (d.getNumberOfEmployees() > 50) {
                toRemove.add(d);
            }
        }
        departments.removeAll(toRemove);

        System.out.println("\n[После удаления всех отделов с числом сотрудников > 50]");
        printList(departments);

        // 8. Проверка, пуст ли список и его вывод его размера
        System.out.println("\nСписок пуст? " + departments.isEmpty());
        System.out.println("Размер списка: " + departments.size());
    }
}