package tree_and_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class gg{
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    gg(int v){
        for(int i=0;i<v;i++){
            list.add(new ArrayList<Integer>());
        }
    }
    public void addEdges(int u,int v){
        list.get(u).add(v);
        list.get(v).add(u);
    }
    public void bfs(int v,int d){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[list.size()];
        q.add(v);
        visited[v] = true;
        while(!q.isEmpty()){
            int vertex = q.remove();
            for(int i=0;i<list.get(vertex).size();i++){
                int av = list.get(vertex).get(i);
                if(!visited[av]){
                    q.add(av);
                    visited[av] = true;
                }
            }
        }
        if(visited[d]) System.out.println("Exist");
        else System.out.println("Not exist");
    }
}
public class path_exist {
    public static void main(String[] args) {
        gg g1 = new gg(3);
        g1.addEdges(0,1);
        g1.addEdges(1,2);
        g1.bfs(0,2);
    }
}
