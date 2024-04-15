package com.example.ScreenScore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ScreenScore.model.Media;
import com.example.ScreenScore.model.MediaRepository;

@Controller
public class MediaRestController {

    @Autowired
    private MediaRepository mediaRepository;

    @GetMapping("/medias")
    public @ResponseBody List<Media> mediaListRest() {
        return (List<Media>) mediaRepository.findAll();
    }

    @GetMapping("/medias/{id}")
    public @ResponseBody Optional<Media> findMediaRest (@PathVariable("id") Long mediaid) {
        return mediaRepository.findById(mediaid);
    }

    @PostMapping("/medias")
    public @ResponseBody Media saveMediaRest (@RequestBody Media media) {
        return mediaRepository.save(media);
    }
}
