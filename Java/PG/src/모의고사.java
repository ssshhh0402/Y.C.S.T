import java.util.ArrayList;

public class 모의고사 {
    public static void main(String[] args){
        int[] a = solution(new int []{1,2,3,4,5});
        int[] b = solution(new int []{1,3,2,4,2});
        System.out.println(a);
        System.out.println(b);
    }
    public static int[] solution(int[] answers){
        int[] answer = {};
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int[] person_a = {1,2,3,4,5};
        int[] person_b = {2,1,2,3,2,4,2,5};
        int[] person_c = {3,3,1,1,2,2,4,4,5,5};
        int[] counts = {0,0,0};
        for(int idx=0; idx < answers.length; idx++){
            int temps = answers[idx];
            int idx_a = idx % 5;
            int idx_b = idx % 8;
            int idx_c = idx % 10;
            int answer_a = person_a[idx_a];
            int answer_b = person_b[idx_b];
            int answer_c = person_c[idx_c];
            if (answer_a == temps){
                counts[0] += 1;
            }
            if (answer_b == temps){
                counts[1] += 1;
            }
            if (answer_c == temps){
                counts[2] += 1;
            }
        }
        int max_score = 0;
        for(int idx =0; idx < 2; idx++){
            int a = Math.max(counts[idx],counts[idx+1]);
            if (a > max_score){
                max_score = a;
            }
        }
        for(int idx=0; idx < 3; idx++){
            if (counts[idx] == max_score){
                temp.add(idx+1);
            }
        }
        int n = temp.size();
        answer = new int[n];
        for(int idx = 0; idx < n; idx++){
            answer[idx] = temp.get(idx);
        }
        return answer;
    }
}
