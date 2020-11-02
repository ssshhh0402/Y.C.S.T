import java.util.ArrayList;
import java.util.List;

public class Pro3 {
    public static void solution(int numOfOrder, String[] orderArr){
        for (int idx = 0; idx < numOfOrder; idx++){
            String target = orderArr[idx];
            ArrayList temps = new ArrayList<>();
            ArrayList answers = new ArrayList<>();
            StringBuffer sb = new StringBuffer();
            int N = target.length();
            boolean flag = false;
            char last = ' ';
            for(int i = N-1; i >= 0; i--){
                char now = target.charAt(i);
                if (!Character.isDigit(now)){
                    if (now == ')'){
                        flag = true;
                        continue;
                    } else if (now == '('){
                        last = now;
                        continue;
                    } else {
                        if (last != '('){
                            answers.add(now);
                        }else{
                            ArrayList al2 = new ArrayList<>();
                            for(Object item : temps){
                                al2.add((Character)item);
                                al2.add(now);
                            }
                            temps = al2;
                        }
                    }
                }else{
                    if(last != '('){
                        for(int Idx = 0; Idx < now - '0' -1; Idx++){
                            answers.add(last);
                        }
                    }else{
                        int M = temps.size();
                        for(int Idx= 0; Idx < now - '0'-1;Idx ++){
                            for(int Idx2 = 0; Idx2 < M; Idx2++){
                                temps.add(temps.get(Idx2));
                            }
                        }
                    }
                }
                last = now;
            }
            for (Object obj : temps){
                sb.append((Character) obj);
            }
            System.out.println(sb.reverse());
        }

    }
    public static void main(String[] args){
        //solution(2, new String[] {"B2(RG)", "3(R2(GB))"});
        //solution(3, new String [] {"3(BR2(R))","B(RGB(RG))","1B2R3G"});
        solution(1, new String[] {"A2(A)B"});
    }
}
