package NaverWebtoon;

public class Pro3 {
    static int [][] answers;
    static int [] options;
    static int value;
    public static void print(int a, int b, int count, int len){
        int N = len / options[count];
        if(count == 0){
            for(int y = b; y < b+N+1; y++){
                answers[a][y] = value;
                value += 1;
            }
            for(int x = a+1; x < a+len; x++){
                answers[x][b+len-1] = value;
                value += 1;
            }
            for(int y = b+len-2; y >= b; y--){
                answers[a+len-1][y] = value;
                value += 1;
            }
            for(int x = a+len-2; x > a; x--){
                answers[x][b] = value;
                value += 1;
            }

        }else{
//            for(int x = a; x < a+len; x+=N){
//                for(int y = b; y < b+len; y += N){
//                    print(x, y, count-1, N);
//
//                }
//            }
            for(int y = a; y < b+len; y+=N){
                print(a, y, count-1, N);
            }
            for(int x = b+N; x < a+len; x+=N){
                print(x,b+N-1, count-1, N);
            }
            for(int y = b+len-(2*N); y >= b; y-=N){
                print(a+N-1, y, count-1, N);
            }
            for(int x = a+len-(2*N); x > a; x+=N){
                print(x, b, count-1, N);
            }
        }
    }
    public static int [][] solution(int [] length){
        int n = 1;
        value = 1;
        options = length;
        for(int item : length){
            n *= item;
        }
        answers = new int [n][n];
        print(0,0, options.length-1, n);
        return answers;
    }
    public static void main(String[] args){
        int [] length = new int [] {2,2};
        int [][] answers = solution(length);
        for(int x = 0 ; x < answers.length; x++){
            for(int y = 0; y < answers[x].length; y++){
                System.out.print(answers[x][y] + " ") ;
            }
            System.out.println("");
        }
    }
}
