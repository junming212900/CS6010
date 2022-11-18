package assignment02;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class LibraryGeneric<Type> {


    private ArrayList<LibraryBookGeneric<Type>> library;

    public LibraryGeneric() {
        library = new ArrayList<LibraryBookGeneric<Type>>();
    }


    public void add(long isbn, String author, String title) {
        library.add(new LibraryBookGeneric<>(isbn, author, title));
    }


    public void addAll(ArrayList<LibraryBookGeneric<Type>> list) {
        library.addAll(list);
    }


    public void addAll(String filename) {
        ArrayList<LibraryBookGeneric<Type>> toBeAdded = new ArrayList<>();

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
                    toBeAdded.add(new LibraryBookGeneric<Type>(isbn, author, title));
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


    public Type lookup(long isbn) {

        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getIsbn() == isbn) {// reach book by isbn match the isbn from library。
                return library.get(i).getHolder();// return book either has  a holder .
            }
        }
        // FILL IN -- do not return null unless appropriate
        return null;
    }


    public ArrayList<LibraryBookGeneric<Type>> lookup(Type holder) {
        ArrayList<LibraryBookGeneric<Type>> LB = new ArrayList<>();// creat new arraylist with all the info from library.
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getHolder() == holder) { // search by holder to check what book has been check out.
                LB.add(library.get(i));
            }
        }
        // FILL IN -- do not return null
        return LB;
    }


    public boolean checkout(long isbn, Type holder, int month, int day, int year) {
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getIsbn() == isbn) {// gone through library seach book by isbn
                if (library.get(i).getDueDate() == null && library.get(i).getHolder() == null) {//  if the book don't not have  info about holder and duedate
                    GregorianCalendar due_date = new GregorianCalendar(year, month, day);// create out  the specific date and holder
                    library.get(i).checkOut(holder, due_date);
                    return true;
                }
                return false;
            }
        }

        // FILL IN -- do not return false unless appropriate
        return false;
    }


    public boolean checkin(long isbn) {

        for (int i = 0; i < library.size(); i++) {// getting info from library
            if (library.get(i).getIsbn() == isbn) {// search the info by isbn
                if (library.get(i).getHolder() != null && library.get(i).getDueDate() != null) {// takeoff teh holder and dudedate
                    library.get(i).checkIn();// create checkin
                    return true;
                } else return false;

            }
        }


        // FILL IN -- do not return false unless appropriate
        return false;
    }


    public boolean checkin(Type holder) {
        boolean checkInSuccess = false;
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getHolder() == holder) {// checkin in by holder
                library.get(i).checkIn();// create checkin
                checkInSuccess = true;
            }

        }
        // FILL IN -- do not return false unless appropriate
        return checkInSuccess;
    }


    public ArrayList<LibraryBookGeneric<Type>> getInventoryList() {
        ArrayList<LibraryBookGeneric<Type>> libraryCopy = new ArrayList<LibraryBookGeneric<Type>>();
        libraryCopy.addAll(library);

        OrderByIsbn comparator = new OrderByIsbn();

        sort(libraryCopy, comparator);

        return libraryCopy;
    }


    public ArrayList<LibraryBookGeneric<Type>> getOrderedByAuthor() {
        ArrayList<LibraryBookGeneric<Type>> libraryCopy = new ArrayList<LibraryBookGeneric<Type>>();
        libraryCopy.addAll(library);
        OrderByAuthor comparator = new OrderByAuthor();
        sort(libraryCopy, comparator);

        // FILL IN -- do not return null
        return libraryCopy;
    }


    public ArrayList<LibraryBookGeneric<Type>> getOverdueList(int month, int day, int year) {
        ArrayList<LibraryBookGeneric<Type>> libraryCopy = new ArrayList<LibraryBookGeneric<Type>>();
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getDueDate().compareTo(new GregorianCalendar()) < 0) {
                libraryCopy.add(library.get(i));
            }
        }

        // FILL IN -- do not return null
        return libraryCopy;
    }


    private static <ListType> void sort(ArrayList<ListType> list,
                                        Comparator<ListType> c) {
        for (int i = 0; i < list.size() - 1; i++) {
            int j, minIndex;
            for (j = i + 1, minIndex = i; j < list.size(); j++)
                if (c.compare(list.get(j), list.get(minIndex)) < 0)
                    minIndex = j;
            ListType temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }


    protected class OrderByIsbn implements Comparator<LibraryBookGeneric<Type>> {


        public int compare(LibraryBookGeneric<Type> lhs,
                           LibraryBookGeneric<Type> rhs) {
            return (int) (lhs.getIsbn() - rhs.getIsbn());
        }
    }


    protected class OrderByAuthor implements Comparator<LibraryBookGeneric<Type>> {
        @Override
        public int compare(LibraryBookGeneric<Type> lhs, LibraryBookGeneric<Type> rhs) {
            if (!(lhs.getAuthor().equals(rhs.getAuthor()))) {
                return lhs.getAuthor().compareTo(rhs.getAuthor());
            } else {
                return lhs.getTitle().compareTo(rhs.getTitle());
            }

            // FILL IN
        }


        protected class OrderByDueDate implements Comparator<LibraryBookGeneric<Type>> {
            @Override
            public int compare(LibraryBookGeneric<Type> lhs, LibraryBookGeneric<Type> rhs) {


                return lhs.getDueDate().compareTo(rhs.getDueDate());
            }

            // FILL IN
        }
    }
}

