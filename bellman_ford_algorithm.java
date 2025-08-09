import java.util.*;
class bellman_ford_algorithm{
	public static int[] bellman_ford(int start,int n,int[][] edges) {
		int[] dist = new int[n];
		Arrays.fill(dist,(int)1e8);
		dist[start] = 0;
		for(int i=0; i<n-1; i++) {
			for(int[] edge:edges) {
				int u = edge[0];
				int v = edge[1];
				int w = edge[2];
				if(dist[u] != (int)1e8 && dist[v] > dist[u] + w) {
					dist[v] = dist[u] + w;
				}
			}
		}
		for(int[] edge:edges) {
			int u = edge[0];
			int v = edge[1];
			int w = edge[2];
			if(dist[u] != (int)1e8 && dist[v] > dist[u] + w) {
				// dist[v] = dist[u] + w;
				return new int[] {-1};
			}
		}
		return dist;

	}

	public static void main(String[] args) {
		int v = 6;
		int[][] edges = new int[][] {
			{0, 1, 4},
			{0, 2, 3},
			{1, 3, 2},
			{2, 1, 1},
			{3, 2, -2},
			{3, 4, 2},
			{4, 5, 6}
		};
		int src = 0;

		int[] ans = bellman_ford(src,v, edges);
		System.out.println(Arrays.toString(ans));
	}
}
