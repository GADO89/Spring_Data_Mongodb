package com.global.book.service;

import com.global.book.entity.Author;
import com.global.book.repo.AuthorRepo;
import com.global.book.repo.CustomAuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AuthorService {

    @Autowired
    private CustomAuthorRepo customAuthorRepo;
    @Autowired
    private AuthorRepo autherRepo;

    public List<Author> findAll(){
        return autherRepo.findAll();
    }

    public Author findById(String id){
        return autherRepo.findById(id).get();
    }

    public Author insert(Author entity){
        if (entity.getId() !=null){
            throw new RuntimeException();
        }
        return autherRepo.insert(entity);
    }

    public List<Author> insertAll(List<Author> entity){
        return autherRepo.saveAll(entity);
    }

    public Author update( Author entity){
        Author author=findById(entity.getId());
        author.setName(entity.getName());
        author.setEmail(entity.getEmail());
        author.setPhone(entity.getPhone());

        return autherRepo.save(entity);
    }

 public  void updateEmail(String email, String name, String phone) {
        customAuthorRepo.updateEmail(email, name, phone);
    }

    public Author  findAuthorByEmail(String email){
        return autherRepo.findAuthorByEmail(email);
    }

    public void deleteById(String id){
        autherRepo.deleteById(id);
    }
}
