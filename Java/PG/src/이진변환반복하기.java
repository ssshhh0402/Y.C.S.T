public class 이진변환반복하기 {
    static StringBuilder sb;
    public static String convert(int target){
        sb = new StringBuilder();
        while(true){
            sb.append(target % 2);
            if(target / 2 == 0){
                break;
            }else{
                target /= 2;
            }
        }
        return sb.reverse().toString();
    }
    public static int[] find(String s){
        int T = 0;
        int count = 0;
        while(!s.equals("1")){
            String now = s.replace("0","");
            count += s.length() - now.length();
            s = convert(now.length());
            T += 1;
        }
        return new int [] {T, count};
    }
    public static void main(String[] args){
        int[] answer = find("110010101001");
        System.out.println("1번");
        for(int item : answer){
            System.out.print(item + " ");
        }
        answer = find("01110");
        System.out.println("2번");
        for (int item : answer){
            System.out.println(item + " ");
        }
        answer = find("1111111");
        System.out.println("3번");
        for(int item : answer){
            System.out.println(item + " ");
        }
    }
}
