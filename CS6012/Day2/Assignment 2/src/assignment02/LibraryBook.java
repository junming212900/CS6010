package assignment02;

import java.util.GregorianCalendar;

public class LibraryBook extends Book{

    String holder;// create the holder

    GregorianCalendar due_date;// create the duedate data
    Boolean checked_in;// create the checkin statues


    public LibraryBook(long isbn, String author, String title ) {// create book class
        super(isbn, author, title);
        checked_in = true;

    }
    public String getHolder(){
        return holder;
    }// create getter
    public GregorianCalendar getDueDate(){
        return due_date;
    }// create duedate getter
    public void checkin(){//if the statues is checkin then holder and duedate is null
        this.holder = null;
        this.due_date =null;
    }
    public void checkout(String holder,GregorianCalendar due_date){// if the statues is checkout then holder and duedate have data info
        this.holder = holder;
        this.due_date= due_date;
    }
//    public boolean isCheckedOut(){return holder!=null && due_date!=null;}//
//    public boolean isCheckedIn(){return holder==null && due_date==null;}//
}

