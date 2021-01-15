package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10924_팰린드롬 {
    static String[] inputs;
    public static int find(int start, int end){
        while(start <= end){
            if(!inputs[start].equals(inputs[end])){
                return 0;
            }
            start += 1;
            end -= 1;
        }
        return 1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        inputs = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < M; i++){
            String[] temps = br.readLine().split(" ");
            int answer = find(Integer.parseInt(temps[0])-1, Integer.parseInt(temps[1])-1);
            sb.append(answer + "\n");
        }
        System.out.println(sb.toString());
    }
}
