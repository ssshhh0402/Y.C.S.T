package Socar_2021_Late;

public class Pro2 {
    static int answer;
    static int n;
    public static void recursive(int count, int idx, int [] numbers, int k){
        if(idx == n){
            answer = Math.min(answer, count);
            return;
        }
        for(int i = idx; i < n-1; i++){
            if(Math.abs(numbers[i] - numbers[i+1]) > k){
                for(int j = i+2; j < n; j++){
                    if(Math.abs(numbers[i] - numbers[j]) > k){
                        int temps = numbers[i+1];
                        numbers[i+1] = numbers[j];
                        numbers[j] = temps;
                        recursive(count+1, i+1, numbers, k);
                        numbers[j] = numbers[i+1];
                        numbers[i+1] = temps;
                    }
                }
            }
        }
    }
    public static int solution(int [] numbers, int k) {
        answer = Integer.MAX_VALUE;
        n = numbers.length;
        recursive(0, 0,numbers, k);

        if(answer == Integer.MAX_VALUE){
            return -1;
        }else{
            return answer;
        }
    }
    public static void main(String[] args){
        int [] numbers = new int [] {10,40,30,20};
        int k = 20;
        System.out.println(solution(numbers, k));
    }
}
