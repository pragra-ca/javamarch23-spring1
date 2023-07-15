package com.example.guestbook;

import com.example.guestbook.conf.ApplicationConfig;
import com.example.guestbook.domain.Address;
import com.example.guestbook.domain.Guest;
import com.example.guestbook.service.GuestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;


@SpringBootApplication
public class GuestbookApplication {

    public static void main(String[] args) {
    ApplicationContext context=   SpringApplication.run(GuestbookApplication.class, args);
    GuestService guestService = context.getBean("guestService", GuestService.class);

    Guest guest = Guest.builder()
            .Id(101)
            .firstName("Subham")
            .lastName("Hirpara")
            .phoneNumber("28272727")
            .address("Hamilton")
            .build();
    guestService.createGuest(guest);
        System.out.println("guestService.getGuest() = " + guestService.getGuest());

    }

}
