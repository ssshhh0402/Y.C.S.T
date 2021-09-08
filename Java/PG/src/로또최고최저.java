import java.util.Arrays;

public class 로또최고최저 {
    public static int [] solution(int [] lottos, int [] win_nums){
        int [] answer = new int[2];
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int count = 0;
        int zero = 0;
        for(int lotto : lottos){
            if (lotto == 0){
                zero += 1;
            }else{
                for(int i = 0 ; i < win_nums.length;i++){
                    if(win_nums[i] == lotto){
                        count += 1;
                        break;
                    }else if(win_nums[i] > lotto){
                        break;
                    }
                }
            }
        }
        if(count + zero < 2){
            answer[0] = 6;
        }else {
            answer[0] = 7 - (count + zero);
        }
        if(count < 2){
            answer[1] = 6;
        }else{
            answer[1] = 7 - count;
        }
        return answer;
    }
    public static void main(String[] args){
        int [] lottos = {44, 1, 0, 0, 31, 25};
        int [] win_nums = {31, 10, 45, 1, 6, 19};
//        int [] answers = solution(lottos, win_nums);
//        for(int answer : answers){
//            System.out.println(answer);
//        }
//        lottos = new int [] {0, 0, 0, 0, 0, 0};
//        win_nums = new int [] {38, 19, 20, 40, 15, 25};
//        answers = solution(lottos, win_nums);
//        for(int answer : answers){
//            System.out.println(answer);
//        }
//        lottos = new int [] {45, 4, 35, 20, 3, 9};
//        win_nums = new int [] {20, 9, 3, 45, 4, 35};
//        answers = solution(lottos, win_nums);
//        for(int answer : answers){
//            System.out.println(answer);
//        }
        lottos = new int [] {1,2,3,4,5,6};
        win_nums = new int [] {7,8,9,10,11,12};
        int [] answers = solution(lottos, win_nums);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
