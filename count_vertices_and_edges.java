package tree_and_graph;
import java.util.*;
class graph1{
    Map<Integer,Set<Integer>> adj = new HashMap<>();
    public void addEdges(int u,int v){
        if(!adj.containsKey(u)) adj.put(u,new HashSet<>());
        adj.get(u).add(v);
        if(!adj.containsKey(v)) adj.put(v,new HashSet<>());
        adj.get(v).add(u);
    }
    void count(){
        int vertexCount = adj.size();
        int totalEdgeCount = 0;
        for(Set<Integer> i:adj.values()) totalEdgeCount+=i.size();
        int edgeCount = totalEdgeCount/2;
        System.out.printf("Vertex count : %d \nEdge count : %d",vertexCount,edgeCount);
    }
}
public class count_vertices_and_edges {
    public static void main(String[] args) {
        graph1 g = new graph1();
        g.addEdges(1,2);
        g.addEdges(1,3);
        g.addEdges(2,4);
        g.count();
    }
}
