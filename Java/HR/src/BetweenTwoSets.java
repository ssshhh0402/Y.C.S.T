import java.util.ArrayList;
import java.util.List;

public class BetweenTwoSets {
    public static int getGcd(int a, int b){
        if(a % b == 0){
            return b;
        }
        return getGcd(b, a%b);
    }
    public static int solution(List<Integer> a){

        int gcd = a.get(0);
        for(int i = 1; i < a.size(); i++){
            gcd = getGcd(gcd, a.get(i));
        }
        return gcd;
    }
    public static int getLcm(List<Integer> a){
        if(a.size() == 1){
            return a.get(0);
        }
        int gcd = getGcd(a.get(0), a.get(1));
        int lcm = (a.get(0) * a.get(1)) / gcd;
        for(int i = 2; i < a.size(); i++){
            gcd = getGcd(lcm, a.get(i));
            lcm = (lcm*a.get(i)) / gcd;
        }
        return lcm;
    }
    public static int getTotalX(List<Integer> a , List<Integer> b){
        int answer = 0;
        int gcd = solution(b);
        int lcm = getLcm(a);
        int i = 1;
        while(lcm * i <= gcd){
            if(gcd % (lcm*i) == 0){
                answer += 1;
            }
            i+=1;
        }
        return answer;
    }
    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        int [] A = new int [] {2,4};
        int [] B = new int [] {16,32,96};
        for(int item : A){
            a.add(item);
        }
        for(int item : B){
            b.add(item);
        }
        System.out.println(getTotalX(a,b));
    }
}
