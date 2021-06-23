package DeliveryHero;

import java.io.IOException;

public class Pro3 {
    public static String solution(int U, int L, int [] C) {
        int N = C.length;
        boolean flag = true;
        int[][] base = new int[2][N];
        int [] temps = new int [] {U, L};
        for(int x = 0; x < 2; x++){
            if(!flag){
                break;
            }
            for(int y = 0; y < N; y++){
                if(C[y] == 2){
                    if(temps[x] != 0){
                        C[y]-=1;
                        base[x][y] = 1;
                        temps[x] -= 1;
                    }else{
                        flag = false;
                        break;
                    }
                }else if(C[y] == 1){
                    if(temps[x] != 0){
                        C[y]-=1;
                        base[x][y] = 1;
                        temps[x] -= 1;
                    }
                }
            }
        }
        for(int temp : temps){
            if(temp != 0){
                flag = false;
                break;
            }
        }
        if(!flag){
            return "IMPPOSIBLE";
        }else{
            StringBuilder sb = new StringBuilder();
            for(int x = 0 ; x < 2; x++){
                for(int y = 0; y < N; y++){
                    sb.append(base[x][y]).append(" ");
                }
                sb.append("\n");
            }
            return (sb.toString());
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println(solution(3, 2, new int [] {2, 1, 1, 0, 1}));
        //{1,1,0,0,1,
        // 1,0,1,0,0}

    }
}
