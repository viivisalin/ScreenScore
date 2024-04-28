package com.example.ScreenScore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ScreenScore.model.Genre;
import com.example.ScreenScore.model.GenreRepository;
import com.example.ScreenScore.model.Media;
import com.example.ScreenScore.model.MediaRepository;
import com.example.ScreenScore.model.MediaType;
import com.example.ScreenScore.model.MediaTypeReposity;

// Controller class handling HTTP request of Media entities
@Controller
public class MediaController {

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private MediaTypeReposity mediaTypeReposity;

    // Handles GET requests to /medialist
    // Retrieves the list of medias and returns the "medialist" view
    @GetMapping("/medialist")
    public String MediaList(Model model) {
        model.addAttribute("medias", mediaRepository.findAll());
        return "medialist";
    }

    // Handles GET requests to /showaddmedia
    // Adds new Media object and returns the "addmedia" view
    @GetMapping("/showaddmedia")
    public String showAddMedia(Model model) {
        model.addAttribute("media", new Media());
        return "addmedia";
    }

    // Handles POST requests to /addmedia
    // Saves a new Media entity to the database
    @PostMapping("/addmedia")
    public String addMedia(@ModelAttribute Media media) {
        // Gets the genre and media type from the media object
        Genre genre = media.getGenre();
        // If the genre is not null, it gets saved into the database
        if (genre != null && genre.getGenreid() == null) {
            genreRepository.save(genre);
        }

        // If the media type is not null, it gets saved into the database
        MediaType mediaType = media.getMediaType();
        if (mediaType != null && mediaType.getMtypeid() == null) {
            mediaTypeReposity.save(mediaType);
        }
        
        // Saves the media objects to the database
        mediaRepository.save(media);
        // Redirects to the medialist page
        return "redirect:/medialist";
    }

    // Handles the GET requests to /medialist/edit/{id} for editing specific media
    // Retrieves the media with the specific ID and returns the "editMedia" view
    // If media with specific ID is not found, returns "error"
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

    // Handles POST requests to /editmedia
    // Saves the updated media entity to the database

    @PostMapping("/editmedia")
    public String editMedia(@ModelAttribute("media") Media media) {
        // Gets the genre and media type from the media object
        Genre genre = media.getGenre();
        // If the genre is not null, it gets saved into the database
        if (genre != null && genre.getGenreid() == null) {
            genreRepository.save(genre);
        }

        // If the media type is not null, it gets saved into the database
        MediaType mediaType = media.getMediaType();
        if (mediaType != null && mediaType.getMtypeid() == null) {
            mediaTypeReposity.save(mediaType);
        }

        // Saves changes to the database
        mediaRepository.save(media);
        // Redirects to the medialist page
        return "redirect:/medialist";
    }

    // Handles the GET requests to /medialist/delete/{id} for deleting specific media
    // Deletes the media with the specific ID and redirects to "medialist" view
    @GetMapping("/medialist/delete/{id}")
    public String deleteMedia(@PathVariable("id") Long mediaid) {
        mediaRepository.deleteById(mediaid);
        return "redirect:/medialist";
    }

    @RequestMapping(value="/login")
	public String login() {
		return "login";
	}    
}
