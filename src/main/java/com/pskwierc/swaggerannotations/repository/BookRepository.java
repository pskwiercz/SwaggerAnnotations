package com.pskwierc.swaggerannotations.repository;

import com.pskwierc.swaggerannotations.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
