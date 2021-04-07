package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class BJ_1181_단어정렬 {
    static class Item implements Comparable<Item>{
        String item;


        Item(String a){
            this.item = a;
        }
        public int compareTo(Item i){
            if(this.item.length() == i.item.length()){
                return this.item.compareTo(i.item);
            }else{
                return this.item.length() - i.item.length();
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> answers = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Item> pq = new PriorityQueue<Item>();
        for(int i = 0; i < N; i++){
            String item = br.readLine();
            pq.add(new Item(item));
        }
        while(!pq.isEmpty()){
            Item now = pq.poll();
            if(!answers.contains(now.item)){
                answers.add(now.item);
            }
        }
        for(String answer : answers){
            sb.append(answer + "\n");
        }
        System.out.println(sb.toString());
    }
}
