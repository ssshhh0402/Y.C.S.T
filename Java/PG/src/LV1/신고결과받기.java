package LV1;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class 신고결과받기 {
    public static int [] solution(String [] id_list, String[] report,  int k){
        int n = id_list.length;
        Map<String, Integer> ids = new LinkedHashMap<String, Integer>();     //String id를 id_list의 인데스로 저장
        Map<Integer, Set<Integer>> reported = new LinkedHashMap<Integer, Set<Integer>>();   //report 당한 아이, 해당 아이를 신고한 사람들 목록
        for(int i = 0; i < n; i++){
            ids.put(id_list[i], i);
        }
        for(String rep : report){
            String [] datas = rep.split(" ");
            int from = ids.get(datas[0]), to = ids.get(datas[1]);
            if(reported.containsKey(to)){                                   //처음으로 신고된 것이 아닐때
                Set<Integer> reportPeople = reported.get(to);
                reportPeople.add(from);
                reported.replace(to, reportPeople);
            }else{                                                          //처음으로 신고 돼었을 때
                Set<Integer> reportPeople = new LinkedHashSet<Integer>();
                reportPeople.add(from);
                reported.put(to, reportPeople);
            }
        }
        Object o = new Object();
        int [] answer = new int [n];
        for(Integer key : reported.keySet()){
            if(reported.get(key).size() >= k){
                Set<Integer> reportPeople = reported.get(key);
                for(Integer from : reportPeople){
                    answer[from] += 1;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        String [] id_list = new String [] {"muzi", "frodo", "apeach", "neo"};
        String [] report = new String [] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int [] answers = solution(id_list, report, k);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
