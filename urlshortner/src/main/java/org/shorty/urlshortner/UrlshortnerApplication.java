package org.shorty.urlshortner;

import org.shorty.urlshortner.generator.TokenGenerator;
import org.shorty.urlshortner.generator.UIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UrlshortnerApplication {

	private static final TokenGenerator tokenGenerator = new TokenGenerator();

	public static void main(String[] args) {
		SpringApplication.run(UrlshortnerApplication.class, args);
	}
	@Bean
	public UIDGenerator uidGenerator(){
		return new UIDGenerator(tokenGenerator);
	}
}
