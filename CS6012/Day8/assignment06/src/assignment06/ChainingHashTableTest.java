package assignment06;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ChainingHashTableTest {
ChainingHashTable badTable;
ChainingHashTable mediocreTable;
ChainingHashTable goodTable;
ArrayList<String> list;

ArrayList<String> wordlist;
@BeforeEach

    void setUp(){
    badTable = new ChainingHashTable(2000,new BadHashFunctor());
    mediocreTable =new ChainingHashTable( 2000, new MediocreHashFunctor());
    goodTable = new ChainingHashTable(2000,new GoodHashFunctor());
    list = new ArrayList<>();
    wordlist = readFromFile("dictionary.txt");
}
@AfterEach
    void tearDown(){
    badTable = null;
    mediocreTable =null;
    goodTable =null;
    list = null;
    wordlist = null;
}
@Test
    void hello (){
    badTable.add("hi");
    badTable.add("nihao");
    badTable.add("hola");
    badTable.add("bonjour");
    badTable.add("hallo");
    assertEquals(badTable.size(),5);
    assertTrue(badTable.remove("hi"));
    assertEquals(badTable.size(),4);
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    badTable.addAll(list);
    assertEquals(badTable.size(),8);
    badTable.clear();
    assertTrue(badTable.isEmpty());

}


@Test
    void worldcupcontains(){
    mediocreTable.add("Japan");
    mediocreTable.add("holland");
    mediocreTable.add("France");
    mediocreTable.add("Argentina");
    mediocreTable.add("Morcco");
    list.add("brazil");
    list.add("Portugal");
    list.add("England");
    assertTrue(mediocreTable.contains("Japan"));
    assertTrue(mediocreTable.contains("France"));
    assertEquals(mediocreTable.size(),5);
    mediocreTable.addAll(list);
    assertEquals(mediocreTable.size(),8);
    assertTrue(mediocreTable.contains("brazil"));
    assertTrue(mediocreTable.contains("England"));
    assertFalse(mediocreTable.contains("China"));
    assertTrue(mediocreTable.remove("Japan"));
    assertTrue(mediocreTable.remove("holland"));
    assertEquals(mediocreTable.size(),6);
    assertTrue(mediocreTable.removeAll(list));
    assertEquals(mediocreTable.size(),3);
    mediocreTable.clear();
    assertEquals(mediocreTable.size(),0);

}

@Test
    void testcollision(){
    badTable.addAll(wordlist);
    mediocreTable.addAll(wordlist);
    goodTable.addAll(wordlist);
    System.out.println("for bad functor,# of collision is : "+ badTable.getCollisions());
    System.out.println("for mediocre functor,# of collision is : "+ mediocreTable.getCollisions());
    System.out.println("for good functor,# of collision is : "+ goodTable.getCollisions());
}
private ArrayList<String> readFromFile(String filename){
    ArrayList<String> word = new ArrayList<>();
    try (Scanner fileInput = new Scanner(new File(filename))){
        fileInput.useDelimiter( "\\s*[^a-zA-Z]\\s*");
        while(fileInput.hasNext()){
            String s = fileInput.next();
            if(!s.equals(""))word.add(s.toLowerCase());
            if(word.size() == 5000) break  ;
        }
    }catch (FileNotFoundException e){
        System.err.println("File" + filename + "can not be found.");
    }
return word;
}


}
