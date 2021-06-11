import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class testing {
    static int answer = 1;
    static int n;
    static int [] items;
    static boolean [] used;
    public static void find(int count){
        if(count == n){
            answer += 1;
            return;
        }else {
            for (int i = 0; i < n; i++) {
                if(!used[i]){
                    used[i] = true;
                    find(count+1);
                    used[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> tong = new ArrayList<Integer>();
        n = 11;
        items = new int[n];
        used = new boolean[n];
        for(int i = 0 ;i  < n; i++){
            items[i] = i;
        }
        for(int i = n-1; i > 0; i--){
            if(!used[i]){
                used[i] = true;
                find(1);
                used[i] = false;
            }
        }

        System.out.println(answer);
    }
}
