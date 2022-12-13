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
    void add(){
    badTable.add("hi");
    assertEquals(badTable.size(),1);
    assertTrue(badTable.remove("hi"));
}
@Test
    void addAll() {
    list.add("a");
    list.add("bc");
    badTable.addAll(list);
    assertEquals(badTable.size(), 2);
    assertTrue(badTable.removeAll(list));
}

@Test
    void clear(){
    goodTable.add("hah");
    goodTable.add("ded");
    assertEquals(goodTable.size(),2);
    goodTable.clear();
    assertEquals(goodTable.size(),0);
}
@Test
    void contains(){
    assertFalse(mediocreTable.contains("what"));
    mediocreTable.add("dad");
    mediocreTable.add("sfdds");
    assertTrue(mediocreTable.contains("dad"));
    assertFalse(mediocreTable.contains("list"));

}
@Test
    void containsAll(){
    list.add("dasfa");
    list.add("sfaf");
    list.add("asd");
    mediocreTable.addAll(list);
    assertTrue(mediocreTable.contains("asd"));
}
@Test
    void isEmpty(){
    assertTrue(badTable.isEmpty());
    badTable.add("ty");
    assertFalse(badTable.isEmpty());
    badTable.clear();
    assertTrue(badTable.isEmpty());

}

@Test
    void remove(){
    goodTable.add("d");
    assertTrue(goodTable.remove("d"));
    assertFalse(goodTable.remove("ddd"));
    assertEquals(goodTable.size(),0);
}
@Test
    void removeall(){
    list.add("ds");
    list.add("hello");
    mediocreTable.add("v");
    mediocreTable.add("b");
    mediocreTable.add("n");
    assertTrue(mediocreTable.removeAll(list));
    assertTrue(mediocreTable.contains("b"));

}
@Test
    void testcollision(){
    badTable.addAll(wordlist);
    mediocreTable.addAll(wordlist);
    goodTable.addAll(wordlist);
    System.out.println("for bad functor,# of collision is : "+ badTable.getCollisions());
    System.out.println("for mediocre functor,# of collision is : "+ mediocreTable.getCollisions());
    System.out.println("for good  functor,# of collision is : "+ goodTable.getCollisions());
}
private ArrayList<String> readFromFile(String filename){
    ArrayList<String> word = new ArrayList<>();
    try (Scanner fileInput = new Scanner(new File(filename))){
        fileInput.useDelimiter( "\\s*[^a-zA-Z]\\s*");
        while(fileInput.hasNext()){
            String s = fileInput.next();
            if(!s.equals(""))word.add(s.toLowerCase());
            if(word.size() == 4000) break  ;
        }
    }catch (FileNotFoundException e){
        System.err.println("File" + filename + "can not be found.");
    }
return word;
}


}
