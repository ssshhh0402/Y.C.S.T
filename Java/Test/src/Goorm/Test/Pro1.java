package Goorm.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro1 {
    static int answer = 0;
    static int answer_s = 0;
    static long target;
    static long [] times;
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
    }           //이거 중간에 겹친 부분 처리해야한다
    public static void find(int count, int idx, int start, long time){
        if(count > answer){
            answer = count;
            answer_s = start + 1;
        }
        if(idx != times.length -1){
            if(time+times[idx+1] < target) {
                find(count + 1, idx + 1, start, time + times[idx + 1]);
            }else if(time < target && time + times[idx+1] > target){
                find(count + 1, idx + 1, start, time + times[idx+1]);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        times = new long[N];
        target = convert(inputs[1]);
        for(int i = 0; i < N; i++){
            times[i] = convert(br.readLine());
        }
        for(int i = 0 ; i < N; i++){
            find(1,i,i,times[i]);
        }
        System.out.println(answer +" " + answer_s);
    }
}
