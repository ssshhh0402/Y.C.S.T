package Weekely;

public class EightWeek {
    static int  answer;
    public static void find(int count, int height, int length, int [][] sizes){
        if(count == sizes.length){
            int temps = height * length;
            if(answer > temps){                                                                     //height => 무조건 긴것 length = 무조건 짧은
                answer = temps;
            }
            return;
        }
        find(count+1, Math.max(height, Math.max(sizes[count][0],sizes[count][1])), Math.max(length,Math.min(sizes[count][0], sizes[count][1])),sizes);

    }
    public static int solution(int [][] sizes){
        answer = Integer.MAX_VALUE;
        find(1, Math.max(sizes[0][1],sizes[0][0]), Math.min(sizes[0][1], sizes[0][0]),sizes);
        return answer;
    }
    public static void main(String[] args) {
        int [][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes));
    }
}
