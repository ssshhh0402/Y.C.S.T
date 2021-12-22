package LV2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 캐시 {
    public static int solution(int cacheSize, String[] cities){
        int answer = 0;
        Deque<String> st = new LinkedList<String>();
        if(cacheSize == 0){
            return cities.length * 5;
        }
        for(String city : cities){
            city = city.toLowerCase();
            if(st.contains(city)){
                answer += 1;
                st.remove(city);
                st.addFirst(city);
            }else{
                answer += 5;
                if(st.size() == cacheSize){
                    st.pollLast();
                }
                st.add(city);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int cacheSize = 3;
        String [] cities = new String [] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        cacheSize = 2;
        cities = new String [] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

        System.out.println(solution(cacheSize, cities));
    }
}

