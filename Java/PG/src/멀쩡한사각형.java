public class 멀쩡한사각형 {
    public static long solution(int w, int h){
        long answer = 0;
        for(int x = 0; x < w; x++){
            answer += (h * x / w );
        }
        return answer * 2;
    }
    public static void main(String[] args){
        System.out.println(solution(8, 12));
    }
}
