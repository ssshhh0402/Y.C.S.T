public class Encrypton {
    public static String encryption(String s){
        int n = s.length();
        double temps = Math.pow(n, 0.5);
        int D = (int)Math.floor(Math.pow(n, 0.5));
        int U = (int)Math.ceil(Math.pow(n, 0.5));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < D; i++){
            for(int j = i; j < n; j+=U){
                sb.append(s.charAt(j));
            }
            sb.append(" ");
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String s = "iffactsdontfittotheorychangethefacts";
        System.out.println(encryption(s));
    }
}
