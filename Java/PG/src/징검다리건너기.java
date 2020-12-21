public class 징검다리건너기 {
    public static int solution(int[] stones, int k){
        int answer = 0;
        long start = 0;
        long end = Integer.MAX_VALUE;
        long mid;
        int count;
        boolean flag;
        while (start <= end){
            mid = (start + end) / 2;
            count = 0;
            flag = true;
            for(int stone : stones){
                if(stone - (mid-1) <= 0){
                    count += 1;
                }else{
                    count = 0;
                }
                if( count >= k){
                    flag = false;
                    break;
                }
            }
            if (flag){
                answer = (int)mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int [] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1},3));
        System.out.println(Integer.MAX_VALUE - 200000001);
    }
}
