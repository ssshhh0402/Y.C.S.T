import java.util.*;

public class Testing {
    static Map<String, Map<String, Integer>> m;
    public static boolean isCheatting(String student1, String student2){
        Map<String ,Integer> scores1 = m.get(student1);
        Map<String, Integer> scores2 = m.get(student2);
        if(scores1.size() != scores2.size()){
            return false;
        }else{
            Object [] keys1 = scores1.keySet().toArray();
            Object [] keys2 = scores2.keySet().toArray();
            int n = keys1.length;
            Arrays.sort(keys1);
            Arrays.sort(keys2);
            for(int i = 0;i < n; i++){
                String key1 = (String)keys1[i];
                String key2 = (String)keys2[i];
                if(!key1.equals(key2) || scores1.get(key1) != scores2.get(key2)){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        String [] logs = new String [] {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"};
        String[] answer = {};
        m = new LinkedHashMap<String, Map<String,Integer>>();
        Set<String> st = new LinkedHashSet<String>();
        String [] datas;
        for(String log : logs){
            datas = log.split(" ");
            String student = datas[0];
            String pro = datas[1];
            int score = Integer.parseInt(datas[2]);
            if(m.containsKey(student)){
                Map<String, Integer> scores = m.get(student);
                if(scores.containsKey(pro)){
                    scores.replace(pro, score);
                }else{
                    scores.put(pro, score);
                }
                m.replace(student, scores);
            }else{
                Map<String, Integer> scores = new LinkedHashMap<String, Integer>();
                scores.put(pro, score);
                m.put(student, scores);
            }
        }
        Object [] students = m.keySet().toArray();
        int n = students.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                String student1 = (String)students[i];
                String student2 = (String) students[j];
                if(isCheatting(student1, student2)){
                    st.add(student1);
                    st.add(student2);
                }
            }
        }
        for(String name : st){
            System.out.println(name);
        }


    }
}
