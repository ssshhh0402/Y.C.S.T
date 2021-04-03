package Devmat_Back;

public class Pro2 {
    static int [][] base ;
    public static void init(int rows, int columns){
        int count = 1;
        for(int x = 1; x < rows+1; x++){
            for(int y = 1; y < columns+1; y++){
                base[x][y] = count ++;
            }
        }
    }
    public static int rotate(int x1, int y1, int x2, int y2){
        //4번에 나눠서 하자
        // 맨위
        // 맨 오른쪽
        // 맨밑
        // 맨 왼쪽

        int min = Integer.MAX_VALUE, temps = Integer.MAX_VALUE;
        int height = x2 - x1;
        int width = y2 - y1;
        for(int y = y1; y < y1 + width; y++){
            int calc = base[x1][y];
            base[x1][y] = temps;
            temps = calc;
            min = Math.min(temps, min);
        }
        for(int x = x1; x < x1 + height; x++){
            int calc = base[x][y2];
            base[x][y2] = temps;
            temps = calc;
            min = Math.min(temps, min);
        }
        for(int y = y2; y > y2 - width; y--){
            int calc = base[x2][y];
            base[x2][y] = temps;
            temps = calc;
            min = Math.min(temps, min);
        }
        for(int x = x2; x >= x2 - height; x--){
            int calc = base[x][y1];
            base[x][y1] = temps;
            temps = calc;
            min = Math.min(temps, min);
        }
        return min;
    }
    public static int [] solution(int rows, int columns, int [][] queries){
        int [] answer = new int[queries.length];
        base = new int[rows+1][columns+1];
        init(rows, columns);
        for(int i = 0 ; i < queries.length; i++) {
            int[] querie = queries[i];
            int x1= querie[0], y1 = querie[1], x2 = querie[2], y2 = querie[3];
            int count = rotate(x1,y1,x2,y2);
            answer[i] = count;
        }
        return answer;
    }
    public static void main(String[] args){
        int [] answers = solution(6,6, new int [][] {{2,2,5,4},{3,3,6,6},{5,1,6,3}});
        for(int answer : answers){
            System.out.println(answer);
        }
        answers = solution(3,3,new int [][] {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}});
        for(int answer : answers){
            System.out.println(answer);
        }
        answers = solution(100, 97,new int [][] {{1,1,100,97}});
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
