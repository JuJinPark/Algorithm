package main.java.ETC;



import java.util.*;

public class BestAlbumProblem {
    public int[] solution(String[] genres, int[] plays) {

        Albums albums = new Albums();
        for (int i = 0; i < genres.length; i++) {
            albums.add(genres[i],new Song(i,plays[i]));
        }
       return albums.getBestAlbums();
    }
}

class Albums {

    private Map<String,Album> genereMap = new HashMap();

    private final int MAX_SONG_NUM_PER_ALBUM=2;

    public void add(String genere, Song song) {
        Album album = genereMap.get(genere);
        if (album == null) {
            genereMap.put(genere, new Album(song));
        } else {
            album.push(song);
        }
    }

    public int[] getBestAlbums() {
        ArrayList<Integer> bestSongsIdx = new ArrayList<>();
        ArrayList<Album> albums = new ArrayList<>(genereMap.values());
        Collections.sort(albums,new AlbumComparator());
        for (Album album : albums) {
           for(int i=0;i<MAX_SONG_NUM_PER_ALBUM;i++){
               Song bestSong = album.getBestSong();
               if (bestSong != null) {
                   bestSongsIdx.add(bestSong.getIdx());
               }
           }
        }
        return bestSongsIdx.stream().mapToInt(i->i).toArray();
    }
}

class Album {

    private PriorityQueue<Song> songs = new PriorityQueue<>(new SongCompartor());

    private int totalPlayTimes =0;

    public Album(Song song) {
        push(song);
    }

    public void push(Song song){
        songs.offer(song);
        totalPlayTimes+=song.getPlayTimes();
    }

    public int getTotalPlayTimes() {
        return totalPlayTimes;
    }

    public Song getBestSong() {
        if(this.songs.isEmpty()){
            return null;
        }
        return this.songs.poll();
    }
}

class Song {
    private int idx;
    private int playTimes;

    public Song(int idx, int playTimes) {
        this.idx = idx;
        this.playTimes = playTimes;
    }

    public int getIdx() {
        return idx;
    }

    public int getPlayTimes() {
        return playTimes;
    }
}

class SongCompartor  implements Comparator<Song> {
    public int compare(Song a, Song b)
    {
        int compare = Integer.compare(a.getPlayTimes(), b.getPlayTimes())*-1;
        if(compare==0){
            return Integer.compare(a.getIdx(), b.getIdx());
        }
        return compare;
    }
}

class AlbumComparator implements Comparator<Album> {
    public int compare(Album a, Album b)
    {
        return Integer.compare(a.getTotalPlayTimes(), b.getTotalPlayTimes())*-1;
    }
}


