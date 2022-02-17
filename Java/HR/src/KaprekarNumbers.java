public class KaprekarNumbers {
    public static void kaprekarNumbers(int p, int q){
        StringBuilder sb = new StringBuilder();
        int n;
        for(long i = p;i <= q; i++){
            long target = i*i;
            String now = String.valueOf(target);
            n = now.length();
            if(n == 1){
                if(i == 1){
                    sb.append(1).append(" ");
                }
                continue;
            }
            String left = now.substring(0, (int)(Math.ceil(n/2)));
            String right = now.substring((int)(Math.ceil(n/2)), n);
            long temps = Long.valueOf(left) + Long.valueOf(right);
            if(temps == i){
                sb.append(i).append(" ");
            }
        }
        if(sb.length() == 0){
            System.out.println("INVALID RANGE");
        }else{
            System.out.println(sb.toString());
        }
    }
    public static void main(String[] args){
        int p = 1;
        int q = 99999;
        kaprekarNumbers(p,q);
    }
}
