public class 행렬곱셈 {
    public static int [][] solution(int[][] arr1, int [][] arr2){
        int n = arr1.length, m = arr1[0].length;
        int [][] answer = new int[n][m];
        int temps;
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m;j++){
                temps = 0;
                for(int q = 0; q < arr1[i].length; q++){
                    temps += (arr1[i][q] * arr2[q][j]);
                }
                answer[i][j] = temps;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int [][] arr1 = new int [][] {{1,4},{3,2},{4,1}};
        int [][] arr2 = new int [][] {{3,3},{3,3}};
//        int [][] arr1 = new int [][] {{2,3,2},{4,2,4},{3,1,4}};
//        int [][] arr2 = new int [][] {{5,4,3},{2,4,1},{3,1,1}};
//        int [][] arr2 = new int [][] {{5,4},{2,4},{3,1}};
        int [][] answers = solution(arr1, arr2);
        for(int [] answer : answers){
            for(int item : answer){
                System.out.println(item);
            }
            System.out.println("");
        }
    }
}
