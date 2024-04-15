package com.example.ScreenScore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ScreenScore.model.Genre;
import com.example.ScreenScore.model.GenreRepository;
import com.example.ScreenScore.model.Media;
import com.example.ScreenScore.model.MediaRepository;
import com.example.ScreenScore.model.MediaType;
import com.example.ScreenScore.model.MediaTypeReposity;

@Controller
public class MediaController {

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private MediaTypeReposity mediaTypeReposity;

    @GetMapping("/medialist")
    public String MediaList(Model model) {
        model.addAttribute("medias", mediaRepository.findAll());
        return "medialist";
    }

    @GetMapping("/showaddmedia")
    public String showAddMedia(Model model) {
        model.addAttribute("media", new Media());
        return "addmedia";
    }

    @PostMapping("/addmedia")
    public String addMedia(@ModelAttribute Media media) {
        Genre genre = media.getGenre();
        if (genre != null && genre.getGenreid() == null) {
            genreRepository.save(genre);
        }

        MediaType mediaType = media.getMediaType();
        if (mediaType != null && mediaType.getMtypeid() == null) {
            mediaTypeReposity.save(mediaType);
        }
        
        mediaRepository.save(media);
        return "redirect:/medialist";
    }

    @GetMapping("/medialist/edit/{id}")
    public String editMedia(@PathVariable("id") Long mediaid, Model model) {
        Media existingMedia = mediaRepository.findById(mediaid).orElse(null);
        if (existingMedia != null) {
            model.addAttribute("media", existingMedia);
            return "editMedia";
        } else {
            return "error";
        }
    }

    @PostMapping("/editmedia")
    public String editMedia(@ModelAttribute("media") Media media) {
        Genre genre = media.getGenre();
        if (genre != null && genre.getGenreid() == null) {
            genreRepository.save(genre);
        }

        MediaType mediaType = media.getMediaType();
        if (mediaType != null && mediaType.getMtypeid() == null) {
            mediaTypeReposity.save(mediaType);
        }
        mediaRepository.save(media);
        return "redirect:/medialist";
    }

    @GetMapping("/medialist/delete/{id}")
    public String deleteMedia(@PathVariable("id") Long mediaid) {
        mediaRepository.deleteById(mediaid);
        return "redirect:/medialist";
    }

}
