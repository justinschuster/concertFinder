package com.jschuster.concertFinder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConcertFinderApplication {

  private static final Logger log = LoggerFactory.getLogger(ConcertFinderApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(ConcertFinderApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  @Bean
  public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
    return args -> {
      Concert concert = restTemplate.getForObject(
          "https://app.ticketmaster.com/discovery/v2/events.json?countryCode=US&apikey=GtuNfy1E2mG7y7pHSpg14LW64VlZROLD",
          Concert.class);
      log.info(concert.toString());
    };
  }
}
