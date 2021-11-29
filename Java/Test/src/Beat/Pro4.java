package Beat;

public class Pro4 {
    public static int solution(int [][] casted){
        int n = casted.length;
        int count = 0;
        int min = 1;
        int check = 0;
        boolean [] used = new boolean[13];
        for(int i = 0 ; i < n; i++){
            if(check == 12){
                break;
            }
            int a = casted[i][0], b = casted[i][1];
            if(a == b){
                if(!used[a+b]){
                    used[a+b] = true;
                    check += 1;
                }
            }else if(a == 1 || b == 1 && !used[a+b]){
                used[a+b] = true;
                check += 1;
            }else{
                boolean flag = false;
                int c = a+b;
                for (int j = min; j < c; j++) {
                    if (!used[j] && !used[c - j]) {
                        used[j] = true;
                        flag = true;
                        used[c - j] = true;
                        min = Math.min(min,j + 1);
                        check += 2;
                        break;
                    }
                }
                if(!flag && !used[c]){
                    used[c] = true;
                    check += 1;
                }
            }
            count += 1;
        }
        if(check == 12){
            return count;
        }else{
            return 1;
        }
    }
    public static void main(String[] args){
        int [][] casted = new int [][] {{1,1},{5,6},{5,1},{5,5},{4,1},{6,6},{5,6},{5,6},{6,5},{3,6},{3,4}};
        System.out.println(solution(casted));
    }
}
