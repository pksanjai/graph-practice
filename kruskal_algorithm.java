import java.util.*;
class kruskal_algorithm{
  public static int kruskal(int v,int[][] edges){
    Arrays.sort(edges,Comparator.comparingInt(a->a[2]));
    disjoint ds = new disjoint(v);
    int cost = 0;
    for(int[] edge:edges){
      int start = edge[0],end = edge[1],weight = edge[2];
      if(ds.find(start)!= ds.find(end)){
        cost+=weight;
        ds.union(start,end);
      }
    }
    return cost;
  }
  public static void main(String[] dfg){
    int v = 7;
    int[][] edges = {{0, 1, 10}, {1, 3, 15}, {2, 3, 4}, {2, 0, 6}, {0, 3, 5}};
    int c = kruskal(v,edges);
    System.out.println(c);
  }
}
class disjoint{
  int[] parent,rank;
  disjoint(int v){
    this.parent = new int[v+1];
    this.rank = new int[v+1];
    for(int i=0;i<=v;i++){
      parent[i] = i;
      rank[i] = 0;
    }
  }
  int find(int n){
    if(parent[n] == n) return n;
    int up = find(parent[n]);
    parent[n] = up;
    return parent[n];
  }
  void union(int a,int b){
    int upa = find(a);
    int upb = find(b);
    if(upa == upb) return;
    if(rank[upa]>rank[upb]){
      parent[upb] = upa;
    }else if(rank[upa]<rank[upb]){
      parent[upa] = upb;
    }
    else{
      parent[upb] = upa;
      rank[upa] +=1;
    }
  }
}
