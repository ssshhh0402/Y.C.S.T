package Scatter;

import java.util.*;

public class Pro1 {
    public static class OneDay implements Comparable<OneDay>{
        int temp, weather1,weather2, day;
        int tempScore, weatherScore, dayScore, totalScore;

        public OneDay(int Temp, int Weather1, int Weather2,int Day, int TempScore, int WeatherScore,int DayScore){
            this.temp = Temp;
            this.weather1 = Weather1;
            this.weather2 = Weather2;
            this.day = Day;
            this.tempScore = TempScore;
            this.weatherScore = WeatherScore;
            this.dayScore = DayScore;
            this.totalScore = weatherScore + tempScore;
        }

        @Override
        public int compareTo(OneDay o){

            if(this.totalScore == o.totalScore){
                return this.dayScore - o.dayScore;
            }else{
                return this.totalScore - o.totalScore;
            }
        }

    }
    public static Map<Integer, Integer> getDayScore(){
        Map<Integer, Integer> m = new LinkedHashMap<Integer, Integer>();
        m.put(0,1); //월
        m.put(1,2); //화
        m.put(2,4); //수
        m.put(3,3); //목
        m.put(4,6); //금
        m.put(5,7); //토
        m.put(6,5); //일

        return m;
    }
    public static int [] solution(int [][] data){
        int [] answer = new int[2];
        Map<Integer, Integer> dayScores = getDayScore();
        int wScore, tScore, totalScore;
        int minScore = Integer.MAX_VALUE, maxScore = Integer.MIN_VALUE, maxScoreDay = -1, minScoreDay = -1;
        for(int i = 0; i < 7; i++){
            int [] today = data[i];
            wScore = 0;
            tScore = 20 - Math.abs(22 - today[2]);
            if(today[0] == 1 || today[0] == 2){
                wScore+= 20;
            }else if(today[0] == 3){
                wScore += 17;
            }else{
                wScore += 10;
            }
            if(today[1] == 1){
                wScore += 5;
            }else if(today[1] == 2){
                wScore += 14;
            }
            tScore = Math.max(tScore, 0);
            wScore = Math.min(20, wScore);
            totalScore = tScore + wScore;
            if(totalScore >= maxScore) {
                if (totalScore == maxScore && dayScores.get(i) > maxScoreDay) {
                    answer[0] = i;
                    maxScoreDay = dayScores.get(i);
                } else if (totalScore > maxScore) {
                    answer[0] = i;
                    maxScoreDay = dayScores.get(i);
                    maxScore = totalScore;
                }
            }
            if(totalScore <= minScore){
                if(today[0] == 4 || today[1] == 1 || today[2] >= 30 || today[2] <= 0){
                    if(totalScore == minScore && dayScores.get(i) > minScoreDay){
                        minScoreDay = dayScores.get(i);
                        answer[1] = i;
                    }else if(totalScore < minScore){
                        minScore = totalScore;
                        minScoreDay = dayScores.get(i);
                        answer[1] = i;
                    }
                }
            }
        }
        if(minScore == Integer.MAX_VALUE){
            answer[1] = -1;
        }
        return answer;
    }
    public static void main(String[] args){
//        int [][] data = new int [][] {{1,0,11},{3,1,15},{2,0,16},{4,0,17},{2,0,15},{2,1,14},{2,0,12}};
//        int [] answers = solution(data);
//        for(int answer : answers){
//            System.out.println(answer);
//        }
//        data = new int [][] {{4,0,12},{1,0,16},{3,0,18},{3,0,17},{2,0,15},{3,2,22},{2,1,17}};
//        answers = solution(data);
//        for(int answer : answers){
//            System.out.println(answer);
//        }
        int [][] data = new int [][] {{1, 0, 11}, {3, 1, 15}, {2, 0, 16}, {4, 0, 17}, {2, 0, 15}, {2, 1, 14}, {2, 0, 12}};
        int [] answers = solution(data);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
