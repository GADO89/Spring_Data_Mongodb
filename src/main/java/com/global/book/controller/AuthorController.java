package com.global.book.controller;

import com.global.book.entity.Author;
import com.global.book.service.AuthorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/auther")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
   @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        return ResponseEntity.ok(authorService.findById(id));
   }
   @GetMapping("")
   public ResponseEntity<?> findAll(){
      return ResponseEntity.ok(authorService.findAll());
   }
   @PostMapping("")
   public ResponseEntity<?> insert(@RequestBody @Valid Author entity){
        return ResponseEntity.ok(authorService.insert(entity));
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody @Valid Author entity){
        return ResponseEntity.ok(authorService.update(entity));
    }
    @PutMapping("/custom")
    public  ResponseEntity<?>  updateEmail(@RequestParam @Email String email,
                                           @RequestParam String name,@RequestParam String phone) {
        authorService.updateEmail(email, name, phone);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/find-by-email/{email}")
  public   ResponseEntity <?> findAuthorByEmail(@PathVariable @Email String email){
        return ResponseEntity.ok(authorService.findAuthorByEmail(email));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?>  delete(@PathVariable String id){
        authorService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
