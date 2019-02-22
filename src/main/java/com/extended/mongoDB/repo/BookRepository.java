package com.extended.mongoDB.repo;

import com.extended.base.profile.MongoProfile;
import com.extended.mongoDB.model.Book;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@MongoProfile
@Repository
public interface BookRepository extends CrudRepository<Book, String> {

    List<Book> findAll();

    Optional<Book> findByName(String name);

}
