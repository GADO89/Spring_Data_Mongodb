package com.global.book;

import com.global.book.entity.Author;
import com.global.book.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
public class StartupApp implements CommandLineRunner {

    @Autowired
    private AuthorRepo authorRepo;
    @Override
    public void run(String... args) throws Exception {

        if (authorRepo.findAll().isEmpty()) {

            Author auther = new Author();
            auther.setName("Mohamed");
            auther.setEmail("Mo@gmail.com");
            auther.setPhone("01125589989");

            Author auther1 = new Author();
            auther1.setName("Ali");
            auther1.setEmail("Ali@gmail.com");
            auther1.setPhone("01225589989");

            Author auther2 = new Author();
            auther2.setName("Mahmoud");
            auther2.setEmail("Mah@gmail.com");
            auther2.setPhone("01025589989");
            authorRepo.insert(Arrays.asList(auther, auther1, auther2));

             }
        }
}
