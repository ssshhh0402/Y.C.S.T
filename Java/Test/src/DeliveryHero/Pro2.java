package DeliveryHero;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Pro2 {
    public static class Item implements Comparable<Item>{
        String date;
        Item(String a){
            this.date = a;
        }
        public int compareTo(Item i){
            long now = getTime(this.date);
            long comp = getTime(i.date);
            return (int) (now -  comp);
        }
    }
    public static String getDate(String[] infos){
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < 5; i++){
            sb.append(infos[i]);
            if(i != 4){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    public static Map<String, Integer> InitMonths(){
        Map<String, Integer> items = new LinkedHashMap<String, Integer>();
        items.put("Jan", 1);
        items.put("Feb", 2);
        items.put("Mar", 3);
        items.put("Apr", 4);
        items.put("May", 5);
        items.put("Jun", 6);
        items.put("Jul", 7);
        items.put("Aug", 8);
        items.put("Sep", 9);
        items.put("Auc", 10);
        items.put("Nov", 11);
        items.put("Dec", 12);
        return items;
    }
    public static long getTime(String date){
        Map<String, Integer> months = InitMonths();
        String[] items = date.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i >= 0; i--){
            if(i == 1){
                sb.append(months.get(items[i]));
            }else{
                sb.append(items[i]);
            }
        }
        return Long.parseLong(sb.toString());
    }
    public static String solution(String S){
        String [] items = S.split("\\\\");
        PriorityQueue<Item> pq = new PriorityQueue<Item>();
        long target = 4 * (int)Math.pow(2, 20);
        for(String item : items){
            item = item.replace("  ", " ");
            item = item.replace("    ", " ");
            String[] infos = item.split(" ");
            if(infos[0].equals("admin") && infos[1].charAt(2)=='x'){
                if(Integer.parseInt(infos[5]) < target){
                    String date = getDate(infos);
                    pq.add(new Item(date));
                }
            }
        }
        if(pq.size() == 0){
            return "NO FILES";
        }else{
            return pq.poll().date;
        }
    }
    public static void main(String[] args)throws IOException {
        System.out.println(solution("admin  -wx 29 Sep 1983        833 source.h\\nadmin  r-x 23 Jun 2003     854016 blockbuster.mpeg\\nadmin  --x 02 Jul 1997        821 delete-this.py\\nadmin  -w- 15 Feb 1971      23552 library.dll\\nadmin  --x 15 May 1979  645922816 logs.zip\\njane   --x 04 Dec 2010      93184 old-photos.rar\\njane   -w- 08 Feb 1982  681574400 important.java\\nadmin  rwx 26 Dec 1952   14680064 to-do-list.txt"));
    }
}
