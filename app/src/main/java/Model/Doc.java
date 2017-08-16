package Model;

/**
 * Created by janhu on 29.05.2017.
 */

public class Doc {

    private int lanr;
    private String firstName;
    private String lastName;
    private String speciality;
    private int imageId;

    public Doc(int lanr, String firstName, String lastName, String speciality, int imageId) {
        this.lanr = lanr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.imageId=imageId;
    }

    public Doc(int lanr, String firstName, String lastName, String speciality) {
        this.lanr = lanr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;

    }

    public Doc() {
    }

    public int getLanr() {
        return lanr;
    }

    public void setLanr(int lanr) {
        this.lanr = lanr;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
