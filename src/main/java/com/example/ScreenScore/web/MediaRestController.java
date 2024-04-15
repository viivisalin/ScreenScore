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

    @GetMapping("/books")
    public @ResponseBody List<Media> bookListRest() {
        return (List<Media>) mediaRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Media> findBookRest (@PathVariable("id") Long bookId) {
        return mediaRepository.findById(bookId);
    }

    @PostMapping("/books")
    public @ResponseBody Media saveBookRest (@RequestBody Media media) {
        return mediaRepository.save(media);
    }
}
