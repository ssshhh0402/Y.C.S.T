package KakaoLate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Pro3 {
    public static long TtoL(String times){
        String [] time = times.split(":");
        long result = 0;
        result += 60 * (Integer.parseInt(time[0])) + Integer.parseInt(time[1]);
        return result;
    }
    public static int [] solution(int [] fees, String [] records){
        Map<String, Map<String, ArrayList<Long>>> m = new LinkedHashMap<String, Map<String, ArrayList<Long>>>();
        String [] inputs;
        for(String record : records){
            inputs = record.split(" ");
            long time = TtoL(inputs[0]);
            if(m.containsKey(inputs[1])){
                Map<String, ArrayList<Long>> oldOne = m.get(inputs[1]);
                ArrayList<Long> lists = oldOne.get(inputs[2]);
                lists.add(time);
                oldOne.replace(inputs[2], lists);
                m.replace(inputs[1], oldOne);
            }else{
                Map<String, ArrayList<Long>> newOne = new LinkedHashMap<String, ArrayList<Long>>();
                ArrayList<Long> in = new ArrayList<Long>();
                ArrayList<Long> out = new ArrayList<Long>();
                if(inputs[2].equals("IN")){
                    in.add(time);
                }else{
                    out.add(time);
                }
                newOne.put("IN", in);
                newOne.put("OUT", out);
                m.put(inputs[1], newOne);
            }
        }
        int [] answers = new int [m.size()];
        Object [] keys = m.keySet().toArray();
        Arrays.sort(keys);
        for(int i = 0 ; i < answers.length; i++){
            String key = (String)keys[i];
            int money = 0;
            long time = 0;
            Map<String, ArrayList<Long>> result = m.get(key);
            ArrayList<Long> ins = result.get("IN");
            ArrayList<Long> outs = result.get("OUT");
            for(int j = 0 ; j < ins.size(); j++){
                long in = ins.get(j);
                long out;
                if(j >= outs.size()){
                    out = TtoL("23:59");
                }else{
                    out = outs.get(j);
                }
                time += (out - in);
            }
            if(time > fees[0]){
                money += fees[1] + (int)(Math.ceil((double)(time - fees[0]) / fees[2])) * fees[3];
            }else{
                money += fees[1];
            }
            answers[i] = money;
        }
        return answers;
    }

    public static void main(String[] args){
        int [] fees = {180, 5000, 10, 600};

        String [] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int [] answers = solution(fees, records);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
