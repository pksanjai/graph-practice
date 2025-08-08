package tree_and_graph;
import java.lang.reflect.Array;
import java.util.*;
public class dfs_recursive {
    public static void dfs(int n,boolean[] visited,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans){
        visited[n] = true;
        ans.add(n);
        for(int i:adj.get(n)){
            if(!visited[i]){
                dfs(i,visited,adj,ans);
            }
        }
    }
    public static void main(String[] dsdf){
        int v = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(4).add(2);
        adj.get(4).add(5);
        adj.get(5).add(4);
        boolean[] vistied = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0,vistied,adj,ans);
        System.out.println(ans);
    }
}
