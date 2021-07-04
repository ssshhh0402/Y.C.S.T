
public class Lesson5_2 {
    public static int [] solution(String S, int [] P, int [] Q){
        int [] answer = new int[P.length];
        int [] A = new int[S.length()+1];
        int [] C = new int[S.length()+1];
        int [] G = new int[S.length()+1];
        for(int i = 0; i < S.length(); i++){
            char now = S.charAt(i);
            if(now == 'A'){
                A[i+1] += 1;
            }else if(now == 'C'){
                C[i+1] += 1;
            }else if(now == 'G'){
                G[i+1] += 1;
            }
            A[i+1] += A[i];
            C[i+1] += C[i];
            G[i+1] += G[i];
        }
        for(int i = 0 ; i < P.length; i++){
            int start = P[i], end = Q[i]+1;
            if(A[start] != A[end]){
                answer[i] = 1;
            }else if(C[start] != C[end]){
                answer[i] = 2;
            }else if(G[start] != G[end]){
                answer[i] = 3;
            }else{
                answer[i] = 4;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        String s = "CAGCCTA";
        int [] P = new int [] {2,5,0};
        int [] Q = new int [] {4,5,6};
        int [] answers = solution(s,P,Q);
//        for(int answer : answers){
//            System.out.print(answer + " ");
//        }
//        System.out.println("");
        s = "A";
        P = new int[] {0};
        Q = new int[]{0};
        answers = solution(s,P,Q);
        for(int answer : answers){
            System.out.print(answer + " ");
        }
    }
}
