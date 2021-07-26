public class 두개이하비트 {
    public static int [] solution(int [] numbers){
        int [] answers = new int[numbers.length];
        for(int number : numbers){
            String target = Integer.toBinaryString(number);
            System.out.println(target);
        }
        return answers;
    }
    public static void main(String[] args){
        int [] numbers = new int [] {2,7};
        int [] answers = solution(numbers);
    }
}
