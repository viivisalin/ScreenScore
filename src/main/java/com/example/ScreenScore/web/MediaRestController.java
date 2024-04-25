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

// Controller class handling RESTful request of Media entities
@Controller
public class MediaRestController {

    @Autowired
    private MediaRepository mediaRepository;

    // GET requests to /medias retrieves all media entities
    // Returns a list of media in JSON format
    @GetMapping("/medias")
    public @ResponseBody List<Media> mediaListRest() {
        return (List<Media>) mediaRepository.findAll();
    }

    // GET requests to /medias/{id} retrieves a media entity by a specific ID
    // Returns the media entity with the specified ID in JSON format
    @GetMapping("/medias/{id}")
    public @ResponseBody Optional<Media> findMediaRest (@PathVariable("id") Long mediaid) {
        return mediaRepository.findById(mediaid);
    }

    // POST requests to /medias to save a new media entity
    // Accepts media data in JSON format and returns the saved media in JSON format
    @PostMapping("/medias")
    public @ResponseBody Media saveMediaRest (@RequestBody Media media) {
        return mediaRepository.save(media);
    }
}
