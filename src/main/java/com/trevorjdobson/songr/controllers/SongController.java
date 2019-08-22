package com.trevorjdobson.songr.controllers;


import com.trevorjdobson.songr.models.Song;
import com.trevorjdobson.songr.models.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;

    @GetMapping("/songs")
    public String getAllSongs(Model m){
        List<Song> songsList = songRepository.findAll();
        m.addAttribute("songs",songsList);
        return "allSongs";

    }
}
