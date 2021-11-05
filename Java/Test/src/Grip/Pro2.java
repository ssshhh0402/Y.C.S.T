package Grip;

public class Pro2 {
    public static String [] solution(int [] numArr) {
        String[] answer = new String[2];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            count += numArr[i];
        }
        double result = (double) count / (double) 3;
        answer[0] = String.format("%2f", result);
        if (result >= 90) {
            answer[1] = "A";
        } else if (result >= 80) {
            answer[1] = "B";
        } else if (result >= 70) {
            answer[1] = "C";
        } else if (result >= 60) {
            answer[1] = "D";
        } else {
            answer[1] = "F";
        }
        return answer;
    }
    public static void main(String[] args){
        int [] numArr = new int [] {100,100,98};
        String [] results = solution(numArr);
        for(String result : results){
            System.out.println(result);
        }
    }
}
