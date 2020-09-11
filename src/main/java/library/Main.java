package library;

import library.exception.BorrowException;

/**
 * @author : alexchen
 * @created : 9/10/20, Thursday
 **/
public class Main {

    public static void main(String[] args) {

        // init
        BookItem book1 = new BookItem(1, "Effective Java", "Bob", 1);
        BookItem book2 = new BookItem(2, "Hello Java", "Alice", 2);
        BookItem book3 = new BookItem(3, "Bye Java", "Peter", 3);
        BookItem book4 = new BookItem(4, "I like Java", "Anna", 4);
        BookItem book5 = new BookItem(5, "I eat Java", "Sam", 5);

        Library library = Library.getInstance();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        Member member1 = new Member(1);
        Member member2 = new Member(2);

        library.accounts.put(member1.getAccountId(), member1);
        library.accounts.put(member2.getAccountId(), member2);


        // simulation
        library.reserve(3,1);
        System.out.println(library.reserved);

        try {
            library.checkout(3, 2, 10);
        } catch (BorrowException e) {
            System.out.println("Expected Borrow Exception");
        }

        library.checkout(3, 1, 5);
        System.out.println(library.allBooks.get(3));

        library.returnBook(3);
        System.out.println(library.allBooks.get(3));
        library.checkout(3, 2, 20);
        System.out.println(library.allBooks.get(3));
    }
}
