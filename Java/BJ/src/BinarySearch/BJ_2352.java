package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_2352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int [] base = new int[n];
        for(int idx = 0; idx < n; idx++){
            base[idx] = Integer.parseInt(inputs[idx]);
        }
        
    }
}
