public class 행렬테두리회전 {
    static int [][] base;
    public static int rotate(int x1, int y1, int x2, int y2){
        int before = base[x1+1][y1];
        int result = Integer.MAX_VALUE;
        for(int y = y1; y <= y2; y++){
            result = Math.min(result, before);
            int temps = base[x1][y];
            base[x1][y]= before;
            before= temps;
        }
        for(int x = x1+1; x <= x2; x++){
            result = Math.min(result, before);
            int temps = base[x][y2];
            base[x][y2] = before;
            before = temps;
        }
        for(int y = y2; y >= y1; y--){
            result = Math.min(result, before);
            int temps = base[x2][y];
            base[x2][y] = before;
            before = temps;
        }
        for(int x = x2-1; x >= x1; x--){
            result = Math.min(result, before);
            int temps = base[x][y1];
            base[x][y1] = before;
            before = temps;
        }
        return result;
    }
    public static int [] solution(int rows, int columns, int [][] quaries){
        base = new int[rows][columns];
        int [] answer = new int[quaries.length];
        for(int x = 0; x < rows; x++){
            for(int y = 0; y < columns; y++){
                base[x][y] = (x) * columns + y+1;
            }
        }
        for(int i = 0 ; i < quaries.length; i++){
            int x1 = quaries[i][0]-1, y1 = quaries[i][1]-1, x2 = quaries[i][2]-1, y2 = quaries[i][3]-1;
            int result = rotate(x1,y1,x2,y2);
            answer[i] = result;
        }

        return answer;
    }
    public static void main(String[] args) {
//        int [] answers = solution(6,6, new int [][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}});
//        for(int answer : answers){
//            System.out.println(answer);
//        }
        int [] answers = solution(3,3,new int [][] {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}});
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
