import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 멀티버스 {
    static int N, M;
    public static boolean isPossible(int [] one, int [] two){
        for(int i = 0; i < M; i++){
            for(int j = i+1; j < M; j++){
                int o = one[j] > one[i] ? 2 : one[j] == one[i] ? 1 : 0;
                int t = two[j] > two[i] ? 2 : two[j] == two[i] ? 1 : 0;
                if(o != t){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]); M = Integer.parseInt(inputs[1]);
        int [][] base = new int[N][M];
        for(int i = 0; i < N; i++){
            inputs = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                base[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        int answer = 0;
        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if(isPossible(base[i], base[j])){
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}
