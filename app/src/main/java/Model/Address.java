package Model;

/**
 * Created by janhu on 18.08.2017.
 */

public class Address {
    private int id;
    private String street;
    private String number;
    private String zip;
    private String city;
    private Country country;

    public Address(int id, String street, String number, String zip, String city, Country country) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.city = city;
        this.country = country;
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String toString() {
        return  street + " " + number + "\n" +
                zip + " " + city;
    }
}
