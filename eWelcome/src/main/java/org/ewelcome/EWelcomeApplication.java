package org.ewelcome;

import org.ewelcome.entity.UserRole;
import org.ewelcome.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EWelcomeApplication {
    @Autowired
    UserRoleRepository userRoleRepository;
	public static void main(String[] args) {
		SpringApplication.run(EWelcomeApplication.class, args);
	}/*
        @Bean
        public CommandLineRunner run() throws Exception {
            return (String[] args) -> {
                UserRole user1 = new UserRole("John");
                UserRole user2 = new UserRole("Julie");
                userRoleRepository.save(user1);
                userRoleRepository.save(user2);
                //userRoleRepository.findAll().forEach(user -> System.out.println(user);
            };
        }*/
}
