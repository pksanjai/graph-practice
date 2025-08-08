package tree_and_graph;
import java.util.*;
class graph{
    List<List<Integer>> adj = new ArrayList<>();
    graph(int v){
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
    }

    void addEdges(int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    void bfs(int v){
        boolean[] visited = new boolean[adj.size()];
        int[] parent = new int[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(parent,-1);
        q.add(v);
        visited[v] = true;
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int i=0;i<adj.get(curr).size();i++){
                int ver = adj.get(curr).get(i);
                if(!visited[ver]){
                    q.add(ver);
                    visited[ver] = true;
                    parent[ver] = curr;
                }
                else if(parent[curr] != ver){
                    System.out.println("Cyclic graph");
                    return;
                }
            }
        }
        System.out.println("Not cyclic");
    }
}
public class cyclic_graph {
    public static void main(String[] args) {
        // Non-cyclic graph (tree)
        System.out.println("Test 1: Non-cyclic Graph");
        graph g1 = new graph(5);
        g1.addEdges(0, 1);
        g1.addEdges(0, 2);
        g1.addEdges(1, 3);
        g1.addEdges(1, 4);
        g1.bfs(0); // Should print: Not cyclic

        // Cyclic graph
        System.out.println("Test 2: Cyclic Graph");
        graph g2 = new graph(5);
        g2.addEdges(0, 1);
        g2.addEdges(1, 2);
        g2.addEdges(2, 3);
        g2.addEdges(3, 0); // This introduces a cycle
        g2.bfs(0); // Should print: Cyclic graph
    }

}
