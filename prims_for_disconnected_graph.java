import java.util.*;
public class prims_for_disconnected {
    static class pair{
        char s,d;
        int w;
        pair(char s,String d,String w){
            this.s = s;
            this.d = d.charAt(0);
            this.w = Integer.parseInt(w);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] edges = sc.nextLine().split(" ");    //input : A-B-3 B-C-1 A-C-2 D-E-4
        Map<Character, List<String[]>> adj = new HashMap<>();
        for(String i:edges){
            char k = i.charAt(0);
            String v = ""+i.charAt(2);
            String w = i.substring(4);
            adj.computeIfAbsent(k,a->new ArrayList<>()).add(new String[] {v,w});
            adj.computeIfAbsent(v.charAt(0),a->new ArrayList<>()).add(new String[] {""+k,w});
        }
//        for (char i: adj.keySet()){
//            System.out.println(i+" : ");
//            for (String[] j:adj.get(i)){
//                System.out.print(Arrays.toString(j)+" ");
//            }
//            System.out.println();
//        }
        Map<Character,Boolean> visited = new HashMap<>();
        for(char i:adj.keySet())
            visited.put(i,false);
        for(char v:visited.keySet()){
            if(!visited.get(v)){
                prims(v,visited,adj);
            }
        }
    }
    static void prims(char v,Map<Character,Boolean> visited,Map<Character,List<String[]>> adj){
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.w,b.w));
        int sum =0;
        pq.offer(new pair(v,"1","0"));
        while(!pq.isEmpty()){
            pair cur = pq.poll();
            char s = cur.s;
            if(visited.get(s)) continue;
            visited.put(s,true);
            if(cur.d!='1'){
                // System.out.printf("%c - %c : %d\n",cur.d,cur.s,cur.w);
                sum+=cur.w;
            }
            for(String[] i:adj.get(s)){
                if(!visited.get(i[0].charAt(0))){
                    pq.offer(new pair(i[0].charAt(0),""+s,i[1]));
                }
            }
        }
        System.out.println("Sum : "+sum);
    }
}
