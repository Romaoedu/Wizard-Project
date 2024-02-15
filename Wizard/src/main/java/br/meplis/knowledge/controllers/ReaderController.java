package br.meplis.knowledge.controllers;

import br.meplis.knowledge.entities.ManagerReaders;
import br.meplis.knowledge.entities.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/readers")
public class ReaderController {

    @Autowired
    private ManagerReaders manReaders;
    @GetMapping()
    public Reader searchReader(@RequestParam String cpf) {
        return manReaders.searchReades(cpf);
    }
    @PostMapping()
    public void create(@RequestBody Reader reader){
        manReaders.newReader(reader);
    }
    @PutMapping()
    public Reader updateReader(@RequestParam String cpf,@RequestBody Reader updateReader) {

        if (!cpf.equals(updateReader.getCpf())) {
            throw new IllegalArgumentException("Contato não encontrado com o Cpf fornecido: " + cpf);
        }
        Reader reader = manReaders.searchReades(cpf);
        reader.setName(updateReader.getName());
        reader.setEmail(updateReader.getEmail());
        reader.setPhoneNumber(updateReader.getPhoneNumber());
        reader.setCity(updateReader.getCity());
        reader.setCountry(updateReader.getCountry());
        reader.setState(updateReader.getState());
        reader.setStreet(updateReader.getStreet());
        return reader;
    }
    @DeleteMapping
    public boolean deleteReader(@RequestParam String cpf ){
       return manReaders.removeReader(cpf);
    }
}
