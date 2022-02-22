package LV2;

public class 타겟넘버 {
    public static int recursive(int now, int count, int target, int [] numbers){
        if(count == numbers.length){
            if(now == target){
                return 1;
            }else{
                return 0;
            }
        }
        return now + recursive(now+numbers[count], count+1,target, numbers) + recursive(now-numbers[count],count+1, target, numbers);
    }
    public static int solution(int[] numbers, int target){
        int answer = 0;
        answer += (recursive(numbers[0], 1, target, numbers)+recursive(-numbers[0], 1, target, numbers));
        return answer;
    }
    public static void main(String[] args){
        int [] numbers = new int [] {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }
}
