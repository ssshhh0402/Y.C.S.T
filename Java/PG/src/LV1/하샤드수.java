package LV1;

public class 하샤드수 {
    public static int hashard(int x){
        int result = 0;
        int n, m;
        while(true){
            m = x / 10;
            n = x % 10;
            result += n;
            if(m == 0){
                break;
            }else{
                x = m;
            }
        }
        return result;
    }
    public static boolean solution(int x){
        int result = hashard(x);
        if(x % result == 0){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        int arr = 10;
        System.out.println(solution(arr));
        arr = 12;
        System.out.println(solution(arr));
        arr = 11;
        System.out.println(solution(arr));
        arr = 13;
    }
}
