package assignment02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class LibraryGenericTest {

    @Test
    public void stringLibraryTest() {
        // test a library that uses names (String) to id patrons
        LibraryGeneric<String> lib = new LibraryGeneric<>();

        lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
        lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
        lib.add(9780446580342L, "David Baldacci", "Simple Genius");

        String patron1 = "Jane Doe";

        assertTrue(lib.checkout(9780330351690L, patron1, 1, 1, 2008));
        assertTrue(lib.checkout(9780374292799L, patron1, 1, 1, 2008));

        var booksCheckedOut1 = lib.lookup(patron1);
        assertEquals(booksCheckedOut1.size(), 2);
        assertTrue(booksCheckedOut1.contains(new Book(9780330351690L, "Jon Krakauer", "Into the Wild")));
        assertTrue(booksCheckedOut1.contains(new Book(9780374292799L, "Thomas L. Friedman", "The World is Flat")));
        assertEquals(booksCheckedOut1.get(0).getHolder(), patron1);
        assertEquals(booksCheckedOut1.get(0).getDueDate(), new GregorianCalendar(2008, 1, 1));
        assertEquals(booksCheckedOut1.get(1).getHolder(),patron1);
        assertEquals(booksCheckedOut1.get(1).getDueDate(),new GregorianCalendar(2008, 1, 1));

        assertTrue(lib.checkin(patron1));

    }

    @Test
    public void phoneNumberTest(){
        // test a library that uses phone numbers (PhoneNumber) to id patrons
        var lib = new LibraryGeneric<PhoneNumber>();
        lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
        lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
        lib.add(9780446580342L, "David Baldacci", "Simple Genius");

        PhoneNumber patron2 = new PhoneNumber("801.555.1234");

        assertTrue(lib.checkout(9780330351690L, patron2, 1, 1, 2008));
        assertTrue(lib.checkout(9780374292799L, patron2, 1, 1, 2008));

        ArrayList<LibraryBookGeneric<PhoneNumber>> booksCheckedOut2 = lib.lookup(patron2);

        assertEquals(booksCheckedOut2.size(), 2);
        assertTrue(booksCheckedOut2.contains(new Book(9780330351690L, "Jon Krakauer", "Into the Wild")));
        assertTrue(booksCheckedOut2.contains(new Book(9780374292799L, "Thomas L. Friedman", "The World is Flat")));
        assertEquals(booksCheckedOut2.get(0).getHolder(),patron2);
        assertEquals(booksCheckedOut2.get(0).getDueDate(),new GregorianCalendar(2008, 1, 1));
        assertEquals(booksCheckedOut2.get(1).getHolder(), patron2);
        assertEquals(booksCheckedOut2.get(1).getDueDate(), new GregorianCalendar(2008, 1, 1));

        assertTrue(lib.checkin(patron2));

    }
    @Test
    public void Overduetest(){
        var lib = new LibraryGeneric<PhoneNumber>();
        lib.add(9781843190400L,	"Jean Fanelli",	"The War Comes to Witham Street");
        lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
        lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
        lib.add(9780446580342L, "David Baldacci", "Simple Genius");


        PhoneNumber patron2 = new PhoneNumber("801.555.1234");

        assertTrue(lib.checkout(9781843190400L, patron2, 1, 1, 2007));
        assertTrue(lib.checkout(9780374292799L, patron2, 1, 1, 2011));
        assertTrue(lib.checkout(9780330351690L, patron2, 1, 1, 2009));
        assertTrue(lib.checkout(9780446580342L, patron2, 1, 1, 2010));


        ArrayList<LibraryBookGeneric<PhoneNumber>> booksCheckedOut2 = lib.lookup(patron2);
        var lib_ = lib.getOverdueList(7,11,2010);

        assertEquals("The War Comes to Witham Street",lib_.get(0).getTitle());
        assertEquals(9780330351690L,lib_.get(1).getIsbn());
        assertTrue(lib.checkin(patron2));
    }
    @Test
    public void InventoryListTest(){
        LibraryGeneric<String> lib = new LibraryGeneric<>();

        lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
        lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
        lib.add(9780446580342L, "David Baldacci", "Simple Genius");

        var lib_ = lib.getInventoryList();
        assertEquals(9780330351690L,lib_.get(0).getIsbn());
        assertEquals("Jon Krakauer",lib_.get(0).getAuthor());
        assertEquals("Simple Genius",lib_.get(2).getTitle());
    }

}
