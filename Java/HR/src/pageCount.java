public class pageCount {
    public static int fromFirst(int n, int p){
        int count = 0;
        int start = 1;
        while(start <= n){
            if(p == start || p == start-1){
                break;
            }
            count += 1;
            start += 2;
        }
        return count;
    }
    public static int fromLast(int n, int p){
        int last = n;
        int count = 0;
        boolean flag = (n % 2 == 0);
        while(last >= 0){
            if(flag){
                if(p == last || p == last+1){
                    break;
                }
            }else{
                if(p == last || p == last-1){
                    break;
                }
            }
            last -= 2;
            count += 1;
        }
        return count;
    }
    public static int pageCount(int n, int p){
        return Math.min(fromFirst(n,p), fromLast(n,p));
    }
    public static void main(String[] args){
        int n = 5;
        int p = 4;
        System.out.println(pageCount(n,p));
    }
}
