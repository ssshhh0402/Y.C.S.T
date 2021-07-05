package Kakao_M;

public class Pro2 {
    public static int solution(int [] T, int [] A){
        int answer = 0;
        boolean [] learned = new boolean[T.length];
        int now, time;
        for(int a : A){
            if(!learned[a]){
                learned[a] = true;
                now = a;
                time = 1;
                while(true){
                    if(now == 0) {
                        answer += time;
                        learned[now] = true;
                        break;
                    }
                    if(!learned[T[now]]){
                        learned[T[now]] = true;
                        now = T[now];
                        time += 1;
                    }else{
                        answer += time;
                        break;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [] T = new int []{0,0,1,1};
        int [] A = new int [] {2};
        System.out.println(solution(T,A));
        T = new int [] {0,0,0,0,2,3,3};
        A = new int [] {2,5,6};
        System.out.println(solution(T,A));
        T = new int [] {0,0,1,2};
        A = new int [] {1,2};
        System.out.println(solution(T,A));
        T = new int [] {0,3,0,0,5,0,5};
        A = new int [] {4,2,6,1,0};
        System.out.println(solution(T,A));
    }
}
