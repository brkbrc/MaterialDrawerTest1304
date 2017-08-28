package Model;

import android.support.annotation.NonNull;

import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

import java.util.List;

/**
 * Created by janhu on 29.05.2017.
 */

public class Doc implements SortedListAdapter.ViewModel{

    private int id;
    private char gender;
    private String title;
    private String firstName;
    private String lastName;
    private Address address;
    private Speciality speciality;
    private List<Language> languageList;
    private String imageUrl;

    public Doc(int id, char gender, String title, String firstName, String lastName, Address address, Speciality speciality, List<Language> languageList, String imageUrl) {
        this.id = id;
        this.gender = gender;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.speciality = speciality;
        this.languageList = languageList;
        this.imageUrl = imageUrl;
    }

    public Doc(int id, char gender, String title, String firstName, String lastName, Address address, Speciality speciality, List<Language> languageList) {
        this.id = id;
        this.gender = gender;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.speciality = speciality;
        this.languageList = languageList;
    }

    public Doc() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Address getAddress() {
        return address;
    }

    public String getStreet() {
        return getAddress().getStreet();
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public List<Language> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<Language> languageList) {
        this.languageList = languageList;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public <T> boolean isSameModelAs(@NonNull T t) {
        return false;
    }

    @Override
    public <T> boolean isContentTheSameAs(@NonNull T t) {
        return false;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doc model = (Doc) o;

        if (id != model.getId()) return false;
        return firstName != null ? firstName.equals(model.getFirstName()) : model.getFirstName() == null;
    }



    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }
}
