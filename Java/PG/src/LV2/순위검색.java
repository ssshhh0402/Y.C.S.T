package LV2;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 순위검색 {
    public static int [] solution(String [] info, String [] query){
        int [] answer = new int [query.length];
        Map<String, Map> infos = new LinkedHashMap<String, Map>();
        Queue<Map> que;
        for(String item : info){
            String [] datas = item.split(" ");
            Map now;
            if(infos.containsKey(datas[0])){
                now = infos.get(datas[0]);
            }else{
                infos.put(datas[0], new LinkedHashMap<String, Map>());
                now = infos.get(datas[0]);
            }
            for(int i = 1; i < datas.length; i++){
                if(now.containsKey(datas[i])){
                    now = (Map)now.get(datas[i]);
                }else{
                    now.put(datas[i], new LinkedHashMap<String, Map>());
                    now = (Map)now.get(datas[i]);
                }
            }
        }
        for(int i = 0; i < query.length; i++){
            que = new LinkedList<Map>();
            que.add(infos);
            String q = query[i].replaceAll(" and ", " ");
            String [] datas = q.split(" ");
            for(int p = 0; p < datas.length; p++) {
                if (datas[p].equals("-")) {
                    int n = que.size();
                    for(int j = 0; j < n; j++){
                        Map<String, Map> now = que.poll();
                        for(String key : now.keySet()){
                            que.add(now.get(key));
                        }
                    }
                } else {
                    if(p != datas.length - 1) {
                        int n = que.size();
                        for (int j = 0; j < n; j++) {
                            Map<String, Map> now = que.poll();
                            if (now.containsKey(datas[p])) {
                                que.add(now.get(datas[p]));
                            }
                        }
                    }else{
                        int target = Integer.valueOf(datas[p]);
                        int n = que.size();
                        for(int j = 0; j < n; j++){
                            Map<String, Map> now = que.poll();
                            for(String key : now.keySet()){
                                int comp = Integer.valueOf(key);
                                if(comp >= target){
                                    que.add(now.get(key));
                                }
                            }
                        }
                    }
                }
                if(que.size() == 0){
                    break;
                }
            }
            answer[i] = que.size();
        }
        return answer;
    }
    public static void main(String[] args){
        String [] info = new String [] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String [] query = new String [] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int [] answers = solution(info, query);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
