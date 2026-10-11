package Lab_1;

public class Lab1_Variant18_24_ISP_1_Nasonov {
    void main() {
        // Задание 1
        double liters = 2.5;
        System.out.println("Объём в литрах: " + liters);
        double cubicMeters = liters * 0.001;
        System.out.println("Объём в куб. метрах: " + cubicMeters);
        double milliliters = liters * 1000;
        System.out.println("Объём в миллитрах: " + milliliters);

        // Задание 2
        String favColor = "фиолетовый";
        System.out.println("\nЛюбимый цвет: " + favColor);

        // Задание 3
        int number = 225;
        System.out.println("\nЧисло: " + number);
        int root = (int) Math.sqrt(number);
        System.out.println("Квадр. корень из числа: " + root);
        int result = (int) Math.pow(root, 3);
        System.out.println("Корень числа в кубе: " + result);
    }
}