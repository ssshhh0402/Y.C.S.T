package LineLate;

public class Pro1 {
    static int answer;
    public static void find(int idx, int now, int [] student, int target){
        if(now == target){
            answer += 1;

        }else if(now > target){
            return;
        }
        if(idx == student.length){
            return;
        }
        find(idx+1, now + student[idx], student,target);
    }
    public static int solution(int [] student, int k){
        answer = 0;
        for(int i = 0 ; i < student.length; i++){
            find(i+1, student[i], student, k);
        }
        return answer;
    }
    public static void main(String[] args){
        int [] student = {0,1,0,0};
        int k = 1;
        System.out.println(solution(student, k));
        student = new int[100];
        for(int i = 0 ; i < 100; i++){
            student[i] = 0;
        }
        k = 100;
        System.out.println(solution(student, k));
    }
}
