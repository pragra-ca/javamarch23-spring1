package com.example.guestbook.conf;

import com.example.guestbook.domain.Guest;
import com.example.guestbook.service.GuestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:guestapp.properties")
public class ApplicationConfig {



    @Bean(name = "guest")
    @Profile("dev")
    public Guest guest(@Value("${guest.id}") int id,
                       @Value("${guest.firstName}") String firstName,
                       @Value("${guest.lastName}") String lastName,
                       @Value("${guest.phone}") String phone) {
        return Guest.builder()
                .Id(id)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phone)
                .build();
    }

    @Profile("prod")
    @Bean(name = "guest")
    public Guest guest2(@Value("${guest.id}") int id,
                       @Value("${guest.firstName}") String firstName,
                       @Value("${guest.lastName}") String lastName,
                       @Value("${guest.phone}") String phone) {
        return Guest.builder()
                .Id(id)
                .firstName("****ATIN****")
                .lastName(lastName)
                .phoneNumber(phone)
                .build();
    }


    @Bean
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:h2:./appdb");
        builder.username("sa");
        builder.password("");
        return builder.build();
    }
}
