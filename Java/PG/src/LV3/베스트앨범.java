package LV3;

import java.util.ArrayList;
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
                if(this.play == s.play){
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
        ArrayList<Song> al = new ArrayList<Song>();
        m = new LinkedHashMap<String, Integer>();
        Map<String, Integer> counts = new LinkedHashMap<String, Integer>();
        int n = genres.length;
        for(int i = 0 ; i < n; i++){
            String genre = genres[i];
            int play = plays[i];
            if(m.containsKey(genre)){
                m.replace(genre, m.get(genre)+play);
            }else{
                counts.put(genre, 0);
                m.put(genre, play);
            }
            pq.add(new Song(genre, play, i));
        }

        for(int i = 0; i < n; i++){
            Song s = pq.poll();
            if(counts.get(s.genre) == 2){
                continue;
            }else{
                al.add(s);
                counts.replace(s.genre, counts.get(s.genre)+1);
            }
        }
        int [] answer = new int[al.size()];
        for(int i = 0 ; i < al.size(); i++){
            Song now= al.get(i);
            answer[i] = now.idx;
        }
        return answer;
    }
    public static void main(String[] args){
        String[] genres = new String [] {"classic", "pop", "classic", "classic", "pop"};
        int [] plays = new int [] {500, 600, 150, 800, 2500};
        genres = new String []{"classic", "pop", "classic", "classic", "pop", "test"};
        plays = new int [] {500, 600, 150, 800, 2500, 100};
        genres = new String [] {"A", "A", "B", "A", "B", "B", "A", "A", "A", "A"};
        plays = new int [] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        genres = new String [] {"classic"};
        plays = new int [] {500};
        genres = new String [] {"classic", "pop", "classic", "classic", "pop"};
        plays = new int [] {500, 600, 150, 800, 2500};
        genres = new String [] {"A","A","A","A","A","A","A","A","A","A","B"};
        plays = new int [] {0,1,2,3,4,9,6,7,8,9,1};
        int [] answers = solution(genres, plays);

        for(int answer : answers){
            System.out.println(answer);
        }

//        answers = solution(genres, plays);
//        for(int answer : answers){
//            System.out.println(answer);
//        }
//
//        answers = solution(genres, plays);
//        for(int answer : answers){
//            System.out.println(answer);
//        }
    }
}
