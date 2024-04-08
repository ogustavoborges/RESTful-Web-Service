package edu.ifrs.model;

import java.util.ArrayList;
import java.util.List;


public class Playlist {
    
    private String name;
    private String owner;
    private List<Music> musics = new ArrayList<>();

    public Playlist() {
    }

    public Playlist(String name,  String owner) {
        this.name = name;
        this.owner = owner;
    }

    public List<Music> addMusic(Music list) {
        musics.add(list);
        return musics;
    }

    
    public List<Music> getMusics() {
        return musics;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }


}
