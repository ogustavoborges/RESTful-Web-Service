package edu.ifrs;

import java.util.ArrayList;
import java.util.List;

import edu.ifrs.model.Music;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/music")
public class CatalogService {

    private ArrayList<Music> musics = new ArrayList<>();

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Music> addMusic(@FormParam("artist") String artist, @FormParam("title") String title) { 
        Music music = new Music(artist, title);
        musics.add(music);
        return musics;
    }

    @GET
    @Path("/get/{title}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Music getMusic(@PathParam("title") String title){
        for (Music music : musics) {
            if (music.getTitle().equals(title)) {
                return music;
            }
        }
        return null;
    }

}
