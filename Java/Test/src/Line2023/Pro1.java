package Line2023;

public class Pro1 {
    public static boolean isPossible(String [] datas){
        if(datas.length < 11){
            return false;
        }
        int count = 0;
        if(datas[0].equals("team_name") && datas[3].equals("application_name") && datas[6].equals("error_level") && datas[9].equals("message")){
            for(int i = 2; i < datas.length; i+=3){
                count += datas[i-2].length();
                count += datas[i].length();
                String target = datas[i];
                if(!datas[i-1].equals("")){
                    return false;
                }
                for(int j = 0; j < target.length(); j++){
                    if(!Character.isAlphabetic(target.charAt(j))){
                        return false;
                    }
                }

            }
        }else{
            return false;
        }
        if(count > 100){
            return false;
        }else{
            return true;
        }
    }
    public static int solution(String[] logs){
        int answer = 0;
        for(String log : logs){
            log = log.replace(" :", ",");
            String[] datas = log.split(",| ");
            if(!isPossible(datas)){
                answer += 1;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        String [] logs = new String[] {"team_name : db application_name : dbtest error_level : info message : test", "team_name : test application_name : I DONT CARE error_level : error message : x", "team_name : ThisIsJustForTest application_name : TestAndTestAndTestAndTest error_level : test message : IAlwaysTestingAndIWillTestForever", "team_name : oberervability application_name : LogViewer error_level : error"};
        System.out.println(solution(logs));
    }
}
