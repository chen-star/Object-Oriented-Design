package library;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : alexchen
 * @created : 9/10/20, Thursday
 **/
public class BookItem extends Book{

    @Getter
    private final int itemId;

    @Getter
    private BookStatus bookStatus;

    @Getter
    @Setter
    private int rackId;

    public BookItem(int bookId, String title, String author, int itemId) {
        super(bookId, title, author);
        this.itemId = itemId;
    }
}
