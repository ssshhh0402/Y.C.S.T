package Devmat_Back;

import java.util.Arrays;

public class Pro1 {
    public static int [] find(int [] lottos, int [] win_nums){
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int count = 0;
        int z_count = 0;
        for(int i = 0; i < lottos.length; i++){
            int target = lottos[i];
            if(target == 0){
                z_count += 1;
                continue;
            }else{
                boolean flag = false;
                for(int j = 0; j < win_nums.length; j++){
                    if(win_nums[j] == 0){
                        continue;
                    }else{
                        if(win_nums[j] > target){
                            break;
                        }else if(win_nums[j] == target){
                            flag = true;
                            break;
                        }
                    }
                }
                if(flag){
                    count += 1;
                }
            }
        }
        return new int [] {count,z_count};
    }
    public static int [] solution(int [] lottos, int [] win_nums){
        int [] answer =new int[2];
        int [] counting = new int[7];
        for(int i = 0; i < 7; i++){
            if(i == 0 || i == 1){
                counting[i] = 6;
            }else{
                counting[i] = 7 - i;
            }
        }
        int[] count = find(lottos, win_nums);
        answer[0] = counting[count[0] + count[1]];
        answer[1] = counting[count[0]];
        return answer;
    }
    public static void main(String[] args){
        int [] answers = solution(new int [] {44,1,0,0,31,25},new int [] {31,10,45,1,6,9});
        for(int answer : answers){
            System.out.println(answer);
        }
        answers = solution(new int [] {0,0,0,0,0,0}, new int [] {38,19,20,40,15,25});
        for(int answer : answers){
            System.out.println(answer);
        }
        answers = solution(new int [] {45, 4, 35, 20, 3, 9}, new int [] {20, 9, 3, 45, 4, 35});
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
