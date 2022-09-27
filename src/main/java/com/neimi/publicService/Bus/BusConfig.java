package com.neimi.publicService.Bus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class BusConfig {
    @Bean
    CommandLineRunner commandLineRunner(BusRepository busRepository){
      return args -> {
          Bus b1=new Bus(
                  "Costa brava - L1",
                  "Barcelona",
                  "Amazon",
                  false
          );
          Bus b2=new Bus(
                  "Road to Rome - T3",
                  "Rome",
                  "Amb",
                  true
          );
          Bus b3=new Bus(
                  "Sunny in the bus - S8",
                  "London",
                  "netflix",
                  false
          );
          busRepository.saveAll(List.of(b1,b2,b3));
      };
    }

}
