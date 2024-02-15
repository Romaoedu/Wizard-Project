package br.meplis.knowledge.entities;

public class Address {

    //atributos da minha classe
    private String street;
    private String city;
    private String state;
    private String country;




    //Construtores
    public Address(){

    }

    public Address (String street, String city, String state, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    //alterar dados

    void updaterAddress(String newStreet, String newCity, String newState, String newCountry){
        this.street = newStreet;
        this.city = newCity;
        this.state= newState;
        this.country = newCountry;

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
