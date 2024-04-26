package com.example.ScreenScore;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.ScreenScore.model.Genre;
import com.example.ScreenScore.model.GenreRepository;
import com.example.ScreenScore.model.Media;
import com.example.ScreenScore.model.MediaRepository;
import com.example.ScreenScore.model.MediaType;
import com.example.ScreenScore.model.MediaTypeReposity;

@DataJpaTest
public class RepositoryTests {

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private MediaTypeReposity mediaTypeReposity;

    @Test
    public void createNewGenre() {
        Genre genre = new Genre("Reality Tv");
			genreRepository.save(genre);
            assertThat(genre.getName()).isNotBlank();
    }

    @Test
    public void createNewMediaType() {
        MediaType mediaType = new MediaType("Mini-series");
			mediaTypeReposity.save(mediaType);
            assertThat(mediaType.getTypeName()).isNotBlank();
    }

    @Test
    public void createMedia() {
        Media media = new Media(null, "Black Mirror", "Charlie Brooker", 60, 2011, null, "Featuring stand-alone dramas -- sharp, suspenseful, satirical tales that explore techno-paranoia -- Black Mirror is a contemporary reworking of The Twilight Zone with stories that tap into the collective unease about the modern world.", 4);
        mediaRepository.save(media);
        assertThat(media.getTitle()).isNotBlank();
    }

    @Test
    public void searchMedia() {
        List<Media> medias = mediaRepository.findByTitle("Bones");

        assertThat(medias).hasSize(1);
        assertThat(medias.get(0).getDirector()).isEqualTo("Hart Hanson");
    }
}
