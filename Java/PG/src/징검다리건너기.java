public class 징검다리건너기 {
    public static int cnt(int[] stones, long mid){
        int count = 0;
        for(int stone : stones){
            if(stone - mid <= 0){
                count += 1;
            }else{
                count = 0;
            }
            if(count > mid){
                return count;
            }
        }
        return count;
    }
    public static int solution(int[] stones, int k){
        int answer = 0;
        long start = 0;
        long end = Integer.MAX_VALUE;
        long mid;
        while (start <= end){
            mid = (start + end) / 2;
            int count = cnt(stones, mid);
            if(count < k){
                answer = ((int)mid);
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int [] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1},3));
    }
}
