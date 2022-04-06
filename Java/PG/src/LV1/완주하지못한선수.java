package LV1;

import java.util.Arrays;

public class 완주하지못한선수 {
    public static String solution(String [] participant, String [] completion){
        Arrays.sort(participant);
        Arrays.sort(completion);
        String answer = "";
        for(int i = 0 ; i < completion.length; i++){
            String pp = participant[i], cp = completion[i];
            if(!pp.equals(cp)){
                answer = pp;
                break;
            }
        }
        if(answer.equals("")){
            return participant[participant.length-1];
        }else{
            return answer;
        }
    }
    public static void main(String[] args){
        String [] participant = new String [] {"leo", "kiki", "eden"};
        String [] completion = new String [] {"eden", "kiki"};
        System.out.println(solution(participant, completion));
    }
}
