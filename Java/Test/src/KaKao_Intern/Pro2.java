package KaKao_Intern;

public class Pro2 {
    public static int [] solution(String [][] places){
        int [] answer = new int[places.length];
        for(int i = 0 ; i < places.length; i++){
            String [] place = places[i];
            boolean flag = false;
            for(int x = 0; x < 5; x++){
                for(int y = 0; y < 5; y++){
                    if(place[x].charAt(y) == 'P'){
                        if(x + 1 < 5 && place[x+1].charAt(y) == 'P' || y + 1 < 5 && place[x].charAt(y+1) == 'P'){                   //왼쪽, 아래
                            flag = true;
                            break;
                        }
                        if(x + 2 < 5 && place[x+2].charAt(y) == 'P'){                                                                   //아래 2칸
                            if(place[x+1].charAt(y) != 'X'){
                                flag = true;
                                break;
                            }
                        }
                        if(y + 2 < 5 && place[x].charAt(y+2) == 'P'){                                                                   //  왼쪽 2칸
                            if(place[x].charAt(y+1) != 'X'){
                                flag = true;
                                break;
                            }
                        }
                        if(x - 1 >= 0 && y + 1 < 5 && place[x-1].charAt(y+1) == 'P'){
                            if(!(place[x-1].charAt(y) == 'X' && place[x].charAt(y+1) == 'X')){
                                flag = true;
                                break;
                            }
                        }
                        if(x + 1 < 5 && y + 1 < 5 && place[x+1].charAt(y+1) == 'P'){                                                    // 아래 대각선
                            if(!(place[x].charAt(y+1) == 'X' && place[x+1].charAt(y) == 'X')){
                                flag = true;
                                break;
                            }
                        }
                    }
                }
                if(flag){
                    break;
                }
            }
            if(!flag){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int [] answers = solution(new String [][] {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
        for(int answer : answers){
            System.out.println(answer);
        }

    }
}
