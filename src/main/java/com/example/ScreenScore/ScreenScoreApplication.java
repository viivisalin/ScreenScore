package com.example.ScreenScore;

import org.hibernate.type.descriptor.jdbc.NCharJdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ScreenScore.model.Genre;
import com.example.ScreenScore.model.GenreRepository;
import com.example.ScreenScore.model.Media;
import com.example.ScreenScore.model.MediaRepository;
import com.example.ScreenScore.model.MediaType;
import com.example.ScreenScore.model.MediaTypeReposity;

@SpringBootApplication
public class ScreenScoreApplication {
	private static final Logger log = LoggerFactory.getLogger(ScreenScoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ScreenScoreApplication.class, args);
	}

	// CommandLineRunner generates a couple movies and shows to the list
	// it also generates some genres and the two media types that are used

	@Bean
	public CommandLineRunner mediaDemo(MediaRepository mRepository, GenreRepository gRepository, MediaTypeReposity mTypeReposity) {
		return (args) -> {
			log.info("save some sample genres");
			Genre comedy = new Genre("Comedy");
			gRepository.save(comedy);
			Genre adventure = new Genre("Adventure");
			gRepository.save(adventure);
			Genre fantasy = new Genre("Fantasy");
			gRepository.save(fantasy);

			log.info("media types");
			MediaType movie = new MediaType("Movie");
			mTypeReposity.save(movie);
			MediaType show = new MediaType("Show");
			mTypeReposity.save(show);

			mRepository.save(new Media(movie, "The Hobbit - Desolation of Smaug", "Peter Jackson", 161, 2013, fantasy, "The dwarbes, along with Bilbo Baggins and Gandalf the Gray, continue their quest to reclaim Erebor, their homeland, from Smaug. Bilbo Baggins is in possession of a mysterious and magical ring.", 5));
			mRepository.save(new Media(show, "Bones", "Hart Hanson", 40, 2007, comedy, "F.B.I. Special Agent Seeley Booth teams up with the Jeffersonian's top anthropologist, Dr. Temperance Brennan, to investigate cases where all that's left of the victims are their bones.", 4));
			mRepository.save(new Media(movie, "Barbie", "Greta Gerwig", 114, 2023, adventure, "Barbie and Ken are having the time of their lives in the colorful and seemingly perfect wolrd of Barbie Land. However, when they get a change to go to the real world, they soon discover the joys and perils of living among humans.", 5));
	
			log.info("fetch all medias");
			for (Media media : mRepository.findAll()) {
				log.info(media.toString());
			}
			
		};
	}
}
