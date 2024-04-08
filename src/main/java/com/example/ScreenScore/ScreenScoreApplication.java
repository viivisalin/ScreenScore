package com.example.ScreenScore;

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
import com.example.ScreenScore.model.MediaTypeReposity;

@SpringBootApplication
public class ScreenScoreApplication {
	private static final Logger log = LoggerFactory.getLogger(ScreenScoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ScreenScoreApplication.class, args);
	}

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

			mRepository.save(new Media("The Hobbit - Desolation of Smaug", "Peter Jackson", 161, 2013, "The dwarbes, along with Bilbo Baggins and Gandalf the Gray, continue their quest to reclaim Erebor, their homeland, from Smaug. Bilbo Baggins is in possession of a mysterious and magical ring."));
	
			log.info("fetch all medias");
			for (Media media : mRepository.findAll()) {
				log.info(media.toString());
			}
			
		};
	}
}
