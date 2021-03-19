public class 멀쩡한사각형2 {
    public static long solution(int w, int h){
        long answer = 0;
        double grad = (double)w/(double)h;
        for(int x = 0; x < h; x++){
            if((int)(grad * (x+1)) > (int)(grad * (x))){
                if((grad*(x+1)) % 1 == 0){
                    answer += 1;
                }else{
                    answer += 2;
                }
            }else{
                answer += 1;
            }
        }
        return (w * h) - answer;
    }
    public static void main(String[] args){
        System.out.println(solution(8,12));
    }
}
