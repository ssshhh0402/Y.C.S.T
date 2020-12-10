package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_12015_가장긴증가하는수열2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] base = new int[N];
        String[] inputs = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            base[i] = Integer.parseInt(inputs[i]);
        }
        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer.add(0);
        for(int item : base){
            if(item > answer.get(answer.size() - 1)){
                answer.add(item);
            }else{
                int left = 0;
                int right = answer.size() - 1;
                int mid = 0;
                while(left < right){
                    mid = (left + right) / 2;
                    if(answer.get(mid) < item){
                        left = mid + 1;
                    }else{
                        right = mid;
                    }
                }
                answer.set(right, item);
            }
        }
        System.out.println(answer.size()-1);
    }
}
