package com.ktxdev.memoics.config;

import com.ktxdev.memoics.model.User;
import com.ktxdev.memoics.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {

    @Bean
    public CommandLineRunner usersInitializationBean(UserRepository userRepository,
                                                     PasswordEncoder passwordEncoder,
                                                     ApplicationProperties props) {
        return args -> {
            User user = User.builder()
                    .fullName("System Admin")
                    .username("admin")
                    .password(passwordEncoder.encode(props.getPassword()))
                    .build();

            userRepository.save(user);
        };
    }
}
