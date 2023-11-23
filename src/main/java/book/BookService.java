package main.java.book;

public class BookService {

    private BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public void getInfoAboutBook(Book book) {
        repo.getInfoFromBase(book);
    }
}
