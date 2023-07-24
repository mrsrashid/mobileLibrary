package com.example.libraryprogram;

public class DataModel {
    // string variables for our name and job
    private int userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String gender;

    public DataModel(int userId, String firstName, String lastName, String phoneNumber,
                     String email, String address, String gender) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.gender = gender;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
