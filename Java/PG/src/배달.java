import java.util.ArrayList;
class Pair{
    int end;
    int weight;

    Pair(int a, int b){
        this.end = a;
        this.weight = b;
    }
}
public class 배달 {

    public static ArrayList<Integer> find(int x, ArrayList<Pair>[] base, int target,boolean[] visited){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer.add(x);
        if(target == 0){
            return answer;
        }
        for(Pair item : base[x]){
            int end = item.end;
            int weight = item.weight;
            if(weight <= target && !visited[end]){
                visited[end] = true;
                ArrayList<Integer> temps = find(end,base,target - weight, visited);
                for(int temp : temps){
                    if (!answer.contains(temp)){
                        answer.add(temp);
                    }
                }
                visited[end] = false;
            }
        }
        return answer;
    }
    public static int solution(int N, int [][] road ,int K){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        boolean [] visited = new boolean[N+1];
        ArrayList<Pair> [] base = new ArrayList[N+1];
        visited[1] = true;
        answer.add(1);
        for(int i = 0; i < N+1; i++){
            base[i] = new ArrayList<Pair>();
        }
        for(int [] item : road){
            int start = item[0];
            int end = item[1];
            int weight = item[2];
            base[start].add(new Pair(end, weight));
            base[end].add(new Pair(start, weight));
        }
        for(Pair item : base[1]) {
            if (item.weight <= K) {
                visited[item.end] = true;
                ArrayList<Integer> temps = find(item.end, base, (K - item.weight), visited);
                for (int temp : temps) {
                    if (!answer.contains(temp)) {
                        answer.add(temp);
                    }
                }
                visited[item.end] = false;
            }

        }
        return answer.size();
    }
    public static void main(String[] args){
        System.out.println(solution(5,new int [][] {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}},3));
        System.out.println(solution(6,new int [][] {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}},4));
    }
}
