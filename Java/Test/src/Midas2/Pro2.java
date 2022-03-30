package Midas2;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Pro2 {
    static int [] dx = new int [] {0,1,0,-1};
    static int [] dy = new int [] {1,0,-1,0};
    public static boolean isDuplicated(int [] L1, int [] L2){
        int l1x1 = Math.min(L1[0], L1[2]), l1y1 = Math.min(L1[1], L1[3]), l1x2 = Math.max(L1[0], L1[2]), l1y2 = Math.max(L1[1], L1[3]);
        int l2x1 = Math.min(L2[0], L2[2]), l2y1 = Math.min(L2[1], L2[3]), l2x2 = Math.max(L2[0], L2[2]), l2y2 = Math.max(L2[1], L2[3]);
        if(l1x1 >= l2x1 && l1x1 <= l2x2){
            if(l1y1 >= l2y1 && l1y1 <= l2y2){
                return true;
            }
        }else if(l1x2 >= l2x1 && l1x2 >= l2x2){
            if(l1y2 >= l2y1 && l1y2 <= l2y2){
                return true;
            }
        }
        return false;
    }
    public static int getMinimum(int [] L1, int [] L2, int dir){
        int l1x1 = Math.min(L1[0], L1[2]), l1y1 = Math.min(L1[1], L1[3]), l1x2 = Math.max(L1[0], L1[2]), l1y2 = Math.max(L1[1], L1[3]);
        int l2x1 = Math.min(L2[0], L2[2]), l2y1 = Math.min(L2[1], L2[3]), l2x2 = Math.max(L2[0], L2[2]), l2y2 = Math.max(L2[1], L2[3]);
        int result;
        if(dir == 0){
            result = Math.min(Math.abs(l1x1 - l2x2)+1, Math.abs(l1x2 - l2x2)+1);
        }else if(dir == 1){
            result = Math.min(Math.abs(l2y2 - l1y1)+1, Math.abs(l2y2 - l1y2)+1);
        }else if(dir == 2){
            result = Math.min(Math.abs(l1x2 - l2x1)+1, Math.abs(l1x1 - l2x2)+1);
        }else{
            result = Math.min(Math.abs(l2x1 - l1x2)+1, Math.abs(l1x2 - l2x1)+1);
        }
        return result;
    }
    public static int recursive(int now, int [][] L, int N){
        if(now > 20){
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < N; i ++){
            for(int j = i+1; j < N; j++){
                if(isDuplicated(L[i], L[j])){
                    int count = Integer.MAX_VALUE;
                    for(int q = 0; q < 2; q++){
                        if(q == 0){
                            for(int m = 0; m < 4; m++){
                                L[i][0]+=dx[m]; L[i][1] += dy[m]; L[i][2] += dx[m]; L[i][3] += dy[m];
                                if(0 <= L[i][0] && L[i][0] < 32767 && 0 <= L[i][1] && L[i][1] < 32767 && 0 <= L[i][2] && L[i][2] < 32767 && 0 <= L[i][3] && L[i][3] < 32767){
                                    int result = recursive(now+1, L, N);
                                    if(result != -1){
                                        count = Math.min(count, result);
                                    }
                                }
                                L[i][0] -= dx[m]; L[i][1] -= dy[m]; L[i][2] -= dx[m]; L[i][3] -= dy[m];
                            }
                        }else{
                            for(int m = 0; m < 4; m++){
                                L[j][0] += dx[i]; L[j][1] += dy[i]; L[j][2] += dx[i]; L[j][3] += dy[i];
                                if(0 <= L[j][0] && L[j][0] < 32767 && 0 <= L[j][1] && L[j][1] < 32767 && 0 <= L[j][2] && L[j][2] < 32767 && 0 <= L[j][3] && L[j][3] < 32767){
                                    int result = recursive(now+1, L, N);
                                    if(result != -1){
                                        count = Math.min(count, result);
                                    }
                                }
                                L[j][0] -= dx[m]; L[j][1] -= dy[m]; L[j][2] -= dx[m]; L[j][3] -= dy[m];
                            }
                        }
                    }
                    answer = Math.min(count, answer);
                }
            }
        }
        if(answer == Integer.MAX_VALUE){
            return now;
        }else{
            return answer;
        }
    }
    public static int getSolution(int N, int [][] L){
        int [] dx = new int[] {-1,0,1,0};
        int [] dy = new int [] {0,-1,0,1};

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if(isDuplicated(L[i], L[j])){
                    int count = Integer.MAX_VALUE;
                    for(int q = 0; q < 2; q++){
                        if(q == 0){
                            for(int m = 0; m < 4; m++){
                                L[i][0]+=dx[m]; L[i][1] += dy[m]; L[i][2] += dx[m]; L[i][3] += dy[m];
                                if(0 <= L[i][0] && L[i][0] < 32767 && 0 <= L[i][1] && L[i][1] < 32767 && 0 <= L[i][2] && L[i][2] < 32767 && 0 <= L[i][3] && L[i][3] < 32767){
                                    int result = recursive(1, L, N);
                                    if(result != -1){
                                        count = Math.min(count, result);
                                    }
                                }
                                L[i][0] -= dx[m]; L[i][1] -= dy[m]; L[i][2] -= dx[m]; L[i][3] -= dy[m];
                            }
                        }else{
                            for(int m = 0; m < 4; m++){
                                L[j][0] += dx[i]; L[j][1] += dy[i]; L[j][2] += dx[i]; L[j][3] += dy[i];
                                if(0 <= L[j][0] && L[j][0] < 32767 && 0 <= L[j][1] && L[j][1] < 32767 && 0 <= L[j][2] && L[j][2] < 32767 && 0 <= L[j][3] && L[j][3] < 32767){
                                    int result = recursive(1, L, N);
                                    if(result != -1){
                                        count = Math.min(count, result);
                                    }
                                }
                                L[j][0] -= dx[m]; L[j][1] -= dy[m]; L[j][2] -= dx[m]; L[j][3] -= dy[m];
                            }
                        }
                    }
                    answer = Math.min(count, answer);
                }
            }
        }

        return answer;
    }
    public static int solution(int N, int[][] L) {
        int answer = getSolution( N,L);
        if(answer == Integer.MAX_VALUE){
            return 0;
        }else{
            return answer;
        }
    }
    public static void main(String[] args){
        int N = 3;
        int [][] L = new int [][] {{5,7,6,6},{3,9,5,4},{8,2,7,6}};
        System.out.println(solution(N,L));
    }
}
