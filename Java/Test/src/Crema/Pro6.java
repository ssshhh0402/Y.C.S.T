package Crema;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class Pro6 {
    public static int getMax(int[] count, boolean[] used){
        int max_idx = -1, max_value = Integer.MIN_VALUE;
        for(int i = 0; i < count.length; i++){
            if(!used[i]){
                if(count[i] > max_value){
                    max_idx = i;
                    max_value = count[i];
                }
            }
        }
        return max_idx;
    }
    public static int hospital(int cityNodes, List<Integer> cityFrom, List<Integer> cityTo){
        int answer = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer>[] al = new ArrayList[cityNodes+1];
        for(int i = 0; i < cityNodes+1; i++){
            al[i] = new ArrayList<Integer>();
        }
        boolean [] used = new boolean[cityNodes+1];
        int [] count = new int[cityNodes+1];
        for(int i = 0; i < cityFrom.size(); i++){
            int from = cityFrom.get(i);
            int to = cityTo.get(i);
            count[to]+=1;
            count[from] += 1;
            al[from].add(to);
            al[to].add(from);
        }
        for(int i = 0; i < cityNodes+1;i++){
            if(count[i] == 1){
                q.add(i);

            }
        }
        while(!q.isEmpty()){

            int counting = 0;
            int now = q.poll();
            if(used[now]){
                continue;
            }else{
                answer += 1;
            }
            for(int toGo : al[now]){
                if(used[toGo]) {
                    counting += 1;
                    used[now] = true;
                }else {
                    counting += 1;
                    used[toGo] = true;
                    for (int next : al[toGo]) {
                        if (!used[next]) {
                            counting+=1;
                            used[next] = true;
                        }
                    }
                }
            }
            cityNodes -= counting;
        }
        if(cityNodes == 0){
            return answer;
        }else{
            while(cityNodes != 0){
                cityNodes-=1;
                int maxIdx = getMax(count, used);
                answer += 1;
                for(int item : al[maxIdx]){
                    if(!used[item]){
                        used[item] = true;
                        cityNodes -= 1;
                    }
                }
            }
        }
        return answer;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] cityNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int cityNodes = Integer.parseInt(cityNodesEdges[0]);
        int cityEdges = Integer.parseInt(cityNodesEdges[1]);

        List<Integer> cityFrom = new ArrayList<>();
        List<Integer> cityTo = new ArrayList<>();

        IntStream.range(0, cityEdges).forEach(i -> {
            try {
                String[] cityFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                cityFrom.add(Integer.parseInt(cityFromTo[0]));
                cityTo.add(Integer.parseInt(cityFromTo[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = hospital(cityNodes, cityFrom, cityTo);
        System.out.println(result);
    }
}
