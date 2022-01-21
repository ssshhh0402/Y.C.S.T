import java.util.*;
/**
 * 자연수 N개가 중복없이 들어있는 배열이 있습니다.
 * 이때, 서로 다른 두 원소의 위치를 바꾸는 Swap 연산을 이용해 원소들의 위치를 바꿔 서로 인접한 원소의 차가 K 이하가 되도록 하려 합니다.
 * 단, Swap 연산을 최대한 적게 사용해야 합니다
 * 배열 numbers가 매개변수로 주어질 때,
 * 서로 인접한 원소의 차가 K 이하가 되도록 하는데 필요한 Swap 횟수의 최솟값을 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * numbers의 길이(N)는 1 이상 8 이하입니다.
 * numbers의 원소는 1 이상 100 이하인 자연수입니다.
 * 숫자는 중복없이 들어있습니다.
 * K는 1 이상 100 이하인 자연수입니다.
 * 서로 인접한 원소의 차가 K 이하가 되도록 할 수 있는 방법이 없다면 -1을 return 하세요.
 */
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    static ArrayList<int[]> al;
    static boolean[] used;
    static int answer,n;
    public static void init(int idx, int [] route, int [] numbers, int K){
        if(idx == n){
            al.add(Arrays.copyOf(route, n));
            return;
        }
        for(int i = 0; i < n; i++){
            if(!used[i] && Math.abs(route[idx-1] - numbers[i]) <= K){
                route[idx] = numbers[i];
                used[i] = true;
                init(idx+1, route, numbers, K);
                used[i] = false;
                route[idx] = 0;
            }
        }
    }
    public static int getCount(int [] route, int [] numbers){
        int count = 0;
        for(int i = 0; i < n; i++){
            if(route[i] != numbers[i]){
                for(int j = 0; j < n; j++){
                    if(route[i] == numbers[j]){
                        count += 1;
                        int temps = route[i];
                        route[i] = route[j];
                        route[j] = temps;
                        break;
                    }
                }
            }
        }
        return count;
    }
    public int solution(int[] numbers, int K) {
        answer = Integer.MAX_VALUE;
        al = new ArrayList<int[]>();
        n = numbers.length;
        used = new boolean[n];
        int [] route = new int[n];
        for(int i = 0; i < n; i++){
            used[i] = true;
            route[0] = numbers[i];
            init(1, route, numbers, K);
            route[0] = 0;
            used[i] = false;
        }
        if(al.size() == 0){
            return -1;
        }else{
            for(int [] item : al){
                int counts = getCount(item, numbers);
                answer = Math.min(answer, counts);
            }
            return answer;
        }
    }
}