package br.meplis.knowledge.wizard;

import br.meplis.knowledge.entities.Address;
import br.meplis.knowledge.entities.Contact;
import br.meplis.knowledge.entities.ManagerReaders;
import br.meplis.knowledge.entities.Reader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ManagerReadersTest {

   private ManagerReaders manReaders;
   private List<Reader> listOfReaders = new ArrayList<>();
   private String cpfReader1 = "05847975759";
   private String cpfReader2 = "01234567890";

   @Before
   public void setUP(){

       /* =============== Montagem do cenário ===============*/

       listOfReaders = new ArrayList<>();
       manReaders = new ManagerReaders(listOfReaders);

       Address address1 = new Address("Rua r", "NY", "Rj", "BR" );
       Contact contact1 = new Contact("romaoeduu@gmail.com", 21979008134l);
       Reader reader1 = new Reader("Eduardo", "05847975759", address1, contact1);
       manReaders.newReader(reader1);

       Address address2 = new Address("Rua sem saída", "CG", "MS", "BR" );
       Contact contact2 = new Contact("wnascimento@meplis.com", 2545478171l);
       Reader reader2 =   new Reader("Wallace", "01234567890", address2,contact2);
       manReaders.newReader(reader2);


   }

   @After

    public void tearDown(){
       manReaders.clear();
   }

   @Test
    public void testSearchReader(){

       Reader reader = manReaders.searchReades("05847975759");
       assertThat(reader.getCpf(), is("05847975759"));

   }
   @Test
   public void testRemoveReader(){
       boolean removeReader = manReaders.removeReader("01234567890");

       assertThat(listOfReaders.size(), is(1));
       assertNull(manReaders.searchReades("01234567890"));
   }
   @Test
   public void addReader(){
       Address address3 = new Address("Rua dos bobos", "bobolandia", "RJ", "BR" );
       Contact contact3 = new Contact("bobo@meplis.com", 254565476l);
       Reader reader3 =   new Reader("Bobo", "12345678901", address3,contact3);
       manReaders.newReader(reader3);

       assertThat(listOfReaders.size(), is(3));

   }
   @Test
   public void removeInexistentReader(){
       boolean removedReader = manReaders.removeReader("6546547455");
       assertTrue(removedReader);
       assertThat(listOfReaders.size(), is(2));
   }

}
