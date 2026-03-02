import java.util.*;

public class Easy2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        HashMap<Integer, Integer> freq = new HashMap<>();
        long maxSum = 0;
        long currSum = 0;
        int distinct = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {
            // add right element to window
            freq.put(arr[r], freq.getOrDefault(arr[r], 0) + 1);
            if (freq.get(arr[r]) == 1) {
                distinct++; // new element seen
            }
            currSum += arr[r];

            // shrink window from left if distinct > k
            while (distinct > k) {
                currSum -= arr[l];
                freq.put(arr[l], freq.get(arr[l]) - 1);
                if (freq.get(arr[l]) == 0) {
                    distinct--; // element completely removed
                }
                l++;
            }

            // update max (only if sum is positive)
            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }

        System.out.println(maxSum);
    }
}