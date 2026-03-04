package Easy;

import java.util.*;

public class Easy3 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int c = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int tank = 0;
        int needed = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) {
                if (tank == 0) {
                    needed++;
                    // don't do tank-- here, tank stays 0
                } else {
                    tank--; // only decrease if tank has oil
                }
            } else {
                if (tank < c) {
                    tank++; // only increase if tank not full
                }
                // if tank==c, person is upset but doesn't affect needed
            }
        }

        System.out.println(needed);
    }
}