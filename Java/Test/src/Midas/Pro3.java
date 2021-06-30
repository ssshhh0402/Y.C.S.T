package Midas;

public class Pro3 {
    public static int solution(int N, int K, int [][] T){
        int answer = 0;
        int [] days = new int[K+1];
        int left = 0, right = K;
        for(int [] day : T){
            int start = day[0];
            int end = day[1];
            for(int i = start; i < end+1; i++){
                days[i] += 1;
            }
            if(left < start){
                left = start;
            }
            if(right < end){
                right = end;
            }
        }
        int count = 0;
        for(int i = left; i < right+1; i++){
            if(days[i] == N){
                answer= days[i];
                break;
            }else{
                if(days[i] > answer){
                    answer = days[i];
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(4,4,new int [][] {{1,3},{1,1},{2,3},{3,4}}));
    }
}
