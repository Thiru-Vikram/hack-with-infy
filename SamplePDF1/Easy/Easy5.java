package Easy;

import java.util.*;

public class Easy5 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = scan.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = row.charAt(j);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int enemyCnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'A') {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 'E') {
                    enemyCnt++;
                }
            }
        }

        int[][] dirc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int time = 0;
        int invaded = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] dic : dirc) {
                    int newRow = row + dic[0];
                    int newCol = col + dic[1];

                    if (newRow >= 0 && newRow < n &&
                            newCol >= 0 && newCol < m &&
                            grid[newRow][newCol] == 'E') {

                        grid[newRow][newCol] = 'A';
                        invaded++;
                        q.add(new int[] { newRow, newCol });
                    }
                }
            }
            if (!q.isEmpty())
                time++;
        }

        if (invaded == enemyCnt) {
            System.out.print(time);
        } else {
            System.out.print(-1);
        }
    }
}