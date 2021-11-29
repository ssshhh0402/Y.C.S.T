package Silicon;

public class Pro3 {
    public static long solution(int [] wave1, int[] wave2){
        int min_x1 = Integer.MAX_VALUE, max_x1 = Integer.MIN_VALUE, min_x2 = Integer.MAX_VALUE, max_x2 = Integer.MIN_VALUE;
        for(int i = 0; i < wave1.length; i++){
            min_x1 = (int)Math.min(min_x1, wave1[i]);
            max_x1 = (int)Math.max(max_x1, wave1[i]);
        }
        for(int i = 0; i < wave2.length; i++){
            min_x2 = (int)Math.min(min_x2, wave2[i]);
            max_x2 = (int)Math.max(max_x2, wave2[i]);
        }
        long answer1 = Math.min(Math.abs(min_x1 + min_x2),Math.abs(min_x1 + max_x2));
        long answer2 = Math.min(Math.abs(max_x1 + min_x2),Math.abs(max_x1 + max_x2));
        return Math.min(answer1, answer2);
    }
    public static void main(String [] args){
        int [] wave1 = new int [] {2, 0, 1, 1, 1, 0};
        int [] wave2 = new int [] {0, 0, -1};
        System.out.println(solution(wave1,wave2));
    }
}
