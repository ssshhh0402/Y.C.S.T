package Goorm.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro1_2 {
    public static long convert(String target){
        String[] inputs = target.split(":");
        long count = 0;
        if(inputs.length == 3) {
            count += (60 * 60 * Integer.parseInt(inputs[0]));           //시
            count += (60 * Integer.parseInt(inputs[1]));                //분
            count += Integer.parseInt(inputs[2]);
        }                                                               //초
        else{
            count += (60 * Integer.parseInt(inputs[0]));                //분
            count += Integer.parseInt(inputs[1]);                           //초
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int answer = 0;
        int answer_s = 0;
        int N = Integer.parseInt(inputs[0]);
        long [] times = new long[N];
        long target = convert(inputs[1]);
        for(int i = 0; i < N; i++){
            times[i] = convert(br.readLine());
        }
        int start = 0, end = 0;
        int sum = 0;
        while(end < N && start <= end){
            if(sum < target){
                sum += times[end++];
            }else{
                if(end - start > answer){
                    answer = end- start;
                    answer_s = start + 1;
                }
                sum -= times[start ++];
            }
        }
        System.out.println(answer + " " + answer_s);
    }
}
