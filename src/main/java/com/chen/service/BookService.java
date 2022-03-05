package com.chen.service;

import com.chen.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    int addBook(Books books);

    int deleteBookById(int id);

    int updateBook(Books books);

    Books queryBooksById(int id);

    List<Books> allBooks();


}
