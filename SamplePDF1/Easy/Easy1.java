package Easy;

import java.util.*;

public class Easy1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int q = scan.nextInt();
        int[][] queries = new int[q][3]; // 2D array, q rows, 3 columns

        for (int i = 0; i < q; i++) {
            queries[i][0] = scan.nextInt(); // query type (1 or 2)
            queries[i][1] = scan.nextInt(); // l
            queries[i][2] = scan.nextInt(); // r
        }

        long ans = 0;
        long MOD = 1000000007;

        for (int i = 0; i < q; i++) {
            int type = queries[i][0];
            int l = queries[i][1];
            int r = queries[i][2];

            if (type == 1) {
                int base = arr[l];
                for (int j = l; j <= r; j++) {
                    arr[j] = (j - l + 1) * base; // rank × base
                }
            } else {
                long sum = 0;
                for (int j = l; j <= r; j++) {
                    sum += arr[j];
                }
                ans = (ans + sum) % MOD;
            }
        }

        System.out.println(ans);
    }
}
