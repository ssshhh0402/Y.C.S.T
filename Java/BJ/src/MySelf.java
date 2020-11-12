import java.util.Deque;
import java.util.LinkedList;

public class MySelf {
    static int answer = 0;
    public static void find(int a, int b, boolean [][] used, int [][] base, int count){
        int n = used.length;
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        if((a == n-1) && (b == n-1)){
            if(answer == 0){
                answer=  count;
            }else{
                if (count < answer){
                    answer = count;
                }
            }
        }else{
            for (int i = 0; i < 4; i++){
                int x = a + dx[i];
                int y = b + dy[i];
                if(0 <= x && x < n && 0 <= y && y < n){
                    if(!used[x][y]){
                        used[x][y] = true;
                        find(x,y,used,base,count+1);
                        used[x][y] = false;
                    }
                }
            }
        }
    }
    public static int shortest(int n){
        boolean [][] used = new boolean[n][n];
        int [][] base = new int[n][n];
        find(0,0,used,base,1);
        return answer;
    }
    public static int rec(int a){
        if (a == 1){
            return 1;
        }else{
            return a * rec(a-1);
        }
    }
    public static int dp(int a){
        int [] base = new int[a+1];
        for(int idx = 1; idx < a+1; idx++){
            if (idx == 1 || idx == 2){
                base[idx] = 1;
            }else{
                base[idx] = base[idx-1] + base[idx-2];
            }
        }
        return base[a];
    }
    public static String asci(String someString){
        char[] arr = someString.toCharArray(); // 해당 문자열로부터 캐릭터 배열을 선언한다
        StringBuffer sb = new StringBuffer();
        int size = 0;
        for(char c : arr) {
            size += (c > 255) ? 2 : 1; // 조건에 따라 2 또는 1을 증가시킨다
            sb.append(c);
            if(size >= 80) {
                break;
            }
        }
        return sb.toString();
    }

    public static int GCD(int a, int b){
        if (b == 0){
            return a;
        }else{
            return GCD(b, a%b);
        }
    }
    public static int LSD(int a, int b){
        return a * b / (GCD(a, b));
    }
    public static void main(String [] args){
//        System.out.println(dp(10));
//        System.out.println(rec(10));
//        System.out.println(shortest(5));
        //System.out.println(asci("Hh!zZ="));
        System.out.println(GCD(6,1));
        System.out.println(GCD(5,10));
        System.out.println(LSD(5,10));
        System.out.println("1" == "1.0");

        System.out.println("1".equals("1.0"));

    }
}
