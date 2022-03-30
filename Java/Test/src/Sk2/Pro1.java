package Sk2;

import java.util.ArrayList;
import java.util.Collections;

public class Pro1 {
    public static String [] solution(String[] goods){
        int n = goods.length;
        int minLength;
        String [] answer = new String[goods.length];
        ArrayList<String> result;
        boolean flag;
        for(int i = 0; i < n; i++){
            result = new ArrayList<String>();
            int m = goods[i].length();
            minLength = Integer.MAX_VALUE;
            for(int l = 0; l < m; l++){
                for(int r = l+1; r <= m; r++){
                    flag = false;
                    String now = goods[i].substring(l, r);
                    if(now.length() == m || now.length() > minLength){
                        break;
                    }else{
                        for(int j = 0; j < n; j++){
                            if( i != j){
                                if(goods[j].contains(now) ){
                                   flag = true;
                                   break;
                                }
                            }
                        }
                    }
                    if(!flag){
                        if(now.length() < minLength){
                            minLength = now.length();
                            result.clear();
                            result.add(now);
                        }else if(now.length() == minLength && !result.contains(now)){
                            result.add(now);
                        }
                    }
                }
            }
            if(result.isEmpty()){
                answer[i] = "None";
            }else{
                Collections.sort(result);
                StringBuilder sb = new StringBuilder();
                for(String item : result){
                    if(sb.length() == 0){
                        sb.append(item);
                    }else{
                        sb.append(" ").append(item);
                    }
                }
                answer[i] = sb.toString();
            }
        }
        return answer;
    }
    public static void main(String[] args){
        String [] goods = new String [] {"pencil","cilicon","contrabase","picturelist"};
        String [] answers = solution(goods);
        for(String answer : answers){
            System.out.println(answer);
        }
    }
}
