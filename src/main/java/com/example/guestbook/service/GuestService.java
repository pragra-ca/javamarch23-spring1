package com.example.guestbook.service;

import com.example.guestbook.domain.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class GuestService {

    private JdbcTemplate template;

    public GuestService(JdbcTemplate template) {
        this.template = template;
    }

    public int createGuest(Guest guest){
        String sql  = "INSERT INTO GUESTS VALUES( ?, ?, ?, ?, ? )";
        int i =  template.update(sql, guest.getId(),
                guest.getFirstName(),
                guest.getLastName(),
                guest.getPhoneNumber(),
                guest.getAddress()
        );
        return  i;
    }

    public Guest update(Guest guest){
        return null;
    }

    public Guest deletGuest(int id){
        return null;
    }

    public Guest getGuest(int id){
        return null;
    }

    public List<Guest> getGuest(){
        return this.template.query("SELECT * FROM GUESTS", new BeanPropertyRowMapper<>(Guest.class));

    }





}
