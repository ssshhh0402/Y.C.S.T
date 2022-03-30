package Crema;

public class Pro2 {
    public static long solution(int num){
        long biggest = Long.MIN_VALUE;
        long smallest = Long.MAX_VALUE;
        // 가장 많ㅇ ㅣ나오는 아이 => 9로 가장 적게 나오는 얘 0으로
        String target = String.valueOf(num);
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                String newOne = target.replaceAll(String.valueOf(i), String.valueOf(j));
                if(newOne.charAt(0) != '0'){
                    long now = Long.valueOf(newOne);
                    if(now > biggest){
                        biggest = now;
                    }
                    if(now < smallest){
                        smallest = now;
                    }
                }
            }
        }
        return biggest - smallest;
    }
    public static void main(String[] args){
        int num = 909;
        System.out.println(solution(num));
    }
}
