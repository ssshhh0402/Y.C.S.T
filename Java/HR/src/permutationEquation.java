import java.util.ArrayList;
import java.util.List;

public class permutationEquation {
    public static List<Integer> permutationEquation(List<Integer> p){
        List<Integer> answer = new ArrayList<Integer>();
        for(int i = 1; i < p.size()+1; i++){
            answer.add(p.indexOf(p.indexOf(i)+1)+1);
        }
        return answer;
    }
    public static void main(String[] args){
        int [] P = new int [] {2,3,1};
        List<Integer> p = new ArrayList<Integer>();
        for(int pp : P){
            p.add(pp);
        }
        List<Integer> answers = permutationEquation(p);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
