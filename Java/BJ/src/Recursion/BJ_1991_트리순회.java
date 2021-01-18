package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BJ_1991_트리순회 {
    static Map<String, String[]> base;
    static String[] inputs;
    static StringBuffer sb;
    public static void preOrder(String start){
        sb.append(start);
        if(!base.get(start)[0].equals(".")){
            preOrder(base.get(start)[0]);
        }
        if(!base.get(start)[1].equals(".")){
            preOrder(base.get(start)[1]);
        }
    }
    public static void inOrder(String start){
        if(!base.get(start)[0].equals(".")){
            inOrder(base.get(start)[0]);
        }
        sb.append(start);
        if(!base.get(start)[1].equals(".")){
            inOrder(base.get(start)[1]);
        }
    }
    public static void postOrder(String start){
        if(!base.get(start)[0].equals(".")){
            postOrder(base.get(start)[0]);
        }
        if(!base.get(start)[1].equals(".")){
            postOrder(base.get(start)[1]);
        }
        sb.append(start);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        base = new HashMap<String, String[]>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N; i++){
            inputs = br.readLine().split(" ");
            String[] temps = new String[2];
            temps[0] = inputs[1];
            temps[1] = inputs[2];
            base.put(inputs[0], temps);
        }
        preOrder("A");
        sb.append("\n");
        inOrder("A");
        sb.append("\n");
        postOrder("A");
        System.out.println(sb.toString());
    }
}
