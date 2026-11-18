package in.ashokit.service;

import in.ashokit.entity.Book;
import in.ashokit.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public boolean addBook(Book book)
    {
        Book saved = bookRepository.save(book);
        if(saved.getBookId()!=null){
            return true;
        }else{
            return false;
        }
    }
}
