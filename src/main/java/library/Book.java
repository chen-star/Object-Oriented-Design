package library;

import lombok.Getter;

/**
 * @author : alexchen
 * @created : 9/10/20, Thursday
 **/
public class Book {

    @Getter
    private final int bookId;

    @Getter
    private final String title;

    @Getter
    private final String author;


    public Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
    }
}
