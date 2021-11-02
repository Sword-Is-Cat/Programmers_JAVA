package level3.ex베스트앨범;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
	public int[] solution(String[] genres, int[] plays) {

		Map<String, Genre> genreMap = new HashMap<>();
		Genre genre = null;

		for (int i = 0; i < genres.length; i++) {
			if (genreMap.containsKey(genres[i])) {
				genre = genreMap.get(genres[i]);
			} else {
				genre = new Genre();
				genreMap.put(genres[i], genre);
			}
			genre.addSong(new Song(i, plays[i]));
		}

		PriorityQueue<Genre> que = new PriorityQueue<>((a, b) -> (b.played - a.played));

		for (String key : genreMap.keySet())
			que.add(genreMap.get(key));

		List<Integer> list = new ArrayList<>();

		while (!que.isEmpty()) {
			genre = que.poll();
			list.add(genre.songs.poll().index);
			if (!genre.songs.isEmpty())
				list.add(genre.songs.poll().index);
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = list.get(i);
		return answer;
	}
}

class Song {
	int index;
	int played;

	public Song(int index, int played) {
		super();
		this.index = index;
		this.played = played;
	}
}

class Genre {
	int played;
	PriorityQueue<Song> songs = new PriorityQueue<>((a, b) -> (b.played - a.played));

	public Genre() {
		super();
		this.played = 0;
	}

	public void addSong(Song song) {
		this.played += song.played;
		songs.add(song);
	}
}