package edu.ifrs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import edu.ifrs.client.Catalog;
import edu.ifrs.model.Playlist;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/playlist")
public class PlaylistService {

    private ArrayList<Playlist> playlists = new ArrayList<>();

    @RestClient
    @Inject
    Catalog catalog;


    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Playlist> createPlaylist(@FormParam("name") String name, @FormParam("owner") String owner) {
        Playlist playlist = new Playlist(name, owner);
        playlists.add(playlist);
        return playlists;
    }

    @POST
    @Path("/addMusic")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Playlist addMusic(@FormParam("playlistName") String playlistName, @FormParam("musicName") String musicName ) {

        for (Playlist playlist : playlists) {
            if (playlist.getName().equals(playlistName)) {
                playlist.addMusic(catalog.getMusic(musicName));
                return playlist;
            }
        }
        
        return null;

    }


}
