package tree_and_graph;
import java.util.*;
class graph2{
    Map<Integer,Set<Integer>> adj = new HashMap<>();
    public void addEdges(int u,int v){
        adj.computeIfAbsent(u,k-> new HashSet<>()).add(v);
        adj.computeIfAbsent(v,k->new HashSet<>()).add(u);
    }
    public void neighbour(){
        for(int i:adj.keySet()){
            System.out.println(i+" "+adj.get(i));
        }
    }
    public void checkEdge(int a,int b){
        System.out.println(adj.get(a).contains(b));
    }
    public void removeEdge(int a,int b){
        if(adj.containsKey(a)) adj.get(a).remove(b);
        if(adj.containsKey(b)) adj.get(b).remove(a);
    }
    public void removeVertex(int a) {
        Set<Integer> s = adj.get(a);
        if(s!=null){
            for (int i : s) {
                adj.get(i).remove(a);
            }
            adj.remove(a);
        }
    }
}
public class edge_exist_and_print_neighbours {
    public static void main(String[] args){
        graph2 g = new graph2();
        g.addEdges(0,1);
        g.addEdges(0,2);
        g.checkEdge(2,1);
        g.neighbour();
        System.out.println("--------------------");
        g.removeEdge(0,1);
        g.neighbour();
        System.out.println("--------------------");
        g.removeVertex(2);
        g.neighbour();
    }
}
