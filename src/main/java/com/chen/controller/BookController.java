package com.chen.controller;

import com.chen.pojo.Books;
import com.chen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allbook")
    public String list(Model model){
       List<Books> list =  bookService.allBooks();
       model.addAttribute("list",list);
       return "allbook";
    }

    //跳转到 添加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPage(){
        return "addbook";
    }
    //添加书籍页面
    @RequestMapping("/addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        return "redirect:/books/allbook";
    }

    //跳转到修改书籍页面,隐藏域传id
    @RequestMapping("/toUpdateBook")
    public String toUpdatePage(int id,Model model){
        Books books = bookService.queryBooksById(id);
        model.addAttribute("QBook",books);
        return "updatebook";
    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        bookService.updateBook(books);
        return "redirect:/books/allbook";
    }

    //删除书籍
    @RequestMapping("/deteleBook/{bookId}")
    public String deteleBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/books/allbook";
    }
}
