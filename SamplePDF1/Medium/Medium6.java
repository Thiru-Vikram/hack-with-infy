package Medium;

import java.util.*;

public class Medium6 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scan.nextInt();

        // dp[i] = max expert number for first i elements
        long[] dp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            HashSet<Integer> set = new HashSet<>();
            int expertVal = 0;

            // try all groups ending at i
            for (int j = i - 1; j >= 0; j--) {
                set.add(arr[j]);
                while (set.contains(expertVal))
                    expertVal++;

                // group arr[j..i-1] has expertVal
                dp[i] = Math.max(dp[i], dp[j] + expertVal);
            }
        }

        System.out.println(dp[n]);

    }
}