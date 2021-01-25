import java.util.*;

public class Pro9 {
    public static List<String> smallestNegativeBalance(List<List<String>> debts){
        Map<String, Integer> base = new HashMap<String, Integer>();
        List<String> answer = new LinkedList<String>();
        for(List<String> debt : debts){
            String borrower = debt.get(0);
            String lender = debt.get(1);
            int amount = Integer.parseInt(debt.get(2));
            if(base.containsKey(lender)){
                int now = base.get(lender);
                base.replace(lender, now + amount);
            }else{
                base.put(lender, amount);
            }
            if(base.containsKey(borrower)){
                int now = base.get(borrower);
                base.replace(borrower, now - amount);
            }else{
                base.put(borrower, -amount);
            }
        }
        int count = -1;
        for(String person : base.keySet()){
            if(base.get(person) < count){
                answer.clear();
                answer.add(person);
                count = base.get(person);
            }else if(base.get(person) == count){
                answer.add(person);
            }
        }
        if(answer.size() == 0){
            answer.add("Nobody has negative balance");
        }else{
            Collections.sort(answer);
        }
        return answer;
    }
    public static void main(String[] args){
        List<List<String>> base = new ArrayList<List<String>>();
        String[][] items = {{"Blake", "Alex", "7"},
                {"Blake","Alex", "3"},
                {"Alex", "Blake", "4"},
                {"Blake", "Alex", "1"},
                {"Alex", "Blake", "7"}
        };

        for(String[] item: items){
            List<String> temps = new ArrayList<String>();
            for(String i : item){
                temps.add(i);
            }
            base.add(temps);
        }
        System.out.println(smallestNegativeBalance(base));
    }
}
