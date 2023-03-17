import java.util.*;

class Solution {
    static class Song {
        String genre;
        int play;
        
        public Song(String genre, int play) {
            this.genre = genre;
            this.play = play;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < plays.length; i++)
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        List<String> popular_genre = new ArrayList<>(map.keySet());
        Collections.sort(popular_genre, (o1, o2) -> map.get(o2) - map.get(o1));
        Map<Integer, Song> map2 = new HashMap<>();
        for (int i = 0; i < plays.length; i++)
            map2.put(i, new Song(genres[i], plays[i]));
        List<Integer> popular_song = new ArrayList<>(map2.keySet());
        Collections.sort(popular_song, (o1, o2) -> map2.get(o2).play - map2.get(o1).play);
        
        for (int i = 0; i < popular_genre.size(); i++) {
            String genre = popular_genre.get(i);
            int cnt = 0;
            for (Integer j : popular_song) {
                if (cnt == 2)
                    break;
                if (map2.get(j).genre.equals(genre)) {
                    list.add(j);
                    cnt++;
                }
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
}