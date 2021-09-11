package KakaoLate;

public class Pro2 {
    static String prime;
    public static String getPrime(int n, int k){
        StringBuilder sb = new StringBuilder();
        while(n / k != 0){
            sb.append(n % k);
            n /= k;
        }
        sb.append(n);
        return sb.reverse().toString();
    }

    public static boolean isPrime(int start, int end){
        if(start - 1 >= 0 && prime.charAt(start-1) == '0' && end < prime.length()-1 && prime.charAt(end+1) == '0'){       //양쪽 0
            return true;
        }else if(start == 0 && end < prime.length()-1 && prime.charAt(end+1) == '0'){                                     // 오른쪽 0
            return true;
        }else if(end == prime.length()-1 && start-1 >= 0 && prime.charAt(start-1) == '0'){                            //왼쪽 0
            return true;
        }else if(start == 0 && end == prime.length()-1){                                                        //양쪽 아무것도 없음
            return true;
        }
        return false;
    }
    public static boolean isPossible(String item){
        long target = Long.parseLong(item);
        if(target < 2){
            return false;
        }else if(target == 2){
            return true;
        }else{
            for(int i = 2; i < Math.sqrt(target)+1; i++){
                if(target % i == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public static int solution(int n, int k){
        prime = getPrime(n,k);
        String target = "";
        int start = -1;
        int answer = 0;
        for(int i = 0 ; i < prime.length(); i++){
            if(prime.charAt(i) != '0'){
                target += prime.charAt(i);
                if(start == -1){
                    start = i;
                }
            }else{
                if(!target.equals("")){
                    if(isPossible(target) && isPrime(start, i-1)){
                        answer += 1;
                    }
                    target = "";
                    start = -1;
                }
            }
        }
        if(!target.equals("")){
            if(isPossible(target) && isPrime(start, prime.length()-1)){
                answer += 1;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int n = 437674;
        int k = 3;
//        System.out.println(solution(n,k));
        n = 110011;
        k = 10;
        System.out.println(solution(n,k));
    }
}
