import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BiggerisGreater {

    public  static String solution(String w){
        if(w.length()<= 1){
            return "no answer";
        }

        String answer = "";
        String [] ws = w.split("");
        int n = ws.length;
        int idx1 = 0, idx2 = 0;
        for(int i = n-2; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(ws[i].compareTo(ws[j]) < 0){
                    idx1 = j;
                    if(answer.equals("") || answer.compareTo(ws[j])>0){
                        answer = ws[j];

                    }
                }
            }
            if(!answer.equals("")){
                idx2 = i;
                String temps = ws[i];
                ws[i] = ws[idx1];
                ws[idx1] = temps;
                break;
            }
        }
        if(!answer.equals("")){
            Arrays.sort(ws,idx2+1, n);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++){
                sb.append(ws[i]);
            }
            return sb.toString();
        }else{
            return "no answer";
        }
    }
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        String [] what = new String[] {"ab","bb","hefg","dhck","dkhc"};
        for(String item : what){
            sb.append(solution(item)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
