package br.meplis.knowledge.entities;

import java.util.Iterator;
import java.util.List;

public class ManagerReaders {

    private List<Reader> listOfReaders;


    //construtor
    public ManagerReaders() {
    }

    public ManagerReaders(List<Reader> listOfReaders) {
        this.listOfReaders = listOfReaders;

    }

    //pesquisa de leitor
    public Reader searchReades(String cpf) {
        for (Reader reader : listOfReaders
        ) {
            if (reader.getCpf().equals(cpf)){
                return reader;
            }
        }
        return null;
    }

    //adiciona leitor
    public void newReader(Reader newReader) {
        listOfReaders.add(newReader);
    }

    //removo leitor
    public boolean removeReades(String cpf) {
        // Iterator vai percorrer a lista de readers
        Iterator<Reader> iterator = listOfReaders.iterator();
        // Vai adicionar o reader na variavel iterator
        while (iterator.hasNext()) {
            Reader reader = iterator.next();

            if (reader.getCpf().equals(cpf)){
                iterator.remove();

            }

        }


        return true;
    }

    //Remover todos os leitores da lista

    public void clear(){
        this.listOfReaders.clear();
    }

    //Alterar dados dos clientes


    public Reader updateReader(String newName, String cpf, String newCpf){
        Reader reader = searchReades(cpf);
         if (reader != null){
             reader.updateReaders(newName, newCpf);
         }
        return reader;
    }

    public Reader updaterContacts (String newEmail, String cpf, Long newPhoneNumber){
        Reader reader = searchReades(cpf);
        if (reader != null){
            reader.updaterContacts(newEmail,newPhoneNumber);
        }

        return reader;
    }

    public Reader updaterAddress (String newStreet,String cpf, String newCity, String newState, String newCountry){
        Reader reader = searchReades(cpf);
        if (reader != null){
            reader.updaterAddress(newStreet, newCity,newState, newCountry );
        }
        return reader;
    }
}