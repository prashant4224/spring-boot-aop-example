package com.caiyunworks.example.service;

import com.caiyunworks.example.h2.tables.pojos.Book;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static com.caiyunworks.example.h2.tables.Book.BOOK;

/**
 * Created by tonywang on 1/11/16.
 */
public class BookServiceImpl implements BookService {

    @Autowired
    DSLContext dsl;

    @Override
    @Transactional
    public void create(int id, int authorId, String title) {

        // This method has a "bug". It creates the same book twice. The second insert
        // should lead to a constraint violation, which should roll back the whole transaction
        for (int i = 0; i < 2; i++)
            dsl.insertInto(BOOK).set(BOOK.ID, id).set(BOOK.AUTHOR_ID, authorId).set(BOOK.TITLE, title).execute();
    }

    public void update(Book book){

    }
}
