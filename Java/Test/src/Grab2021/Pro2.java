package Grab2021;

import java.util.*;

public class Pro2 {
    static class Score implements Comparable<Score>{
        String name, score;
        int idx;

        Score(String a, String b, int c){
            this.name = a;
            this.score = b;
            this.idx = c;
        }
        public void change(int a, String b){
            this.idx = a;
            this.score = b;
        }
        public int compareTo(Score s){
            if(convert.get(this.score) == convert.get(s.score)){
                return this.idx - s.idx;
            }else{
                return convert.get(s.score) - convert.get(this.score);
            }
        }
    }
    static Map<String, Integer> convert = new LinkedHashMap<String, Integer>();
    public static String [] solution(String [] grades){
        Map<String, Score> result = new LinkedHashMap<String, Score>();
        init();
        String[] inputs;
        for(int i = 0 ; i < grades.length; i++){
            inputs = grades[i].split(" ");
            if(result.containsKey(inputs[0])){
                Score before = result.get(inputs[0]);
                if(convert.get(inputs[1]) - convert.get(before.score) > 0){
                    before.change(i,inputs[1]);
                }
            }else{
                result.put(inputs[0],new Score(inputs[0],inputs[1], i));
            }
        }
        PriorityQueue<Score> pq = new PriorityQueue<Score>();
        for(String name : result.keySet()){
            pq.add(result.get(name));
        }
        int i = 0;
        String [] answers = new String[result.size()];
        while(!pq.isEmpty()){
            Score s = pq.poll();
            answers[i] = s.name + " " + s.score;
            i += 1;
        }
        return answers;
    }
    public static void init(){
        convert.put("A+", 14);
        convert.put("A0", 13);
        convert.put("A-", 12);
        convert.put("B+", 11);
        convert.put("B0", 10);
        convert.put("B-", 9);
        convert.put("C+", 8);
        convert.put("C0", 7);
        convert.put("C-", 6);
        convert.put("D+", 5);
        convert.put("D0", 4);
        convert.put("D-", 3);
        convert.put("F", 2);
    }
    public static void main(String[] args) {
        String [] grades = {"DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F", "DB0001 B-", "AI5543 D+", "DS7651 A+", "OS1808 B-"};
        String [] answers = solution(grades);
        for(String answer : answers){
            System.out.println(answer);
        }
    }
}
