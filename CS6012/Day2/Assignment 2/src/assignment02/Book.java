package assignment02;

/**
 * Class representation of a book. The ISBN, author, and title can never change
 * once the book is created.
 * 
 * Note that ISBNs are unique.
 *
 */
public class Book {

  private long isbn;

  private String author;

  private String title;

//  private int DueDate;

  public Book(long isbn, String author, String title) {// setup elements
    this.isbn = isbn;
    this.author = author;
    this.title = title;
//    this.DueDate = DueDate;
  }

  /**
   * @return the author
   */
  // setup getters
  public String getAuthor() {
    return this.author;
  }

  /**
   * @return the ISBN
   */
  public long getIsbn() {
    return this.isbn;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return this.title;
  }
//  public int getDueDate(){return  this.DueDate;}

  /**
   * Two books are considered equal if they have the same ISBN, author, and title.
   * 
   * @param other
   *          -- the object begin compared with "this"
   * @return true if "other" is a Book and is equal to "this", false otherwise
   */
  public boolean equals(Object other) {// define the samelarite of the books
    if (!(other instanceof Book book)) { // make sure the Object we're comparing to is a Matrix
      return false;
    }
    return this.author == book.getAuthor() && this.isbn == book.getIsbn() && this.title == this.getTitle();
    // FILL IN -- do not return false unless appropriate

  }


  /**
   * Returns a string representation of the book.
   */
  public String toString() {
    return isbn + ", " + author + ", \"" + title + "\"";
  }

  @Override
  public int hashCode() {
    return (int) isbn + author.hashCode() + title.hashCode();
  }
}
