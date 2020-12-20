import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Person implements Comparable<Person>{
    int name, score;

    Person(int a, int b){
        this.name = a;
        this.score = b;
    }
    public int compareTo(Person p){
        return this.score - p.score;
    }
}
public class Pro1 {
    public static String[] solution(String[] record){
        String[] answer = {};
        PriorityQueue<Person>[] pq = new PriorityQueue[5];
        for(int i = 0 ; i < 5; i++){
            pq[i] = new PriorityQueue<Person>();
        }
        String [] temps = {};
        for(int idx = 0; idx < record.length; idx++){
            String[] person = record[idx].split(":|,");
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(new String[] {"jack:9,10,13,9,15","jerry:7,7,14,10,17","jean:0,0,11,20,0","alex:21,2,7,11,4","kevin:8,4,5,0,0","brown:3,5,16,3,18","ted:0,8,0,0,8","lala:0,12,0,7,9","hue:17,16,8,6,10","elsa:11,13,10,4,13"}));
    }
}
