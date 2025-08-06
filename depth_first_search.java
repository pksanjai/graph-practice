import java.util.*;
public class depth_first_search{
    static boolean[] visited;
    static List<Integer> result = new ArrayList<>();
    static void dfs(int start,List<List<Integer>> adj){
        Stack<Integer> st = new Stack<>();
        st.push(start);
        visited[start] = true;
        while(!st.isEmpty()){
            int vertex = st.pop();
            result.add(vertex);
            for(int adjVertex:adj.get(vertex)) {
                if(!visited[adjVertex]){
                    st.push(adjVertex);
                    visited[adjVertex] = true;
                }
            }
        }
        return;
    }
    public static void main(String[] dfg){
        Scanner sc = new Scanner(System.in);
        int noOfVertex = sc.nextInt();
        int noOfEdge = sc.nextInt();
        visited = new boolean[noOfVertex];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<noOfVertex;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<noOfEdge;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int start = sc.nextInt();
        for(int i=0;i<adj.size();i++){
            if(!visited[i]){
                dfs(i,adj);
            }
        }
        System.out.println(result);
    }
}
