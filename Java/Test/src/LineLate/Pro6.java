package LineLate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Pro6 {
    static class Item implements Comparable<Item>{
        int reBuyer, Buyer;
        String pid;
        double percent;

        Item(int a, int b, String c){
            this.reBuyer = a;
            this.Buyer = b;
            this.pid = c;
            this.calc();
        }
        void calc(){
            percent = ((double)(this.reBuyer) / (double)(this.Buyer)) * 100;
        }
        public int compareTo(Item i){
            if(this.percent != i.percent){
                if(this.percent < i.percent){
                    return 1;
                }else{
                    return -1;
                }
            }else{
                if(this.Buyer != i.Buyer){
                    return i.Buyer - this.Buyer;
                }else{
                    if(this.pid.compareTo(i.pid) < 0){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            }
        }
    }
    public static long StoL(String date){
        String [] dates = date.split("-");
        long result = 0;
        result += Integer.parseInt(dates[2]);
        result += 30 * (Integer.parseInt(dates[1]));
        result += 12 * 30 * Integer.parseInt(dates[0]);
        return result;
    }
    public static String [] solution(String [] records, int k, String date){
        long dates = StoL(date);
        PriorityQueue<Item> pq = new PriorityQueue<Item>();
        Map<String, Map<String, ArrayList<String>>> m = new LinkedHashMap<String ,Map<String, ArrayList<String>>>();
        for(String record : records){
            String[] data = record.split(" ");
            long item_date = StoL(data[0]);
            if(dates - item_date < k && dates >= item_date){
                if(!m.containsKey(data[2])){
                    ArrayList<String> reBuyer = new ArrayList<String>();
                    ArrayList<String> buyer = new ArrayList<String>();
                    buyer.add(data[1]);
                    Map<String, ArrayList<String>> temps = new LinkedHashMap<String, ArrayList<String>>();
                    temps.put("Rebuyer", reBuyer);
                    temps.put("Buyer", buyer);
                    m.put(data[2], temps);
                }else{
                    Map<String, ArrayList<String>> now = m.get(data[2]);
                    if(now.get("Buyer").contains(data[1])){
                        ArrayList<String> reBuyer = now.get("Rebuyer");
                        if(!reBuyer.contains(data[1])){
                            reBuyer.add(data[1]);
                            now.replace("Rebuyer", reBuyer);
                        }
                    }else{
                        ArrayList<String> Buyer = now.get("Buyer");
                        Buyer.add(data[1]);
                        now.replace("Buyer", Buyer);
                    }
                    m.replace(data[2], now);
                }
            }
        }
        for(String key : m.keySet()){
            Map<String, ArrayList<String>> temps = m.get(key);
            if(temps.get("Buyer").size() != 0) {
                pq.add(new Item(temps.get("Rebuyer").size(), temps.get("Buyer").size(), key));
            }
        }
        int n = pq.size();
        String [] answer;
        if(n != 0) {
            answer = new String[n];
            for (int i = 0; i < n; i++) {
                Item item = pq.poll();
                answer[i] = item.pid;
            }
        }else{
            answer = new String[1];
            answer[0] = "no result";
        }
        return answer;
    }

    public static void main(String[] args){
        String [] records = {"2020-02-02 uid1 pid1", "2020-02-26 uid1 pid1", "2020-02-26 uid2 pid1", "2020-02-27 uid3 pid2", "2020-02-28 uid4 pid2", "2020-02-29 uid3 pid3", "2020-03-01 uid4 pid3", "2020-03-03 uid1 pid1", "2020-03-04 uid2 pid1", "2020-03-05 uid3 pid2", "2020-03-05 uid3 pid3", "2020-03-05 uid3 pid3", "2020-03-06 uid1 pid4"};
        int k = 10;
        String date = "2020-03-05";
        String [] answers = solution(records, k, date);
        for(String answer : answers){
            System.out.println(answer);
        }
    }
}
