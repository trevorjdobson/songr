package com.trevorjdobson.songr.controllers;

//import com.sun.org.apache.xpath.internal.operations.Mod;
import com.trevorjdobson.songr.models.Album;
import com.trevorjdobson.songr.models.AlbumRepository;
import com.trevorjdobson.songr.models.Song;
import com.trevorjdobson.songr.models.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Date;
import java.util.List;


@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @GetMapping("/albums")
    public String getAllAlbums(Model m){
        List<Album> albumsList = albumRepository.findAll();
        m.addAttribute("albums",albumsList);
        return "allAlbums";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(String title, String artist, int songCount, int length, String imageUrl){
        Album album = new Album(title,artist,songCount,length,imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }
    @GetMapping("/albums/{id}")
    public String getOneAlbum(@PathVariable long id, Model m) {
        Album a = albumRepository.findById(id).get();
        System.out.println(a);
        m.addAttribute("album", a);
        return "oneAlbum";
    }
    @PostMapping("/albums/{id}/songs")
    public RedirectView addSongToAlbum(@PathVariable long id, String title, int songLength, int trackNumber){
        System.out.println(id);
        Album a = albumRepository.getOne(id);
        System.out.println(a);
        for(Song song: a.getSongs()){
            if (song.getTitle()==title){
                return new RedirectView("/albums/" + id);
            }
        }
        Song song = new Song(title,songLength,trackNumber,a);
        songRepository.save(song);
        return new RedirectView("/albums/" + id);
    }


}
