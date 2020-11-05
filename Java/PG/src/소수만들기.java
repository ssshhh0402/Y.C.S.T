public class 소수만들기 {

    public static boolean checking(int a){
        for(int idx = 2; idx < Math.pow((double)a, 0.5)+1; idx++){
            if (a % idx == 0){
                return false;
            }
        }
        return true;
    }
    public static int find(int[] nums, int idx, int count, int sum){
        if (count == 3){
            if(checking(sum)){
                return 1;
            }else{
                return 0;
            }
        }
        int answer = 0;
        for(int i = idx+1; i < nums.length; i++){
            answer += find(nums,i,count+1,sum + nums[i]);
        }
        return answer;
    }
    public static int solution(int[] nums){
        int answer = 0;
        int n = nums.length;
        for(int idx = 0 ; idx < n; idx++){
            answer += find(nums, idx, 1,nums[idx]);
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int [] {1,2,3,4}));
        System.out.println(solution(new int [] {1,2,7,6,4}));
    }
}
