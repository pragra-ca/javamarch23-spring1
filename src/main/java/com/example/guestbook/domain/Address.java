package com.example.guestbook.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private int addressId;
    private String city;
    private String postalCode;
}
