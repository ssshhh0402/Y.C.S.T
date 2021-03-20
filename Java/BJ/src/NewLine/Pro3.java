package NewLine;

import java.util.Arrays;

public class Pro3 {
    public static int find(int target, int [] people){
        int answer = 0;
        for(int i = 0 ; i < people.length; i++){
            if(people[i] == target){
                answer = i;
                break;
            }
        }
        return answer;
    }
    public static int [] solution(int[] enters, int[] outs){
        int n = enters.length;
        int [] answer = new int[enters.length];
        for(int i = 1; i < n+1; i++){
            int enter = find(i, enters);
            int out = find(i, outs);
            int[] ent = Arrays.copyOfRange(enters, 0,enter);

        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(new int [] {1,3,2}, new int [] {1,2,3}));
    }
}
