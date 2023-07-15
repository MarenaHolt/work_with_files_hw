package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Character {
    private String firstName;
    private String lastName;
    private String city;
    private String[] books;
    @JsonProperty("countBooks")
    private int countBooks;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String[] getBooks() {
        return books;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }

    public Integer getCount() {
        return countBooks;
    }

    public void setCount(Integer countBooks) {
        this.countBooks = countBooks;
    }

    public Character() {}

    public Character(String firstName, String lastName, String city, String[] books, Integer countBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.books = books;
        this.countBooks = countBooks;
    }
}
