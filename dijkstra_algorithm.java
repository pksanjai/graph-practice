package tree_and_graph;
import java.util.*;
public class dijkstra_algorithm {
    static ArrayList<ArrayList<ArrayList<Integer>>> constructAdj(int[][] edges,int s){
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i=0;i<=s;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0],v = edge[1],w = edge[2];
            ArrayList<Integer> e1 = new ArrayList<>();
            e1.add(v);
            e1.add(w);
            adj.get(u).add(e1);
            ArrayList<Integer> e2 = new ArrayList<>();
            e2.add(u);
            e2.add(w);
            adj.get(v).add(e2);
        }
        return adj;
    }
    static int[] dijkstra(int n,int[][] edges,int s){
        ArrayList<ArrayList<ArrayList<Integer>>> adj = constructAdj(edges,n);
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.get(1)));
        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[s] = 0;
        ArrayList<Integer> start = new ArrayList<>();
        start.add(s);
        start.add(0);
        pq.offer(start);
        while(!pq.isEmpty()){
            ArrayList<Integer> cur = pq.poll();
            int d = cur.get(1);
            int u = cur.get(0);
            for(ArrayList<Integer> neighbour:adj.get(u)){
                int v = neighbour.get(0);
                int w = neighbour.get(1);
                if(dis[v] > dis[u] + w){
                    dis[v] = dis[u] + w;
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(dis[v]);
                    temp.add(v);
                    pq.offer(temp);
                }
            }
        }
        return dis;
    }

    public static void main(String[] args) {
        int v = 0;
        int scr = 0;
        int[][] edges =  {{0, 1, 4}, {0, 2, 8}, {1, 4, 6}, {2, 3, 2}, {3, 4, 10}};
        int[] result = dijkstra(v,edges,scr);
        System.out.println(Arrays.toString(result));
    }
}
