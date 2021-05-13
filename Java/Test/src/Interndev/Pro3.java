package Interndev;

public class Pro3 {
    static int [][] base;
    public static int find(int a, int b, int p, int r){
        int count = 0;
        int R = r / 2;
        for(int t = 0; t < R; t++){
            int x = a - (R - t - 1);
            if(x >= 0){                                                     //위
                for(int y = b  - t - 1; y < b; y++){                        //좌
                    if(y >= 0){
                        if(y == (b - t - 1)){
                            int temps = base[x][y];
                            int temps2 = p / 2;
                            if(base[x][y] <= p / 2){
                                count += 1;
                            }
                        }else{
                            if(base[x][y] <= p){
                                count += 1;
                            }
                        }
                    }
                }
                for(int y = b; y < b + t + 1; y++){                             //우
                    if(y < base.length){
                        if(y == (b + t)){
                            if(base[x][y] <= p/2){
                                count += 1;
                            }
                        }else{
                            if(base[x][y] <= p){
                                count += 1;
                            }
                        }
                    }
                }
            }
            x = a + (R - t);
            if( x < base.length){                                               //아래
                for(int y = b - t - 1; y < b; y++){                                 //좌
                    if( y >= 0){
                        if(y == (b - t - 1)){
                            if(base[x][y] <= p/2){
                                count += 1;
                            }
                        }else{
                            if(base[x][y] <= p){
                                count += 1;
                            }
                        }
                    }
                }
                for(int y = b; y < b + t + 1; y++){                             //
                    if(y < base.length){
                        if(y == (b + t)){
                            if(base[x][y] <= p/2){
                                count += 1;
                            }
                        }else{
                            if(base[x][y] <= p){
                                count += 1;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    public static int solution(int [][] maps, int p , int r){
        int answer = -1;
        base = maps;
        int result = find(3,3,p,r);
        for(int x = 0; x < maps.length; x++){
            for(int y = 0; y < maps.length; y++){
                int count = find(x, y, p, r);
                answer = Math.max(count, answer);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(new int [][] {{1, 28, 41, 22, 25, 79, 4}, {39, 20, 10, 17, 19, 18, 8}, {21, 4, 13, 12, 9, 29, 19}, {58, 1, 20, 5, 8, 16, 9}, {5, 6, 15, 2, 39, 8, 29},{39, 7, 17, 5, 4, 49, 5}, {74, 46, 8, 11, 25, 2, 11}},19,6));
    }
}
