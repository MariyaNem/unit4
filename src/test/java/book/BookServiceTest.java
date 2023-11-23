package test.java.book;

import main.java.book.Book;
import main.java.book.BookRepository;
import main.java.book.BookService;
import org.junit.Before;
import org.junit.Test;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;


public class BookServiceTest {

    private BookRepository bookRepositoryMock;
    private BookService bookService;
    private Book book;

    @Before
    public void setUp() {
// Создаем Mock объект для BookRepository
        bookRepositoryMock = mock(BookRepository.class);  // Mock заменяет реальный компонент, позволяя проверять взаимодействие между объектами;
        // при этом функции и методы объекта будут пустыми, если мы их специально не обозначим (опишем)
        bookService = new BookService(bookRepositoryMock);
        book = new Book(); // Здесь мы могли бы настроить книгу, если бы это было необходимо
    }

    @Test
    public void testGetInfoFromDB() {
// Выполняем метод, который хотим протестировать
        bookService.getInfoAboutBook(book);

// Проверяем, что метод getInfoFromBase был вызван с правильным заказом
        verify(bookRepositoryMock).getInfoFromBase(book);
    }
}