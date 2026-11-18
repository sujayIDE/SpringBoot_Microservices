package in.ashokit.controller;

import in.ashokit.entity.Book;
import in.ashokit.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/add")
    public String getBookAddPage(Model model)
    {
        model.addAttribute("book",new Book());
        return "add-book";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book)
    {
        boolean status = bookService.addBook(book);
        if(status)
        {
            return "success-page";
        }else{
            return "failure-page";
        }
    }
}
