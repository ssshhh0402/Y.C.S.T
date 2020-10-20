import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class BJ_14888 {
    static int N;
    static int max_num = Integer.MIN_VALUE;
    static int min_num = Integer.MAX_VALUE;
    static int [] nums;
    static int [] opers = new int[4];
    public static void find(int a, int b){
        if(b == N){
            if (a > max_num){
                max_num = a;
            }
            if( a < min_num){
                min_num = a;
            }
        }else{
            for(int idx = 0; idx < 4; idx++){
                if(opers[idx] != 0){
                    opers[idx] -= 1;
                    if (idx == 0){
                        find(a+nums[b], b+1);
                    }else if(idx == 1){
                        find(a-nums[b], b+1);
                    }else if(idx == 2){
                        find(a * nums[b], b+1);
                    }else{
                        if (a >= 0){
                            find(a / nums[b], b+1);
                        }else{
                            int temps = abs(a) / nums[b];
                            find(-temps, b+1);
                        }
                    }
//                    switch(idx){
//                        case 0 : find(a + nums[b], b+1);
//                        break;
//                        case 1 : find(a - nums[b], b+1);
//                        break;
//                        case 2 : find(a * nums[b], b+1);
//                        break;
//                        case 3 : if (a >= 0){
//                            find(a / nums[b], b+1);
//                        }else{
//                            int temps = abs(a) / nums[b];
//                            find(-temps, b+1);
//                        }
//                        break;
//                    }
                    opers[idx] += 1;
                }
            }
        }
    }
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        String numbers = br.readLine();
        StringTokenizer st = new StringTokenizer(numbers, " ");
        for(int idx = 0; idx < N; idx++){
            nums[idx] = Integer.parseInt(st.nextToken());
        }
        String ops = br.readLine();
        StringTokenizer st2 = new StringTokenizer(ops, " ");
        for(int idx= 0; idx < 4; idx++){
            opers[idx] = Integer.parseInt(st2.nextToken());
        }
        for(int i = 0; i < 4; i++) {
            if (opers[i] != 0) {
                opers[i] -= 1;
                if (i == 0){
                    find(nums[0] + nums[1], 2);
                }else if (i == 1){
                    find(nums[0] - nums[1], 2);
                }else if (i == 2){
                    find(nums[0] * nums[1], 2);
                }else if (i == 3){
                    find(nums[0] / nums[1], 2);
                }
//                switch (i) {
//                    case 0: find(nums[0] + nums[1], 2);
//                    break;
//                    case 1: find(nums[0] - nums[1], 2);
//                    break;
//                    case 2: find(nums[0] * nums[1], 2);
//                    break;
//                    case 3: find(nums[0] / nums[1], 2);
//                    break;
//                }
                opers[i] += 1;
            }
        }
        System.out.println(max_num);
        System.out.println(min_num);
    }
}
