package Socar_Intern_2021_Late;

public class Pro2 {
    static boolean [] used;
    static int n, answer;
    public static int getCount(int [] base, int [] numbers){
        int count = 0;
        for(int i = 0;i  < n; i++){
            if(base[i] != numbers[i]){
                count += 1;
                for(int j = i+1; j < n; j++){
                    if(base[i] == numbers[j]){
                        int temps = base[i];
                        base[i] = numbers[j];
                        base[j] = temps;
                        break;
                    }
                }
            }
        }
        return count;
    }
    public static void getPossible(int idx, int[] base, int [] numbers,int K){
        if(idx == n){
            int count = getCount(base, numbers);
            answer = Math.min(count, answer);
            return;
        }
        for(int i = 0; i < n; i++){
            if(!used[i] && Math.abs(base[idx-1] - numbers[i]) <= K){
                used[i] = true;
                base[idx] = numbers[i];
                getPossible(idx+1, base, numbers, K);
                used[i] = false;
            }
        }
    }
    public static int solution(int [] numbers, int K){
        answer = Integer.MAX_VALUE;
        n = numbers.length;
        used = new boolean [n];
        int [] base = new int[n];
        for(int i = 0; i < n; i++){
            base[0] = numbers[i];
            used[i] = true;
            getPossible(1, base, numbers, K);
            used[i] = false;
        }
        if(answer == Integer.MAX_VALUE){
            return -1;
        }else{
            return answer;
        }
    }
    public static void main(String[] args){
        int [] numbers = new int[]{10, 40, 30, 20};
        int K = 20;
        numbers = new int [] {3, 7, 2, 8, 6, 4, 5, 1};
        K =3;
        System.out.println(solution(numbers, K));
    }
}
