package Lab_3;

import java.util.Scanner;

public class Lab3_Variant18_24_ISP_1_Nasonov {
    void main() {
        Scanner sc = new Scanner(System.in);
        // Задание 1 (задача 19)
        System.out.print("Введите часы: ");
        int h = sc.nextInt();
        System.out.print("Введите минуты: ");
        int m = sc.nextInt();
        if ((h >= 0 && h <= 23) && (m >= 0 && m <= 59)) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }

        // Задание 2 (задача 23)
        System.out.print("\nВведите оценку: ");
        String grade = sc.next().toUpperCase();
        switch (grade) {
            case "A": System.out.println("excellent");
                break;
            case "B": System.out.println("good");
                break;
            case "C": System.out.println("satisfactory");
                break;
            case "D": System.out.println("poor");
                break;
            case "F": System.out.println("fail");
                break;
            default: System.out.println("invalid");
                break;
        }

        // Задание 3 (задача 7)
        System.out.print("\nВведите температуру (в градусах): ");
        int t = sc.nextInt();
        String result = (t <= 0) ? "freezing" :
                        (t <= 15) ? "cold" :
                        (t <= 25) ? "mild" : "hot";
        System.out.println(result);
    }
}
