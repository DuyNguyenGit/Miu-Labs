package lesson9.labs.prob1.business;

import lesson9.labs.prob1.dataaccess.DataAccessFacade;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(allWhoseZipContains3());
        System.out.println(allHavingAtLeastTwoCopies());
        System.out.println(allHavingMultipleAuthors());

    }

    //Returns a list of all ids of LibraryMembers whose zipcode contains the digit 3
    public static List<LibraryMember> allWhoseZipContains3() {
//		DataAccess da = new DataAccessFacade();
//		Collection<LibraryMember> members = da.readMemberMap().values();
//		List<LibraryMember> mems = new ArrayList<>();
//		mems.addAll(members);
        //implement
        return (new DataAccessFacade())
                .readMemberMap()
                .values()
                .stream()
                .filter(member -> member.getAddress().getZip().contains("3"))
                .toList();

    }

    //Returns a list of all isbns of books having at least two copies
    public static List<String> allHavingAtLeastTwoCopies() {
//		DataAccess da = new DataAccessFacade();
//		Collection<Book> books = da.readBooksMap().values();
//		List<Book> bs = new ArrayList<>();
//		bs.addAll(books);
        //implement
        return (new DataAccessFacade())
                .readBooksMap()
                .values()
                .stream()
                .filter(book -> book.getCopies().length >= 2)
                .map(Book::getIsbn)
                .toList();

    }

    //Returns a list of all isbns of  Books that have multiple authors
    public static List<String> allHavingMultipleAuthors() {
//		DataAccess da = new DataAccessFacade();
//		Collection<Book> books = da.readBooksMap().values();
//		List<Book> bs = new ArrayList<>();
//		bs.addAll(books);
        //implement
        return (new DataAccessFacade())
                .readBooksMap()
                .values()
                .stream()
                .filter(book -> book.getAuthors().size() >= 2)
                .map(Book::getIsbn)
                .toList();

    }

}
