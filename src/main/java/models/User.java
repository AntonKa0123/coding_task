package models;

import lombok.Data;

@Data
public class User {
    private String id, name, username, email, phone, website;
    private Address address;
    private Company company;

    @Data
    static class Address {
        String street, suite, city, zipcode;
        Geo geo;
    }

    @Data
    static class Geo {
        String lat, lng;
    }

    @Data
    static class Company {
        String name, catchPhrase, bs;
    }
}