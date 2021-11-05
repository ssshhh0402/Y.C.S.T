import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */
    public static int getGrade(List<Integer> ranked){
        int rank = 1;
        for(int i = 0; i < ranked.size()-1; i++){
            int now = ranked.get(i);
            int before = ranked.get(i+1);
            if(ranked.get(i) > ranked.get(i+1)){
                rank += 1;
            }
        }
        return rank;
    }
    public static List<Integer> climbingLeaderboard2(List<Integer> scores, List<Integer> alice){
        ArrayList<Integer> al = new ArrayList<Integer>();
        List<Integer> answer = new ArrayList<Integer>();
        int grade = getGrade(scores)+1;
        for(int score : scores) {
            if(!al.contains(score)) {
                al.add(score);
            }
        }
        int x = (int)Math.pow(10, 9);
        int y =(int)Math.pow(10, 9);
        int temps2344 [][] = new int[x][y];
        System.out.println("?????");
        Collections.sort(al);
        int idx = al.size()-1;
        for(int i = 0; i < alice.size(); i++){
            int now = alice.get(i);
            int same = 0;
            for(int j = idx; j >= 0; j--){
                int temps = al.get(j);
                if(al.get(j) > now){
                    idx = j;
                    grade -= same;
                    al.add(j+1, now);
                    break;
                }else if(al.get(j) < now){
                    grade -= 1;
                }else{
                    same += 1;
                }
            }
            answer.add(grade);
        }
        return answer;
    }
    public static List<Integer> climbingLeaderboard(List<Integer> scores, List<Integer> alice) {
        // Write your code here
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.add(1, 6);
        for(int item : al){
            System.out.println(item);
        }
        List<Integer> li = new ArrayList<Integer>();
        int[] result = new int[alice.size()];
//중복되는 score 제거. scoreList index+1 = ranking
        Set<Integer> scoreSet = new HashSet<>();
        for (int i = 0; i < scores.size(); i++) {
            scoreSet.add(scores.get(i));
        }
        List<Integer> scoreList = new ArrayList<>(scoreSet);
//내림차순 정렬
        Collections.sort(scoreList);
        Collections.reverse(scoreList);
        int startIndex = 0;
        for (int i = alice.size() - 1; i >= 0; i--) {
            int aliceScore = alice.get(i);
//꼴찌로 가정
            result[i] = scoreList.size() + 1;
            for (int j = startIndex; j < scoreList.size(); j++) {
                if (scoreList.get(j) <= aliceScore) {
                    result[i] = j + 1;
                    break;
                } else {
                    startIndex++;
                }
            }
        }
        for(int item : result){
            li.add(item);
        }
        return li;
    }

}

public class Solution {
    public static void Que() throws IOException{
        Stack<Integer> in = new Stack<Integer>();
        Stack<Integer> out = new Stack<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        String [] inputs;
        while(n != -1){
            inputs = br.readLine().split(" ");
            if(inputs.length == 2){
                in.add(Integer.parseInt(inputs[1]));
            }else{
                n = Integer.parseInt(inputs[0]);
                if(n == 1){
                    if(out.size() != 0){
                        System.out.println(out.pop());
                    }else{
                        if(in.size() == 0){
                            System.out.println("UnderFlow!!");
                        }else{
                            while(in.size() != 0){
                                out.add(in.pop());
                            }
                            System.out.println(out.pop());
                        }
                    }
                }else if(n == 3){
                    if(out.size() != 0){
                        while(out.size() != 0){
                            System.out.println(out.pop());
                        }
                        while(in.size() != 0){
                            out.add(in.pop());
                        }
                        while(out.size() != 0){
                            System.out.println(out.pop());
                        }
                        System.out.println("-------끝--------");
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //Que();
        List<Integer> li2 = new ArrayList<Integer>();
        int [] lis = new int [] {100, 90, 90, 80, 75, 60};
        int [] lis2 = new int [] {50, 65,77, 90, 102};
        List<Integer> li = new ArrayList<Integer>();
        for(int item : lis){
            li.add(item);
        }
        for(int item : lis2){
            li2.add(item);
        }
        List<Integer> answers = Result.climbingLeaderboard2(li,li2);
        for(int answer : answers){
            System.out.println(answer);
        }

    }
}
