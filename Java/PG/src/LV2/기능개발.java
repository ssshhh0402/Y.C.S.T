package LV2;

import java.util.ArrayList;
import java.util.Stack;

public class 기능개발 {
    public static int [] solution(int [] progress, int [] speeds){
        Stack<Integer> st = new Stack<Integer>();
        int count = 0;
        int left, now;
        int n = progress.length;
        for(int i = 0; i < n; i++){
            left = 100 - progress[i];
            if(left % speeds[i] == 0){
                now = left / speeds[i];
            }else{
                now = left / speeds[i]+1;
            }
            if(now <= count){
                if(st.isEmpty()){
                    st.add(1);
                }else{
                    int before = st.pop();
                    st.add(before+1);
                }
            }else{
                count = now;
                st.add(1);
            }
        }
        int [] answer = new int [st.size()];
        for(int i = 0; i < st.size(); i++){
            answer[i] = st.get(i);
        }
        return answer;
    }
    public static void main(String[] args){
        int [] progress = new int [] {93, 30, 55};
        int [] speeds = new int [] {1, 30, 5};
        int [] answers = solution(progress, speeds);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
