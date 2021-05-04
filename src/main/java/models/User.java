package models;

public class User {
    private String id, name, username, email, phone, website;
    private Address address;
    private Company company;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }

    public Address getAddress() {
        return address;
    }


    static class Address {
        String street, suite, city, zipcode;
        Geo geo;

        public String getStreet() {
            return street;
        }

        public Geo getGeo() {
            return geo;
        }

        public String getSuite() {
            return suite;
        }

        public String getCity() {
            return city;
        }

        public String getZipcode() {
            return zipcode;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", suite='" + suite + '\'' +
                    ", city='" + city + '\'' +
                    ", zipcode='" + zipcode + '\'' +
                    ", geo=" + geo +
                    '}';
        }
    }

    static class Geo {
        String lat, lng;

        public String getLng() {
            return lng;
        }

        public String getLat() {
            return lat;
        }

        @Override
        public String toString() {
            return "Geo{" +
                    "lat='" + lat + '\'' +
                    ", lng='" + lng + '\'' +
                    '}';
        }
    }

    static class Company {
        String name, catchPhrase, bs;

        public String getName() {
            return name;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }

        public String getBs() {
            return bs;
        }

        @Override
        public String toString() {
            return "Company{" +
                    "name='" + name + '\'' +
                    ", catchPhrase='" + catchPhrase + '\'' +
                    ", bs='" + bs + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", address=" + address +
                ", company=" + company +
                '}';
    }
}