/*A delivery company operates in a city where locations are connected by roads with different travel times (in minutes).

The company wants to determine the shortest delivery time from its main warehouse to all other locations in the city.

However, due to traffic restrictions:

Travel times between some locations may be different in each direction.

Some locations are not directly connected.

You are given:

V → Total number of locations (numbered from 0 to V-1)

A list of roads in the form (source, destination, travel_time)

A start location representing the warehouse.

Your task:

Using Dijkstra’s Algorithm, calculate the shortest delivery time from the warehouse to every location in the city.

If a location is unreachable, mark its delivery time as "INF".

Input :

V = 6
roads = [
    (0, 1, 7),
    (0, 2, 9),
    (0, 5, 14),
    (1, 2, 10),
    (1, 3, 15),
    (2, 3, 11),
    (2, 5, 2),
    (3, 4, 6),
    (4, 5, 9)
]
start = 0

Output :

Shortest delivery times from warehouse (0):
Location 0 → 0 minutes
Location 1 → 7 minutes
Location 2 → 9 minutes
Location 3 → 20 minutes
Location 4 → 20 minutes
Location 5 → 11 minutes

*/

import java.util.*;
class city_delivery_times{
    static class pair{
        int v,w;
        pair(int v,int w){
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<List<pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        while(sc.hasNextLine()){
            String t = sc.nextLine();
            if(t.isEmpty()) break;
            String[] s = t.split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);
            adj.get(u).add(new pair(v,w));
            adj.get(v).add(new pair(u,w));
        }
        for(List<pair> i:adj){
            for(pair j:i)
                System.out.print(j.v+" "+j.w);
            System.out.println();
        }
        int[] ans = dijsktra(0,n,adj);
        System.out.println(Arrays.toString(ans));
    }
    static int[] dijsktra(int start,int v,List<List<pair>> adj){
        int[] dist = new int[v];
        Arrays.fill(dist,(int)1e8);
        dist[start] = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.w));
        pq.offer(new pair(0,0));
        while(!pq.isEmpty()){
            pair cur = pq.poll();
            int vertex = cur.v;
            for(pair i:adj.get(vertex)){
                int neig = i.v,nweight = i.w;
                if(dist[neig] > dist[vertex]+nweight){
                    dist[neig] = dist[vertex]+nweight;
                    pq.offer(new pair(neig,dist[neig]));
                }
            }
        }
        return dist;
    }
}

