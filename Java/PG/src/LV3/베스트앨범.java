package LV3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 베스트앨범 {
    static Map<String, Integer> m;
    static class Song implements Comparable<Song>{
        String genre;
        int play, idx;

        Song(String a, int b, int c){
            this.genre = a;
            this.play = b;
            this.idx = c;
        }
        public int compareTo(Song s){
            if(m.get(this.genre).equals(m.get(s.genre))){
                if(this.play != s.play){
                    return this.idx - s.idx;
                }else{
                    return s.play - this.play;
                }
            }else{
                return m.get(s.genre) - m.get(this.genre);
            }
        }
    }
    public static int [] solution(String [] genres, int [] plays){
        PriorityQueue<Song> pq = new PriorityQueue<Song>();
        m = new LinkedHashMap<String, Integer>();
        int n = genres.length;
        int [] answer = new int[n];
        for(int i = 0 ; i < n; i++){
            String genre = genres[i];
            int play = plays[i];
            if(m.containsKey(genre)){
                m.replace(genre, m.get(genre)+play);
            }else{
                m.put(genre, play);
            }
            pq.add(new Song(genre, play, i));
        }
        for(int i = 0; i < n; i++){
            Song s = pq.poll();
            answer[s.idx]=  i;
        }
        return answer;
    }
    public static void main(String[] args){
        String[] genres = new String [] {"classic", "pop", "classic", "classic", "pop"};
        int [] plays = new int [] {500, 600, 150, 800, 2500};
        int [] answers = solution(genres, plays);
        for(int answer : answers){
            System.out.println(answer);
        }
    }
}
