import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class 여행경로 {
    static int n;
    static boolean [] visited;
    static ArrayList<String> answers;
    public static void find(String [][] tickets, String now, int count, String routes){
        if(count == n){
            answers.add(routes);
            return;
        }
        for(int i = 0 ; i < n; i++){
            if(!visited[i] && tickets[i][0].equals(now)){
                visited[i] = true;
                String route = routes + ","+ tickets[i][1];
                find(tickets,tickets[i][1], count + 1, route);
                visited[i] = false;
            }
        }
    }
    public static String [] solution(String [][] tickets){
        answers = new ArrayList<>();
        n = tickets.length;
        for(int i = 0 ; i < n; i++){
            if(tickets[i][0].equals("ICN")){
                visited = new boolean[n];
                visited[i] = true;
                String route = tickets[i][0] + "," + tickets[i][1];
                find(tickets, tickets[i][1],1, route);
                visited[i] = false;
            }
        }
        Collections.sort(answers);
        String [] answer = answers.get(0).split(",");
        return answer;
    }
    public static void main(String[] args) throws IOException{
        String[] answers = solution(new String [][] {{"ICN","JFK"},{"HND","IAD"},{"JFK","HND"}});
        for(String answer : answers){
            System.out.print(answer + " ");
        }
        System.out.println("-------------------");
        answers = solution(new String [][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
        for(String answer : answers){
            System.out.print(answer + " ");
        }
        System.out.println("-----------------------");
        answers = solution(new String [][] {{"ICN","A"},{"ICN","B"},{"B","ICN"}});
        for(String answer : answers){
            System.out.print(answer + " ");
        }
    }
}
