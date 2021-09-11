package KakaoLate;

import java.util.Arrays;

public class Pro4 {
    static int [] score, answer_score;
    static int answer, target;

    public static void find(int idx, int count, int[] info){
        if(count == 0){
            int Appeach = 0;
            int Rion = 0;
            for(int i = 0 ; i < info.length; i++){
                if(score[i] > info[i]){
                    Rion += (10 - i);
                }else{
                    if(info[i] != 0) {
                        Appeach += (10 - i);
                    }
                }
            }
            if(Rion > Appeach){
                int result = Rion - Appeach;
                if(result > answer){
                    answer = result;
                    for(int i = 0 ; i < score.length; i++){
                        answer_score[i] = score[i];
                    }
                }else if(result == answer){
                    for(int i = score.length-1; i >= 0; i--){
                        if(answer_score[i] < score[i]){
                            answer_score = Arrays.copyOf(score, score.length);
                            break;
                        }else if(answer_score[i] > score[i]){
                            break;
                        }
                    }
                }
                return;
            }
        }
        for(int i = idx; i < score.length; i++){
            if(info[i] + 1 <= count){
                score[i] += (info[i] + 1);
                find(i+1, count - score[i], info);
                score[i] -= (info[i] + 1);
            }else{
                score[i] += count;
                find(i+1, 0, info);
                score[i] -= count;
            }
        }
    }
    public static int [] solution(int n, int [] info){
        score = new int [info.length];
        answer = Integer.MIN_VALUE;
        answer_score = new int [info.length];
        find(0,n, info);
        if(answer == Integer.MIN_VALUE){
            answer_score = new int[1];
            answer_score[0] = -1;
        }
        return answer_score;
    }
    public static void main(String[] args){
        int n = 5;
        int [] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
//        int [] answers = solution(n, info);
//        for(int answer : answers){
//            System.out.println(answer);
//        }
        n = 10;
        info = new int [] {0,0,0,0,0,0,0,0,3,4,3};
        int [] answers = solution(n, info);
        for(int answer : answers){
            System.out.println(answer);
        }

    }
}
