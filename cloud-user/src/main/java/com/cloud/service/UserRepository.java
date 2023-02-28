package com.cloud.service;

import com.cloud.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<Person, String> {

    List<Person> findByName(String name);
    List<Person> findByEmail(String email);
}
