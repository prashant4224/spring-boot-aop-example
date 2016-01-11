package com.caiyunworks.example.service;

import com.caiyunworks.example.h2.tables.pojos.Book;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tonywang on 1/11/16.
 */
public interface BookService {

    /**
     * Create a new book.
     * <p>
     * The implementation of this method has a bug, which causes this method to fail and roll back the transaction.
     */
    @Transactional
    void create(int id, int authorId, String title);
}
