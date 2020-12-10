package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ_1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        ArrayList<String> answer = new ArrayList<>();
        String [] groupA = new String[N];
        String [] groupB = new String[M];
        for(int idx = 0; idx < N; idx++){
            groupA[idx] = br.readLine();
        }
        for(int idx = 0; idx < M; idx++){
            groupB[idx] = br.readLine();
        }
        Arrays.sort(groupA);
        Arrays.sort(groupB);
        for(String item : groupA){
            int start = 0;
            int end = M-1;
            int mid = 0;
            boolean find = false;
            while(start <= end){
                mid = (start + end) / 2;
                int comp = item.compareTo(groupB[mid]);
                if (comp == 0){
                    find = true;
                    break;
                }else{
                    if (comp > 0){
                        start = mid + 1;
                    }else{
                        end = mid - 1;
                    }
                }
                }
            if(find){
                answer.add(item);
            }
        }
        System.out.println(answer.size());
        for(int idx = 0; idx < answer.size(); idx++){
            System.out.println(answer.get(idx));
        }
    }
}
