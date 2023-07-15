package com.example.guestbook.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    private int Id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

}
