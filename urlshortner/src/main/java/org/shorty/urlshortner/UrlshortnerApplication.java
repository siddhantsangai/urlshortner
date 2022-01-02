package org.shorty.urlshortner;

import org.shorty.urlshortner.generator.TokenGenerator;
import org.shorty.urlshortner.generator.UIDGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UrlshortnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlshortnerApplication.class, args);
		TokenGenerator tg=new TokenGenerator();
		tg.setCurrentCounter(1);
		tg.setOffset(10);
		UIDGenerator u=new UIDGenerator(tg);
		System.out.println(u.generate());
		System.out.println(u.reverse("fJyb"));
	}
}
