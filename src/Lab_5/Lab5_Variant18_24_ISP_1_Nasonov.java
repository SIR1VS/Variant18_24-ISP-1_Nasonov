package Lab_5;

public class Lab5_Variant18_24_ISP_1_Nasonov {
    public static String repeat(String s, int n) {
        String res = "";
        for (int i = 0; i < n; i++) {
            res += s;
        }
        return res;
    }

    public static String reverse(String s) {
        char[] chars = s.toCharArray();
        String res = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            res += chars[i];
        }
        return res;
    }

    public static boolean isSubstring(String s, String sub) {
        return s.contains(sub);
    }

    void main() {
        // Использование метода repeat
        System.out.println(repeat("ab", 3));

        // Использование метода reverse
        System.out.println(reverse("Hello"));

        // Использование метода isSubstring
        System.out.println(isSubstring("Hello", "ell"));
        System.out.println(isSubstring("Hello", "ab"));
    }
}