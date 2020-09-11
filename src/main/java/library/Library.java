package library;

import library.exception.BorrowException;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : alexchen
 * @created : 9/10/20, Thursday
 **/
public class Library {

    Map<Integer, BookItem> allBooks;

    Map<Integer, BookItem> reserved;

    Map<Integer, Account> accounts;

    public static Library instance = new Library();

    private Library() {
        this.allBooks = new HashMap<>();
        this.reserved = new HashMap<>();
        this.accounts = new HashMap<>();
    }

    public static Library getInstance() {
        return instance;
    }

    public void checkout(int bookItemId, int memberId, int days) {
        // check if reserved
        isReserved(bookItemId, memberId);

        allBooks.get(bookItemId).checkout(days, (Member) accounts.get(memberId));
        if (reserved.containsKey(bookItemId)) {
            reserved.remove(bookItemId);
        }
    }

    public double returnBook(int bookItemId) {
        BookItem bookItem = allBooks.get(bookItemId);
        bookItem.returnBook();

        Duration actualDays = Duration.between(bookItem.getBorrowTime(), bookItem.getReturnTime());
        Duration overdue = Duration.between(bookItem.getDueTime(), bookItem.getReturnTime());

        bookItem.cleanupStatus();

        return Payment.calcAmount((int) actualDays.toDays(), (int) (overdue.isNegative() ? 0 : overdue.toDays()));
    }

    public void renew(int bookItemId, int memberId, int days) {
        // check if reserved
        isReserved(bookItemId, memberId);

        allBooks.get(bookItemId).renew(days);
    }

    public void reserve(int bookItemId, int memberId) {
        // check if reserved
        isReserved(bookItemId, memberId);

        allBooks.get(bookItemId).reserve((Member) accounts.get(memberId));
        reserved.put(bookItemId, allBooks.get(bookItemId));
    }

    public void addBook(BookItem bookItem) {
        allBooks.put(bookItem.getItemId(), bookItem);
    }

    public void removeBook(BookItem bookItem) {
        allBooks.remove(bookItem.getItemId());
    }

    private boolean isReserved(int bookItemId, int memberId) {
        // check if reserved
        if (reserved.containsKey(bookItemId)) {
            // check if reserved by this person
            if (reserved.get(bookItemId).getBorrower() != accounts.get(memberId)) {
                throw new BorrowException();
            }
        }
        return true;
    }
}
