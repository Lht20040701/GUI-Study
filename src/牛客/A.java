package 牛客;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {
    static int n;
    static int[] prime;
    static boolean[] st;
    static int cnt;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        prime = new int[200010]; st = new boolean[200010];
        get_primes(200005);

        for (int i = 0; i < cnt; i ++ ) set.add(prime[i]);

        for (int i = 0; i < cnt; i ++ ) {
            if (!set.contains(prime[i] + n)) {
                System.out.println(prime[i]);
                return ;
            }
        }
    }

    private static void get_primes(int n) {
        for (int i = 2; i <= n; i ++ ) {
            if (!st[i]) prime[cnt ++ ] = i;
            for (int j = 0; prime[j] <= n / i; j ++ ) {
                st[prime[j] * i] = true;
                if (i % prime[j] == 0) break;
            }
        }
    }

}
