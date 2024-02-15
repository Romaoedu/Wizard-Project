package br.meplis.knowledge.entities;

public class Contact extends Address {

    //atributos da minha classe
   private String email;
   private Long phoneNumber;
   private Address address;

   //construtores
    public Contact(){

    }

    public Contact(String email, Long phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }




    //alterar dados

    void updaterContacts(String newEmail, Long newPhoneNumber){
        this.email = newEmail;
        this.phoneNumber = newPhoneNumber;

    }

    // Getters and setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
