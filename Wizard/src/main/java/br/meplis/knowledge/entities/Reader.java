package br.meplis.knowledge.entities;

public class Reader extends Contact {

    // atributos do leitor

    private String name;
    private String cpf;
    private Address address;
    private Contact contact;


    //construtores e outros metodos
    public Reader(){

    }

    public Reader(String name, String cpf, Address address, Contact contact) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.contact = contact;
    }


    void updateReaders(String newName){
        this.name = newName;

    }

    // Dentro da classe Reader

    @Override
    public void updaterContacts(String newEmail, Long newPhoneNumber) {
        this.getContact().updaterContacts(newEmail, newPhoneNumber);
    }
    @Override
    void updaterAddress(String newStreet, String newCity, String newState, String newCountry){
        this.getAddress().updaterAddress(newStreet, newCity, newState,newCountry);

    }


    //Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
