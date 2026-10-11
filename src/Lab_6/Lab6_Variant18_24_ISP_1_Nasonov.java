package Lab_6;

public class Lab6_Variant18_24_ISP_1_Nasonov {
    void main() {
        // Дефолтный объект
        Grade a = new Grade();
        System.out.println("Дефолтный объект: " + a);
        System.out.println("Баллы: " + a.points());
        System.out.println("Сдал: " + a.isPassing());

        // Объект с параметрами
        Grade b = new Grade('B');
        System.out.println("\nОбъект с параметрами: " + b);
        System.out.println("Баллы: " + b.points());
        System.out.println("Сдал: " + b.isPassing());

        // Копия объекта
        Grade c = new Grade(b);
        System.out.println("\nКопия объекта: " + c);
        System.out.println("Баллы: " + c.points());
        System.out.println("Сдал: " + c.isPassing());
    }
}