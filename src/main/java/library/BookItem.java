package library;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * @author : alexchen
 * @created : 9/10/20, Thursday
 **/
@ToString
public class BookItem extends Book {

    @Getter
    private final int itemId;

    @Getter
    private BookStatus bookStatus;

    @Getter
    @Setter
    private Member borrower;

    @Getter
    @Setter
    private int rackId;

    @Getter
    @Setter
    private Instant borrowTime;

    @Getter
    @Setter
    private Instant returnTime;

    @Getter
    @Setter
    private Instant dueTime;

    public BookItem(int bookId, String title, String author, int itemId) {
        super(bookId, title, author);
        this.itemId = itemId;
    }

    public void checkout(int days, Member borrower) {
        borrowTime = Instant.now();
        dueTime = borrowTime.plus(days, ChronoUnit.DAYS);
        this.borrower = borrower;
        this.bookStatus = BookStatus.BORROWED;
    }

    public void returnBook() {
        returnTime = Instant.now();
        this.bookStatus = BookStatus.AVAILABLE;
    }

    public void renew(int days) {
        dueTime = dueTime.plus(days, ChronoUnit.DAYS);
    }

    public void reserve(Member borrower) {
        this.borrower = borrower;
        this.bookStatus = BookStatus.RESERVED;
    }

    public int getItemId() {
        return this.itemId;
    }

    public void cleanupStatus() {
        this.borrowTime = null;
        this.returnTime = null;
        this.dueTime = null;
        this.borrower = null;
    }
}
