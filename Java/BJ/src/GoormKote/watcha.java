package GoormKote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class watcha {
    static class Item implements Comparable<Item>{
        int x, y,weight;
        double sunho;
        String value;

        Item(int a, int b, int c, double d, String e){
            this.x = a;
            this.y= b;
            this.weight = c;
            this.sunho = d;
            this.value = e;
        }
        public int compareTo(Item i){
            if(i.weight != this.weight){
                return i.weight - this.weight;
            }else{
                if(i.sunho != this.sunho){
                    return Double.compare(i.sunho, this.sunho);
                }else{
                    if(i.x != this.x){
                        return i.x - this.x;
                    }else{
                        return i.y - this.y;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Item> pq = new PriorityQueue<Item>();
        Map<String, Integer> keySets = new LinkedHashMap<String, Integer>();
        Double [] sunhos = new Double[5];
        keySets.put("A", 0);
        keySets.put("B", 1);
        keySets.put("C", 2);
        keySets.put("D", 3);
        keySets.put("E", 4);
        String [] inputs = br.readLine().split(" ");
        for(int i = 0 ; i < 5; i++){
            sunhos[i] = Double.parseDouble(inputs[i]);
        }
        inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        String [][] base = new String[N][M];
        for(int x = 0 ; x < N; x++){
            inputs = br.readLine().split("");
            for(int y = 0 ; y < M; y++){
                base[x][y] = inputs[y];
            }
        }
        for(int x = 0; x < N; x++){
            inputs = br.readLine().split("");
            for(int y = 0 ; y < M; y++){
                if(base[x][y].equals("Y")){
                    pq.add(new Item(x,y,2,sunhos[keySets.get(inputs[y])],inputs[y]));
                }else if(base[x][y].equals("O")){
                    pq.add(new Item(x, y, 1, sunhos[keySets.get(inputs[y])],inputs[y]));
                }
            }
        }
        int I = pq.size();
        for(int i = 0; i < I; i++){
            Item now = pq.poll();
            sb.append(now.value + " " + now.sunho + " " + now.x + " " + now.y+ "\n");
        }
        System.out.println(sb.toString());
    }
}
