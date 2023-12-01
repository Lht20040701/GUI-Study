package 牛客;

import java.math.BigInteger;
import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int Mod = 998244353;
    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t -- > 0) solved();
    }

    private static void solved() {
        n = sc.nextInt();
        if (n < 3) {
            System.out.println(0);
            return ;
        }
//        long ans = (long) (n - 2) * qmi(26, n - 3, Mod);
        BigInteger bi = new BigInteger("26");
        bi = bi.pow(n - 3);
        bi = bi.multiply(BigInteger.valueOf(n - 2));
        System.out.println(bi.mod(BigInteger.valueOf(Mod)));
    }

    private static long qmi(int a, int k, int p) {
        long res = 1;
        while (k != 0) {
            if ((k & 1) == 1) res = res * a % p;
            k >>= 1;
            a = a * a % p;
        }
        return res;
    }
}

//32095106
//947739998
//633590709

//866730100
//551952279
//943410719

//321733481
//331769901
//407316649