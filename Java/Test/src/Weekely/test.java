package Weekely;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
/*
 * Create the Student and Priorities classes here.
 */
class Student implements Comparable<Student>{
    int id;
    String name;
    double cgpa;

    Student(int a, String b, double c){
        this.id = a;
        this.name = b;
        this.cgpa = c;
    }

    public String getName(){
        return this.name;
    }
    public int compareTo(Student s){
        if(this.cgpa == s.cgpa){
            if(this.name.equals(s.name)){
                return this.id - s.id;
            }else{
                return this.name.compareTo(s.name);
            }
        }else{
            if(this.cgpa > s.cgpa){
                return -1;
            }else{
                return 1;
            }
        }
    }
}
class Priorities{
    List<Student> students;
    PriorityQueue<Student> pq;

    Priorities(){
        this.students = new ArrayList<Student>();
        this.pq = new PriorityQueue<Student>();
    }
    public List<Student> getStudents(List<String> events){
        for(String event : events){
            if(event.length() == 6){
                pq.poll();
            }else{
                String[] info = event.split(" ");
                int id = Integer.parseInt(info[3]);
                double cgpa = Double.parseDouble(info[2]);
                pq.add(new Student(id, info[1], cgpa));
            }
        }
        double asdf = 0.1345266;
        System.out.println(Math.round(asdf));
        int n = pq.size();
        for(int i = 0 ; i < n; i++){
            students.add(pq.poll());
        }
        return this.students;
    }
}

public class test {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}