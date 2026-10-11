package Lab_4;

import java.util.Random;

public class Lab4_Variant18_24_ISP_1_Nasonov {
    void printArray(int[] a) {
        for (int element : a) {
            System.out.print(element + "\t");
        }
    }

    void main() {
        // Задание (вариант 18)
        int[] a = new int[10];
        System.out.println("Массив: ");
        for (int i = 0; i < a.length; i++) {
            Random rand = new Random();
            a[i] = rand.nextInt(10, 100);
        }

        // Задание 1
        printArray(a);

        // Задание 2
        int kolich = 0;
        int elem = a[0];
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    count++;
                }
            }
            if (count > kolich) {
                kolich = count;
                elem = a[i];
            }
        }

        // Задание 3
        if (kolich <= 1) {
            System.out.println("\nОдинаковые элементы не найдены");
        } else {
            System.out.println("\nКоличество одинаковых элементов: " + kolich);
            System.out.println("Элемент: " + elem);
        }
    }
}