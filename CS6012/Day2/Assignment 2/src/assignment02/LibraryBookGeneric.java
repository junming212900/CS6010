package assignment02;

import java.util.GregorianCalendar;

public class LibraryBookGeneric<Type> extends Book {
    private Type holder;
    private GregorianCalendar due_date;

    public LibraryBookGeneric (long isbn,String author,String title){super(isbn,author,title);}

    public Type getHolder(){return holder;}

//    public GregorianCalendar getDueDate(){
//        if (this.getDueDate() != null)
//        return this.getDueDate();
//        else return null;
//    }
    public GregorianCalendar getDueDate(){
        return due_date;}
    public void checkIn(){
        holder= null;
        due_date =null;
    }
    public void checkOut(Type holder,GregorianCalendar due_date){
        this.holder = holder;
        this.due_date = due_date;

    }
    public boolean isCheckedOut(){return holder!=null && due_date!=null;}//
    public boolean isCheckedIn(){return holder==null && due_date==null;}//

    public void setHolder(Type holder) {
        this.holder = holder;
    }

    public void setDue_date(GregorianCalendar due_date) {
        this.due_date = due_date;
    }

    }

