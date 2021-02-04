import java.util.Arrays;

public class K번째수 {
    public static int[] solution(int [] array, int [][] commands){
        int [] answer = new int[commands.length];
        int i = 0;
        for( int [] command : commands){
            int start = command[0]-1, end = command[1], target=command[2];
            int [] temps = Arrays.copyOfRange(array, start, end);
            Arrays.sort(temps);
            answer[i] = temps[target-1];
            i+=1;
        }
        return answer;
    }
    public static void main(String[] args) {
        int [] answer = solution(new int [] {1,5,2,6,3,7,4},new int [][] {{2,5,3},{4,4,1},{1,7,3}});
        for( int i : answer){
            System.out.println(String.valueOf(i));
        }
    }
}
