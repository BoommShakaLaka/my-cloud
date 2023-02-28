package com.cloud.controller;

import com.cloud.entity.Person;
import com.cloud.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MongodbController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/mongodb")
    public Person getUserById(@RequestParam("id") String id) {
        Optional<Person> person = userRepository.findById(id);
        System.out.println(person.toString());
        return person.orElse(null);
    }


    @PostMapping ("/mongodb")
    public boolean insertUser(@RequestParam("id") String id) {
        Person person = new Person();
        person.setId("111");
        person.setName("贾宝玉");
        person.setEmail("1234656@.qq.com");
        mongoTemplate.insert(person);
        return true;
    }
}
