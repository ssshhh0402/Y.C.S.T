package Devmat_Back_Late_Real;

public class Pro1 {
    static int n, answer;
    public static void recursive(int x, int y, int count, String[] drum, int start){
        if(x == n){
            answer += 1;
            return;
        }
        char now = drum[x].charAt(y);
        if(now == '#'){
            recursive(x+1, y, count, drum, start);
        }else if(now == '<'){
            recursive(x, y-1, count, drum, start);
        }else if(now == '>'){
            recursive(x, y+1, count, drum, start);
        }else{
            if(count == 0){
                recursive(x+1, y, count+1, drum, start);
            }
        }
    }
    public static int solution(String [] drum){
        n = drum.length;
        answer = 0;
        for(int i = 0; i < n; i++){
            recursive(0,i,0,drum, i);
        }
        return answer;
    }
    public static void main(String[] args){
        String[] drum = new String [] {"######",">#*###","####*#","#<#>>#",">#*#*<","######"};
        System.out.println(solution(drum));
    }
}
