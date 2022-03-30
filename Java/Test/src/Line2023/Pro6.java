package Line2023;

import java.util.*;

public class Pro6 {
    public static class Item implements Comparable<Item>{
        String user;
        int price, amount;
        Item(String User, int Amount, int Price){
            this.user = User;
            this.amount = Amount;
            this.price = Price;
        }
        @Override
        public int compareTo(Item i){
            if(this.price == i.price){
                return i.amount - this.amount;
            }else{
                return this.price - i.price;
            }
        }
    }
    public static String [] solution(String [] req_id, int [][] req_info){
        ArrayList<String> results = new ArrayList<String>();
        PriorityQueue<Item> SellPending = new PriorityQueue<Item>();
        PriorityQueue<Item> BuyPending = new PriorityQueue<Item>();
        Map<String, int [] > m = new LinkedHashMap<String, int[]>();
        int n = req_id.length;
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            if(req_info[i][0] == 0){
                int nowAmount = req_info[i][1];
                int nowPrice = req_info[i][2];
                int pay = 0;
                int get = 0;
                while(!BuyPending.isEmpty() && nowAmount > 0){
                    Item now = BuyPending.poll();
                    if(now.price < nowPrice){
                        BuyPending.add(now);
                        break;
                    }else{
                        if(now.amount >= nowAmount){
                            if(now.amount != nowAmount) {
                                BuyPending.add(new Item(now.user, now.amount - nowAmount, now.price));
                            }
                            pay += now.price * nowAmount;
                            get += nowAmount;
                            if(m.containsKey(now.user)){
                                int [] nows = m.get(now.user);
                                nows[0] -= (now.amount - nowAmount);
                                nows[1] += (now.price * nowAmount);
                                m.replace(now.user, nows);
                            }else{
                                int [] nows = new int[2];
                                nows[0] = -(now.amount - nowAmount);
                                nows[1] = now.price * nowAmount;
                                m.put(now.user, nows);
                            }
                            nowAmount = 0;
                        }else{
                            nowAmount -= now.amount;
                            get += now.amount;
                            pay += now.price * now.amount;
                            if(m.containsKey(now.user)){
                                int [] nows = m.get(now.user);
                                nows[0] -= now.amount;
                                nows[1] += (now.price * now.amount);
                                m.replace(now.user, nows);
                            }else{
                                int [] nows = new int[2];
                                nows[0] = (-now.amount);
                                nows[1] += now.price * now.amount;
                                m.put(now.user, nows);
                            }
                        }
                    }
                }
                if(get != 0){
                    if(m.containsKey(req_id[i])){
                        int [] nows = m.get(req_id[i]);
                        nows[0] += get;
                        nows[1] -= pay;
                        m.replace(req_id[i], nows);
                    }else{
                        int [] nows = new int[2];
                        nows[0] += get;
                        nows[1] -= pay;
                        m.put(req_id[i], nows);
                    }
                }
                if(nowAmount != 0){
                    SellPending.add(new Item(req_id[i], nowAmount, nowPrice));
                }
            }else{
                int targetAmount = req_info[i][1];
                int targetPrice = req_info[i][2];
                int pay = 0, get = 0;
                while(targetAmount > 0 && !SellPending.isEmpty()){
                    Item now = SellPending.poll();
                    if(now.price > targetPrice){
                        SellPending.add(now);
                        break;
                    }
                    if(now.amount >= targetAmount){
                        if(now.amount != targetAmount){
                            SellPending.add(new Item(now.user, now.amount - targetAmount, now.price * now.amount));
                        }
                        pay += now.price * targetAmount;
                        get += targetAmount;
                        if(m.containsKey(now.user)){
                            int [] nows = m.get(now.user);
                            nows[0] -= targetAmount;
                            nows[1] += now.price * targetAmount;
                            m.replace(now.user, nows);
                        }else{
                            int [] nows = new int[2];
                            nows[0] -= targetAmount;
                            nows[1] += now.price * targetAmount;
                            m.put(now.user, nows);
                        }
                        targetAmount = 0;
                    }else{
                        targetAmount -= now.amount;
                        pay += now.price * now.amount;
                        get += now.amount;
                        if(m.containsKey(now.user)){
                            int [] nows = m.get(now.user);
                            nows[0] -= now.amount;
                            nows[1] += (now.price * now.amount);
                            m.replace(now.user, nows);
                        }else{
                            int [] nows = new int[2];
                            nows[0] -= now.amount;
                            nows[1] += (now.price * now.amount);
                            m.put(now.user, nows);
                        }
                    }
                }
                if(get != 0){
                    if(m.containsKey(req_id[i])){
                        int [] nows = m.get(req_id[i]);
                        nows[0] += get;
                        nows[1] -= pay;
                        m.replace(req_id[i], nows);
                    }else{
                        int [] nows = new int[2];
                        nows[0] += get;
                        nows[1] -= pay;
                        m.put(req_id[i], nows);
                    }

                }
                if(targetAmount != 0){
                    BuyPending.add(new Item(req_id[i], targetAmount, targetPrice));
                }
            }
        }
        for(String key : m.keySet()){
            int [] nows = m.get(key);
            String result = key;
            if(nows[0] < 0){
                result += " - " + nows[0];
            }else if(nows[0] == 0){
                result += " 0 ";
            }else{
                result += " + " + nows[0];
            }
            if(nows[1] < 0){
                result += " - " + nows[1];
            }else if(nows[1] == 0){
                result += " 0 ";
            }else{
                result += " + " + nows[1];
            }
            results.add(result);
        }
        Collections.sort(results);
        String [] answer = new String [results.size()];
        for(int i = 0 ; i < results.size(); i++){
            answer[i] = results.get(i);
        }
        return answer;
    }
    public static void main(String[] args){
        String [] req_id = new String [] {"William", "Andy", "Rohan", "Rohan", "Louis", "Andy"};
        int[] [] req_info = new int [][] {{1, 7, 20}, {0, 10, 10}, {1, 10, 40}, {1, 4, 25}, {0, 5, 11}, {0, 20, 30}};
        String [] results = solution(req_id, req_info);
        for(String result: results){
            System.out.println(result);
        }
    }
}
