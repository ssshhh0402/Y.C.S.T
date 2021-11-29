package Silicon;

import java.util.PriorityQueue;

public class Pro2 {
    static class Person implements Comparable<Person>{
        String name;
        int dist, grade, idx;

        Person(String a, int b, int c, int d){
            this.name = a;
            this.dist = b;
            this.grade = c;
            this.idx = d;
        }
        public int compareTo(Person p){
            if(this.grade == p.grade){
                if(this.dist == p.dist){
                    return this.name.compareTo(p.name);
                }else{
                    return p.dist - this.dist;
                }
            }else{
                return p.grade - this.grade;
            }
        }
    }
    public static int[] solution(String [] names, int [][] homes, double [] grades){
        int n = names.length;
        int [] answer = new int [n];
        PriorityQueue<Person> pq = new PriorityQueue<Person>();
        for(int i = 0; i < n; i++){
            int dist = (int)Math.pow(homes[i][0],2) + (int)Math.pow(homes[i][1],2);
            int grade = (int)(grades[i] / 1);
            pq.add(new Person(names[i],dist,grade,i));
        }
        for(int i = 0; i < n; i++){
            Person now = pq.poll();
            answer[now.idx] = i+1;
        }
        return answer;
    }
    public static void main(String[] args){
        String [] names = {"azad","andy","louis","will","edward"};
        int [][] homes = {{3,4},{-1,5},{-4,4},{3,4},{-5,0}};
        double [] grades = new double [] {4.19, 3.77, 4.41, 3.65, 3.58};
        int [] answers = solution(names, homes, grades);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
