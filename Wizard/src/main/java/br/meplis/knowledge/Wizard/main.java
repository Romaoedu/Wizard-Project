package br.meplis.knowledge.Wizard;

import br.meplis.knowledge.entities.Address;
import br.meplis.knowledge.entities.Contact;
import br.meplis.knowledge.entities.ManagerReaders;
import br.meplis.knowledge.entities.Reader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class main {

	static ManagerReaders maneger;


	public static void main(String[] args) {
		List<Reader> lista = new ArrayList<>();
		maneger = new ManagerReaders(lista);

		SpringApplication.run(main.class, args);
		startSystem();

		Scanner sc = new Scanner(System.in);
		int option;

		do {
			System.out.println("What would you like to do? \n");
			System.out.println("1) Display all existing readers ");
			System.out.println("2) Query for a reader ");
			System.out.println("3) Add a reader ");
			System.out.println("4) Remove a reader ");
			System.out.println("5) Updater a reader ");
			System.out.println("6) Exit ");


			option = sc.nextInt();

			switch (option) {

				case 1:
					lista.forEach(elemento-> System.out.println(elemento + "\n"));
					break;

				case 2:
					System.out.println("Enter the reader's CPF");
					String cpf = sc.next();
					Reader reader = maneger.searchReades(cpf);
					System.out.println(reader);
					break;

				case 3:
					System.out.println("Enter your Reader details");
					System.out.print("Name: ");
					String name = sc.next();
					System.out.print("CPF: ");
					String cpfUser = sc.next();
					System.out.print("Email: ");
					String email = sc.next();
					System.out.print("Phone Number: ");
					Long phoneNumber = sc.nextLong();
					System.out.print("Street: ");
					sc.nextLine();
					String street = sc.next();
					System.out.print("City: ");
					String city = sc.next();
					System.out.print("State: ");
					String state = sc.next();
					System.out.print("Country: ");
					String country = sc.next();
					Address address = new Address(street, city, state, country);
					Contact contact = new Contact(email, phoneNumber);
					Reader newReader = new Reader(name, cpfUser, address, contact);
					maneger.newReader(newReader);
					System.out.println("User added");
					break;

				case 4:
					System.out.println("Enter the CPF of the reader you want to remove");
					String cpfRemove = sc.next();
					maneger.removeReades(cpfRemove);
					System.out.println("User removed");
					break;

				case 5:
					System.out.println("Enter the CPF of the reader you want to updater");
					String updaterCpf = sc.next();
					Reader updateReader = maneger.searchReades(updaterCpf);

					if (updateReader !=null){
						System.out.println("Wich data do you want to updater?");

						System.out.println("1) Address");
						System.out.println("2) Contact");
						System.out.println("3) personal data");
						Integer integer = sc.nextInt();


						  if (integer == 1){
							System.out.println("Street: ");
							String newStreet = sc.next();
							sc.nextLine();
							System.out.println("City: ");
							String newCity = sc.next();
							  sc.nextLine();
							System.out.println("State: ");
							String newState = sc.next();
							System.out.println("Country: ");
							String newCountry = sc.next();
							maneger.updaterAddress(newStreet, updaterCpf, newCity, newState, newCountry);
							  System.out.println("updated data");
						}
						else if(integer == 2){
							System.out.println("Email: ");
							String newEmail = sc.next();
							System.out.println("Phone Number: ");
							Long newPhoneNumber = sc.nextLong();
							maneger.updaterContacts(newEmail, updaterCpf,newPhoneNumber);
							  System.out.println("updated data");
						}
						else if (integer == 3){
							System.out.println("Name: ");
							String newName = sc.next();
							System.out.println("CPF: ");
							String newCpfUser = sc.next();
							maneger.updateReader(newName, updaterCpf,newCpfUser);
							  System.out.println("updated data");
						}

					} else {
						System.out.println("invalid CPF");
					}

					break;
				case 6:
					System.out.println("leaving...");
					break;
				default:
					System.out.println("invalid option");

			}
		}while (option != 6);
			sc.close();
		}










	public static void startSystem(){

		Address endereco = new Address("Rua São Paulo", "Queimados", "Rio de Janeiro", "Brasil");
		Contact contato = new Contact("romaoedu@hotmail.com", 21979008134l);
		Reader leitor = new Reader("Eduardo", "05847975759", endereco, contato);
		maneger.newReader(leitor);

		Address endereco1 = new Address("Rua Cisplatina","NI", "Rio de Janeiro", "Brasil");
		Contact contato1 = new Contact("romaoeduu@gmail.com", 2197900845656l);
		Reader leitor1 = new Reader("Wallace", "05847975758", endereco1, contato1);
		maneger.newReader(leitor1);
	}

}
