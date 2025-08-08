package tree_and_graph;

import java.util.*;

class disjoint_set {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    disjoint_set(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    public int findParent(int a) {
        if (parent.get(a) == a) return a;
        int ulp = findParent(parent.get(a));
        parent.set(a, ulp);
        return parent.get(a);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if (ulp_v == ulp_u) return;
        if (rank.get(ulp_u) < rank.get(ulp_v))
            parent.set(ulp_u, ulp_v);
        else if (rank.get(ulp_u) > rank.get(ulp_v))
            parent.set(ulp_v, ulp_u);
        else {
            parent.set(ulp_v, ulp_u);
            int rankOfU = rank.get(ulp_u);
            rank.set(ulp_u, rankOfU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if (ulp_v == ulp_u) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }
    }
}
class disjoint_set_class{
    public static void main(String[] dff){
        disjoint_set d = new disjoint_set(7);
        d.unionByRank(1,2);
        d.unionByRank(2,3);
        d.unionByRank(4,5);
        d.unionByRank(6,7);
        d.unionByRank(5,6);
        System.out.println(d.findParent(3)==d.findParent(7));
        d.unionByRank(3,7);
        System.out.println(d.findParent(3)==d.findParent(7));
    }
}
