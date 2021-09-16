package NaverWebtoon;

public class Pro3 {
    static int [][] answers;
    static int [] options;
    static int value;
    public static void print(int a, int b, int count, int len){
        int N = len / options[count];
        if(count == 0){
            int target = value + len * len;
            int flag = 0;
            while(value < target){
                for(int y = b+flag; y < b+len-flag; y++){
                    answers[a+flag][y] = value++;
                }
                for(int x = a+flag+1; x < a+len-flag; x++){
                    answers[x][b+len-flag-1] = value++;
                }
                for(int y = b+len-flag-2; y > b+flag-1; y--) {
                    answers[a + len - flag-1][y] = value++;
                }
                for(int x = a + len - flag-2; x > a+flag; x--){
                    answers[x][b+flag] = value++;
                }
                flag += 1;
            }
        }else{
            // 위, 오른, 아래 반복
            int target = value + (len * len);
            int flag = 0;
            while(value < target){
                System.out.print("NOW :" + flag);
                for(int y = b+flag; y < b+len; y +=N){
                    print(a, y, count-1, N);
                }
                for(int x = a + N - flag; x < a + len; x += N){
                    print(x, b+N-flag, count-1, N);
                }
                for(int y = b+len-(2*N) - flag; y >= b; y-=N){
                    print(a+N-flag, y, count-1, N);
                }
                flag += 1;
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
//        int [][] answers = solution(length);
//        for(int x = 0 ; x < answers.length; x++){
//            for(int y = 0; y < answers[x].length; y++){
//                System.out.print(answers[x][y] + " ") ;
//            }
//            System.out.println("");
//        }
//        length = new int [] {3,2};
//        int [][] answers = solution(length);
//        for(int x = 0 ; x < answers.length; x++){
//            for(int y = 0; y < answers[x].length; y++){
//                System.out.print(answers[x][y] + " ");
//            }
//            System.out.println("");
//        }
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        length = new int [] {4,3,2};
        answers = solution(length);
        for(int x = 0 ; x  <answers.length; x++){
            for(int y = 0 ; y < answers[x].length; y++){
                System.out.print(answers[x][y] + " ");
            }
            System.out.println("");
        }
    }
}
