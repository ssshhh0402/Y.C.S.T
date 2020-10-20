import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class BJ_2577 {
    static int N = 1;
    static int [] base = new int[10];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        for(int i = 0; i< 3; i++){
            int n = Integer.parseInt(br.readLine());
            N *= n;
        }
        String M = Integer.toString(N);
        Arrays.fill(base, 0);
        for(int idx = 0; idx < M.length(); idx++){
            base[M.charAt(idx) - '0'] += 1;
        }
        for(int a = 0; a < 10; a++){
            System.out.println(base[a]);
        }
    }
}

