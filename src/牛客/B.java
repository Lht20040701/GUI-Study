package 牛客;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    static int[] arr;
    static int n, x, y;
    public static void main(String[] args) {

        int t = sc.nextInt();
        while (t -- > 0) solved();
    }

    private static void solved() {
        n = sc.nextInt(); x = sc.nextInt(); y = sc.nextInt();
        arr = new int[n + 10];
        double sum = 0;
        for (int i = 1; i <= n; i ++ ) {
            arr[i] = sc.nextInt();
            sum += 1.0 * arr[i];
        }

        double ans = 0;
        Arrays.sort(arr, 1, n + 1);


        double spn = arr[n] * 0.01 * (100 - x), spn1 = arr[n - 1] * 0.01 * (100 - x);
        double ans1 = sum - Math.min(arr[n - 1], y) - spn;
        double ans2 = sum - Math.min(arr[n], y) - spn1;

//        System.out.println("sum -> " + sum);
//        System.out.println("debug -> " + ans1 + " " + ans2);

        if (ans1 < ans2) System.out.println(ans1);
        else System.out.println(ans2);
    }
}
