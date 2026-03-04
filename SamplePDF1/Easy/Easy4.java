package Easy;

import java.util.*;

public class Easy4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        if (n == 1) {
            System.out.print(0);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> visited = new HashMap<>();
        queue.add(n);
        visited.put(n, 0);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int currMoves = visited.get(curr);

            List<Integer> nextList = new ArrayList<>();
            nextList.add(curr - 1); // op1: always valid
            if (curr % 2 == 0)
                nextList.add(curr / 2); // op2: only if even
            if (curr % 3 == 0)
                nextList.add(curr / 3); // op3: only if div by 3

            for (int val : nextList) {
                if (val >= 1 && !visited.containsKey(val)) {
                    if (val == 1) {
                        System.out.print(currMoves + 1);
                        return;
                    }
                    visited.put(val, currMoves + 1);
                    queue.add(val);
                }
            }
        }
    }
}