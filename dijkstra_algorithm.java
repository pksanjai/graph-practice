import java.util.*;
class dijkstra_algorithm{
    static class pair{
        int vertex,weight;
        pair(int vertex,int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    static int[] dijsktra(int start,int v,List<List<pair>> adj){
        int[] dist = new int[v];
        Arrays.fill(dist,(int)1e8);
        dist[start] = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.weight));
        pq.offer(new pair(start,0));
        while(!pq.isEmpty()){
            pair current = pq.poll();
            int ver = current.vertex;
            for(pair neig:adj.get(ver)){
                int neighbour = neig.vertex;
                int nWeight = neig.weight;
                if(dist[neighbour] > dist[ver] + nWeight){
                    dist[neighbour] = dist[ver] + nWeight;
                    pq.offer(new pair(neighbour,dist[neighbour]));
                }
            }
        }
        return dist;
    }
    
    public static void main(String[] args){
        int v = 5;
        List<List<pair>> adj = new ArrayList<>();
        for(int i=0;i<v;i++) adj.add(new ArrayList<>());
        adj.get(0).add(new pair(1,4));
        adj.get(0).add(new pair(2,8));
        adj.get(1).add(new pair(4,6));
        adj.get(1).add(new pair(2,2));
        adj.get(2).add(new pair(3,2));
        adj.get(3).add(new pair(4,10));
        System.out.println(Arrays.toString(dijsktra(0,v,adj)));
    }
}
