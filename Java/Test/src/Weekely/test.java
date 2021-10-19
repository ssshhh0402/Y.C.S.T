package Weekely;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * Create the Student and Priorities classes here.
 */
class Student{
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
}
class Priorities{
    List<Student> students;
    ArrayList<Student> al;

    Priorities(List<String> events){
        this.students = new ArrayList<Student>();
        this.al = new ArrayList<Student>();
        for(String event : events){
            if(event.length() == 6){
                students.add(al.get(0));
            }else{
                String[] info = event.split(" ");
                int id = Integer.parseInt(info[1]);
                double cgpa = Double.parseDouble(info[3]);
                al.add(new Student(id, info[2], cgpa));
                al.sort(new Comparator<Student>(){
                    @Override
                    public int compare(Student s1, Student s2){
                        if(s1.cgpa == s2.cgpa){
                            if(s1.name.equals(s2.name)){
                                return s1.id - s2.id;
                            }else{
                                return s1.name.compareTo(s2.name);
                            }
                        }else{
                            if(s1.cgpa > s2.cgpa){
                                return 1;
                            }else{
                                return -1;
                            }
                        }
                    }
                });
            }
        }
    }
    public List<Student> getStudents(){
        return this.students;
    }
}

public class Solution {
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
        PriorityQueue<String> pq = new PriorityQueue<String>();
        pq.pop
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}