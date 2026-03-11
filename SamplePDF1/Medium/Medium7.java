package Medium;

import java.util.*;

class DisjointSet {

    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node))
            return node;

        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return ultimateParent;
    }

    public boolean unionFind(int u, int v) {
        int ultp_u = findParent(u);
        int ultp_v = findParent(v);

        if (ultp_u == ultp_v)
            return false;

        if (size.get(ultp_u) < size.get(ultp_v)) {
            parent.set(ultp_u, ultp_v);
            size.set(ultp_v, size.get(ultp_v) + size.get(ultp_u));
        } else {
            parent.set(ultp_v, ultp_u);
            size.set(ultp_u, size.get(ultp_v) + size.get(ultp_u));
        }
        return true;
    }
}

public class Medium7 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int q = scan.nextInt();
        int t = scan.nextInt();

        int[][] queries = new int[q][3];
        for (int i = 0; i < q; i++) {
            queries[i][0] = scan.nextInt();
            queries[i][1] = scan.nextInt();
            queries[i][2] = scan.nextInt();
        }

        DisjointSet ds = new DisjointSet(n + 1);
        int[] ranges = new int[n + 1];
        Arrays.fill(ranges, 1);

        ranges[0] = 0;
        long ans = 0;

        for (int[] que : queries) {
            int type = que[0];
            int l = que[1];
            int r = que[2];

            if (type == 1) {
                int root_u = ds.findParent(l);
                int root_v = ds.findParent(r);

                if (root_u != root_v) {
                    int newRange = ranges[root_u] + ranges[root_v];

                    if (Math.abs(l - r) == 1) {
                        newRange--;
                    }

                    ds.unionFind(l, r);
                    int newRoot = ds.findParent(l);
                    ranges[newRoot] = newRange;
                } else {
                    int root = ds.findParent(l);
                    ans += ranges[root];
                }
            }
        }

        System.out.print(ans);
    }

}