import java.util.ArrayList;

public class Prime {
    static int isPrime(int N){
        if (N == 2){
            return 1;
        } else if(N % 2 == 0){
            return 2;
        }else {
            ArrayList<Long> primes = new ArrayList<Long>();
            for(long n = 3; n < Math.round(Math.pow(N, 0.5))+1; n+= 2){
                if (N % n == 0){
                    return (int)n;
                }else{
                    boolean flag = false;
                    for(int prime : primes){
                        if (n % prime == 0){
                            flag = true;
                            break;
                        }
                    }
                    if (!flag){
                        primes.add(n);
                    }
                }
            }
        }
        return 1;
    }
    public static void main(String[] args){
//        System.out.println(isPrime(5)); //1
//        System.out.println(isPrime(15)); //3
//        System.out.println(isPrime(21)); //3
//        System.out.println(isPrime(9));
//        System.out.println(isPrime(49));
//        System.out.println(isPrime(10));
        long a = 3;
        System.out.println(a);
    }
}
