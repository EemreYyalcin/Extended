package com.extended.repo.noDB;

import com.extended.model.noDB.Book;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Profile("mongo")
@Repository
public interface BookRepository extends CrudRepository<Book, String> {

}
