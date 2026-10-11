package Lab_2;

import java.util.Scanner;

public class Lab2_Variant18_24_ISP_1_Nasonov {
    void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = sc.nextInt();
        int min1 = 100000;
        int min2 = min1;
        for (int i = 0; i < n; i++) {
            System.out.print("Число: ");
            int num = sc.nextInt();
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        System.out.println("Первое наименьшее: " + min1);
        System.out.println("Второе наименьшее: " + min2);
    }
}