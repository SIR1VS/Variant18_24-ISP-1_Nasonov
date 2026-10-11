package Lab_7;

public class Lab7_Variant18_24_ISP_1_Nasonov {
    void main() {
        Formatter baseFormatter = new Formatter("Standard");
        System.out.println("Объект базового класса: " + baseFormatter);

        System.out.println("\n[Перегруженные методы класса Formatter]");
        System.out.println("format(int)    : " + baseFormatter.format(42));
        System.out.println("format(double) : " + baseFormatter.format(3.14159));
        System.out.println("format(String) : " + baseFormatter.format("Hello"));
        System.out.println("Текущее состояние: " + baseFormatter);

        PrettyFormatter prettyFormatter = new PrettyFormatter();
        System.out.println("\nОбъект класса-наследника: " + prettyFormatter);

        System.out.println("\n[Унаследованные перегруженные методы (PrettyFormatter)]");
        System.out.println("format(int)    : " + prettyFormatter.format(100));
        System.out.println("format(double) : " + prettyFormatter.format(2.71828));

        System.out.println("\n[Демонстрация переопределения метода]");
        System.out.println("Базовый format(String)     : " + baseFormatter.format("World"));
        System.out.println("Переопределённый format(String): " + prettyFormatter.format("World"));

        System.out.println("\n[Полиморфизм (ссылка базового типа)]");
        Formatter polymorphic = new PrettyFormatter("### ", " ###");
        System.out.println("Вызов через ссылку базового типа: " + polymorphic.format("Polymorphism"));
        System.out.println("Состояние объекта: " + polymorphic);

        System.out.println("\n[Конечные состояния объектов]");
        System.out.println("Базовый форматтер   : " + baseFormatter);
        System.out.println("Pretty-форматтер    : " + prettyFormatter);
    }
}