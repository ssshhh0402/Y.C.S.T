package Line2023;

import java.util.ArrayList;
import java.util.Collections;

public class Pro2 {
    public static class Person implements Comparable<Person>{
        int id, teamId;
        String works;
        Person(int Id, int Teamid,String Works){
            this.id = Id;
            this.teamId = Teamid;
            this.works = Works;
        }
        @Override
        public int compareTo(Person p){
            return this.id - p.id;
        }
    }
    public static boolean isRemote(String[] work, String [] remoteWorks){
        for(String w : work){
            boolean flag = false;
            for(String remoteWork : remoteWorks){
                if(w.equals(remoteWork)){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                return false;
            }
        }
        return true;
    }
    public static int[] solution(int num_teams, String [] remote_tasks, String[] office_tasks, String [] employees){
        ArrayList<Integer> answers = new ArrayList<Integer>();
        ArrayList<Person>[] teams = new ArrayList[num_teams+1];
        ArrayList<Person>[] remotes = new ArrayList[num_teams+1];
        for(int i = 1; i < num_teams+1; i++){
            teams[i] = new ArrayList<Person>();
            remotes[i] = new ArrayList<Person>();
        }
        for(int i = 0; i < employees.length; i++){
            String employee = employees[i];
            String [] datas = employee.split(" ");
            int teamId = Integer.parseInt(employee.substring(0, 1));
            String tasks = employee.substring(2);
            teams[teamId].add(new Person(i+1, teamId,tasks));
        }
        for(int i = 1; i < num_teams+1; i++){
            for(Person person: teams[i]){
                String[] works = person.works.split(" ");
                if(isRemote(works, remote_tasks)){
                    remotes[person.teamId].add(person);
                }

            }
        }
        for(int i = 1; i < num_teams+1; i++){
            if(remotes[i].size()!= 0 && teams[i].size() == remotes[i].size()){
                Collections.sort(remotes[i]);
                for(int j = 1; j < remotes[i].size(); j++){
                    answers.add(remotes[i].get(j).id);
                }
            }else{
                for(Person p : remotes[i]){
                    answers.add(p.id);
                }
            }
        }
        Collections.sort(answers);
        int [] answer = new int[answers.size()];
        for(int i = 0; i < answers.size(); i++){
            answer[i] = answers.get(i);
        }
        return answer;
    }
    public static void main(String[] args){

        int num_teams = 4;
        String[] remote_tasks = new String []{"development","marketing","hometask"};
        String [] office_tasks = new String [] {"recruitment","education","officetask"};
        String [] employees = new String [] {"1 development hometask","1 recruitment marketing","2 hometask","2 development marketing hometask","3 marketing","3 officetask","3 development"};
        int [] answers = solution(num_teams, remote_tasks, office_tasks, employees);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
