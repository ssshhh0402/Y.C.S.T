import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Pro1 {
    static ArrayList<String> answers;
    static boolean [] used;
    public static void find(String now, int idx, int count, int N){
        if(N == count){
            answers.add(now);
            return;
        }
        for(int i = idx-1; i > 0; i--){
            if(!used[i]){
                used[i] = true;
                find(now + String.valueOf(i), i, count+1, N);
                used[i] = false;
                break;
            }
        }
        for(int i = idx+1; i < N+1; i++){
            if(!used[i]){
                used[i] = true;
                find(now + String.valueOf(i), i, count+1, N);
                used[i] = false;
            }
        }
    }
    public static ArrayList<String> solution(int N){
        answers = new ArrayList<String>();
        used = new boolean[N+1];
        for(int i = 1; i < N+1; i++){
            used[i] = true;
            find(String.valueOf(i), i, 1, N);
            used[i] = false;
        }
        return answers;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        int N;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0){
                break;
            }
            results.add(solution(N));
        }
        for(ArrayList<String> result : results){
            for(String answer : result){
                System.out.println(answer);
            }
            System.out.println("");
        }
    }
}
