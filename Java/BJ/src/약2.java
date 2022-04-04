import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 약2 {
    static int N, answer;
    static boolean [] used;
    public static boolean isPossible(int [] route){
        for(int i = 1; i < N; i+= 3){
            if((route[i]-1) % 3 != 0){
                return false;
            }
        }
        return true;
    }
    public static void recursive(int now, int before, int [] route){
        if(now == N){
            if(isPossible(route)){
                answer += 1;
            }
            return;
        }
        int next = before+1;
        while(true){
            if(next == N){
                next = -1;
            }else{
                if(!used[next]){
                    route[next] = now;
                    used[next] = true;
                    recursive(now+1, next, route);
                    route[next] = 0;
                    used[next] = false;
                    break;
                }
            }
            next += 1;
        }
        next = before-1;
        while(true){
            if(next == -1){
                next = N;
            }else{
                if(!used[next]){
                    route[next] = now;
                    used[next] = true;
                    recursive(now+1, next, route);
                    route[next] = 0;
                    used[next] = false;
                    break;
                }
            }
            next -= 1;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
//        long answer = 2;
//        for(int i = 2; i <= N; i++){
//            answer *= 3;
//        }
        long answer = 2 * (long)Math.pow(3, N-2);
        System.out.println(answer);
    }
}
