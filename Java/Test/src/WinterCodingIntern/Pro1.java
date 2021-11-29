package WinterCodingIntern;

import java.util.LinkedHashMap;
import java.util.Map;

public class Pro1 {
    static class Info{
        int idx, exp, hp,atk,def;

        Info(int a, int b, int c, int d, int e){
            this.idx = a;
            this.exp = b;
            this.hp = c;
            this.atk = d;
            this.def = e;
        }
    }
    public static double getResult(Info user, Info Monster){
        double result = 0;
        int full_hp = user.hp;
        int dmg = user.atk - Monster.def;
        int mon_dmg = Monster.atk - user.atk;
        if(dmg <= 0){
            result = -1;
        }else{
            int time = 1;
            while(true){
                Monster.hp -= dmg;
                if(Monster.hp <= 0){
                    break;
                }
                user.hp -= mon_dmg;
                if(user.hp <= 0){
                    result = - 1;
                    break;
                }else{
                    user.hp = full_hp;
                }
                time += 1;
            }
            if(result != -1) {
                result = (double) Monster.exp / (double) time;
            }
        }
        return result;
    }
    public static String solution(String character, String [] monsters){
        String answer = "";
        String [] infos = character.split(" ");
        Info user = new Info(0,0,Integer.parseInt(infos[0]), Integer.parseInt(infos[1]), Integer.parseInt(infos[2]));
        Map<String, Info> m = new LinkedHashMap<String, Info>();
        for(int i = 0 ; i < monsters.length; i++){
            infos = monsters[i].split(" ");
            int exp = Integer.parseInt(infos[1]), hp = Integer.parseInt(infos[2]);
            int atk = Integer.parseInt(infos[3]), def = Integer.parseInt(infos[4]);
            m.put(infos[0], new Info(i, exp, hp,atk,def));
        }
        double temps = 0;   //1초
        double temps2 = 0;  //1마리
        int temps3 = 0;     //idx
        for(String key : m.keySet()){
            Info monster = m.get(key);
            double result = getResult(user, monster);
            if(result == -1){
                continue;
            }
            if(result == temps){
                if(monster.exp > temps2){
                    temps2 = result;
                    answer = key;
                }else if(monster.exp == temps2){
                    if(monster.idx < temps3){
                        temps3 = monster.idx;
                        answer = key;
                    }
                }
            }else if(result > temps){
                temps = result;
                answer = key;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        String character = "10 5 2";
        String[] monsters = {"Knight 3 10 10 3","Wizard 5 10 15 1","Beginner 1 1 15 1"};
        System.out.println(solution(character, monsters));
    }
}
