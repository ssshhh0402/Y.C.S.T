import java.util.Stack;

class Money{
    int money, rate, date;
    Money(int a, int b, int c){
        this.money = a;
        this.rate = b;
        this.date = c;
    }
}
public class Pro2 {
    public static int calc(int a, int b){
        int [] months = new int [] {0,31,28,31,30,31,30,31,31,30,31,30,31};
        int time = 0;
        if(a == 1 & b == 1){
            return 0;
        }else{
            for(int t = 1; t < a; t++){
                time += months[t];
            }
            time += b - 1;
        }
        return time;
    }
    public static int solution(String [] ledgers){
        Stack<Money> s = new Stack<Money>();
        int answer = 0;
        for(String ledger : ledgers){
            String[] data = ledger.split(" ");
            String[] date = data[0].split("/");
            int month = Integer.parseInt(date[0]);
            int day = Integer.parseInt(date[1]);
            int rate = Integer.parseInt(data[1]);
            int money = Integer.parseInt(data[2]);
            int c_date = calc(month, day);
            if(money < 0){
                while (money < 0){
                    Money now = s.pop();
                    if(Math.abs(now.money) < Math.abs(money)){
                        double moneys = (now.money * ((double)(now.rate) / (double) 100));
                        double dates = (double)(c_date - now.date) / (double)365;
                        int temps = (int)(moneys * dates);
                        answer += temps;
                    }else{
                        int last = now.money + money;
                        double moneys = Math.abs(money) * ((double)(now.rate) / (double) 100);
                        double dates = (double)(c_date - now.date) / (double)365;
                        int temps = (int)(moneys * dates);
                        answer += (int)(temps);
                        if(last != 0) {
                            s.add(new Money(last, now.rate, now.date));
                        }
                    }
                    money += now.money;

                }

            }else {
                s.add(new Money(money, rate, c_date));
            }
        }
        int N = s.size();
        for(int i = 0 ;i  < N; i++){
            Money m = s.pop();
            double moneys = m.money * ((double)(m.rate) / (double)100);
            double dates = (double)(364 - m.date) / (double)365;
            int temps = (int) (moneys * dates);
            answer += temps;
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(new String [] {"01/01 4 50000","01/11 6 3555","02/01 0 -23555","02/25 5 5000","03/25 0 -15000","06/09 8 43951","12/30 9 99999"}));
    }
}
