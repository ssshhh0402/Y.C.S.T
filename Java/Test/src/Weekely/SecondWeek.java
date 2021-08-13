package Weekely;

public class SecondWeek {
    public static String convert(double score){
        if(score >= 90){
            return "A";
        }else if(score >= 80){
            return "B";
        }else if(score >= 70){
            return "C";
        }else if(score >= 50){
            return "D";
        }else{
            return "F";
        }
    }
    public static String solution(int [][] scores){
        String answer = "";
        for(int j = 0; j < scores.length;j++){
            int count = 0;
            int min_score = 100;
            int max_score = 0;
            for(int i = 0; i < scores.length; i++){
                if(i == j){
                    continue;
                }
                if(scores[i][j] < min_score){
                    min_score = scores[i][j];
                }else if(scores[i][j] > max_score){
                    max_score = scores[i][j];
                }
                count += scores[i][j];
            }
            double score;
            if(scores[j][j] >= min_score && scores[j][j] <= max_score){
                score = (double)((count + scores[j][j]) / scores.length);
            }else{
                score = (double)(count = count / (scores.length-1));
            }
            answer += convert(score);
        }
        return answer;
    }
    public static void main(String[] args){
        int [][] scores = new int [][] {{50,90},{50,87}};
//        System.out.println(solution(scores));
        scores = new int [][] {{75,50,100}, {75,100,20},{100,100,20}};
        System.out.println(solution(scores));
    }
}
