package assignment02;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.Month;
import java.time.Year;
import java.util.*;

/**
 * Class representation of a library (a collection of library books).
 * 
 */
public class Library {

  private ArrayList<LibraryBook> library;// setup all the data in to a arraylish

  public Library() {
    library = new ArrayList<LibraryBook>();
  }// set up the arraylist

  /**
   * Add the specified book to the library, assume no duplicates.
   * 
   * @param isbn
   *          -- ISBN of the book to be added
   * @param author
   *          -- author of the book to be added
   * @param title
   *          -- title of the book to be added
   */
  public void add(long isbn, String author, String title) {
    library.add(new LibraryBook(isbn, author, title));
  }
// adding the data into the arraylist
  /**
   * Add the list of library books to the library, assume no duplicates.
   * 
   * @param list
   *          -- list of library books to be added
   */
  public void addAll(ArrayList<LibraryBook> list) {
    library.addAll(list);
  }

  /**
   * Add books specified by the input file. One book per line with ISBN, author,
   * and title separated by tabs.
   * 
   * If file does not exist or format is violated, do nothing.
   * 
   * @param filename
   */
  public void addAll(String filename) {
    ArrayList<LibraryBook> toBeAdded = new ArrayList<LibraryBook>();

    try (Scanner fileIn = new Scanner(new File(filename))) {

      int lineNum = 1;

      while (fileIn.hasNextLine()) {
        String line = fileIn.nextLine();

        try (Scanner lineIn = new Scanner(line)) {
          lineIn.useDelimiter("\\t");

          if (!lineIn.hasNextLong()) {
            throw new ParseException("ISBN", lineNum);
          }
          long isbn = lineIn.nextLong();

          if (!lineIn.hasNext()) {
            throw new ParseException("Author", lineNum);
          }
          String author = lineIn.next();

          if (!lineIn.hasNext()) {
            throw new ParseException("Title", lineNum);
          }
          String title = lineIn.next();
          toBeAdded.add(new LibraryBook(isbn, author, title));
        }
        lineNum++;
      }
    } catch (FileNotFoundException e) {
      System.err.println(e.getMessage() + " Nothing added to the library.");
      return;
    } catch (ParseException e) {
      System.err.println(e.getLocalizedMessage() + " formatted incorrectly at line " + e.getErrorOffset()
          + ". Nothing added to the library.");
      return;
    }

    library.addAll(toBeAdded);
  }

  /**
   * Returns the holder of the library book with the specified ISBN.
   * 
   * If no book with the specified ISBN is in the library, returns null.
   * 
   * @param isbn
   *          -- ISBN of the book to be looked up
   */
  public String lookup(long isbn) {

for(int i = 0; i < library.size(); i++){
      if (library.get(i).getIsbn() == isbn ) {// reach book by isbn match the isbn from library。
        return library.get(i).getHolder();// return book either has  a holder .
      }
    }
    // FILL IN -- do not return null unless appropriate
    return null;
  }

  /**
   * Returns the list of library books checked out to the specified holder.
   * 
   * If the specified holder has no books checked out, returns an empty list.
   * 
   * @param holder
   *          -- holder whose checked out books are returned
   */
  public ArrayList<LibraryBook> lookup(String holder) {
    ArrayList<LibraryBook> LB = new ArrayList<>();// creat new arraylist with all the info from library.*
    for(int i = 0; i < library.size(); i++){
      if (library.get(i).getHolder() == holder) { // search by holder to check what book has been check out.
        LB.add(library.get(i));// the all the info to the new arraylist relate to the holder
      }
    }
    // FILL IN -- do not return null
    return LB;
  }

  /**
   * Sets the holder and due date of the library book with the specified ISBN.
   * 
   * If no book with the specified ISBN is in the library, returns false.
   * 
   * If the book with the specified ISBN is already checked out, returns false.
   * 
   * Otherwise, returns true.
   * 
   * @param isbn
   *          -- ISBN of the library book to be checked out
   * @param holder
   *          -- new holder of the library book
   * @param month
   *          -- month of the new due date of the library book
   * @param day
   *          -- day of the new due date of the library book
   * @param year
   *          -- year of the new due date of the library book
   * 
   */
  public boolean checkout(long isbn, String holder, int month, int day, int year) {
    for(int i = 0; i < library.size(); i++){
      if(library.get(i).getIsbn() ==isbn){// gone through library seach book by isbn
        if(library.get(i).getDueDate() ==null&& library.get(i).getHolder()== null){//  if the book dont  have  info about holder and duedate thats mean book still in the library
          GregorianCalendar due_date =new GregorianCalendar(year,month,day);// create out  the specific date and holder
          library.get(i).checkout(holder,due_date);// create the holder and duedate
          return true;
        }
        return false;
      }
    }

    // FILL IN -- do not return false unless appropriate
    return false;
  }

  /**
   * Unsets the holder and due date of the library book.
   * 
   * If no book with the specified ISBN is in the library, returns false.
   * 
   * If the book with the specified ISBN is already checked in, returns false.
   * 
   * Otherwise, returns true.
   * 
   * @param isbn
   *          -- ISBN of the library book to be checked in
   */
  public boolean checkin(long isbn) {

//    for (int i = 0; i < library.size(); i++) {// getting info from library
//      if (library.get(i).getIsbn()==isbn) {// search the info by isbn
//        if (library.get(i).getHolder() != null && library.get(i).getDueDate() != null) {//* takeoff teh holder and dudedate
//          library.get(i).checkin();// create checkin
//          return true;
//        } else return false;
//
//      }
//    }

    for (int i = 0; i < library.size(); i++) {// getting info from library
      LibraryBook libraryBook = library.get(i);
      if (libraryBook.getIsbn()==isbn) {// search the info by isbn
        if (libraryBook.getHolder() != null && libraryBook.getDueDate() != null) {// meanwhile holder and duedate int null
          libraryBook.checkin();// create checkin transfer the statues to check in
          return true;
        } else return false;

      }
    }


    // FILL IN -- do not return false unless appropriate
    return false;
  }

  /**
   * Unsets the holder and due date for all library books checked out be the
   * specified holder.
   * 
   * If no books with the specified holder are in the library, returns false;
   * 
   * Otherwise, returns true.
   * 
   * @param holder
   *          -- holder of the library books to be checked in
   */
  public boolean checkin(String holder) {
    for (int i = 0; i < library.size(); i++) {
      if(library.get(i).getHolder()==holder){// checkin in by holder
        library.get(i).checkin();// create checkin
      }

    }
    // FILL IN -- do not return false unless appropriate
    return false;
  }
//  public String toString(){
//    StringBuilder sb = StringBuilder();
//    for (LibraryBook book:library){
//      sb.append((book.toString()).append("\n");
//    }
//    return sb.toString();
//    }

  public int size(){return library.size();}
}
