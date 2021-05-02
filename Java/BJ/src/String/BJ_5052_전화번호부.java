package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BJ_5052_전화번호부 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int n;
        boolean flag;
        ArrayList<String> base;
        while(T -- > 0){
            flag = true;
            n = Integer.parseInt(br.readLine());
            base = new ArrayList<String>();
            for(int i = 0 ; i < n; i++){
                String[] input = br.readLine().split(" ");
                base.add(String.join("",input));
            }
            Collections.sort(base);
            for(int i = 0 ; i < n-1; i++){
                String target = base.get(i);
                String next = base.get(i+1);
                if(next.startsWith(target)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }
        System.out.print(sb.toString());
    }
}

