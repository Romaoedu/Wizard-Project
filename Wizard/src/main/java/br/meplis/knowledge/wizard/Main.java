package br.meplis.knowledge.wizard;

import br.meplis.knowledge.entities.ManagerReaders;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;

@SpringBootApplication(scanBasePackages = {"br.meplis.knowledge.controllers","br.meplis.knowledge.entities", "br.meplis.knowledge.wizard"} )
public class Main {


	@Bean
	@Scope("singleton")
	public  ManagerReaders getManeger() {
		return new ManagerReaders(new ArrayList<>());
	}

	public static void main(String[] args) {
	/*	List<Reader> lista = new ArrayList<>();*/


		SpringApplication.run(Main.class, args);

	}
}
