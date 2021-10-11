package com.example.demouserproject.controller;

import com.example.demouserproject.model.AppUser;
import com.example.demouserproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {

    UserService userService;

    @CrossOrigin
    @GetMapping()
    public List<AppUser> allUsers(){
        return userService.findAll();
    }

    @PostMapping
    public ResponseEntity<AppUser> newUser(@RequestBody @Valid AppUser newUser){
        AppUser user = userService.create(newUser);
        return ResponseEntity.ok(user);
    }

    @GetMapping("{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable UUID id){
        try{
            AppUser user = userService.findByID(id);
            return ResponseEntity.ok().body(user);
        }
        catch (ResourceNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<AppUser> replaceUser(@PathVariable UUID id, @RequestBody @Valid AppUser userDetails){
        try{
            AppUser user = userService.update(id, userDetails);
            return ResponseEntity.ok().body(user);
        }
        catch (ResourceNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable UUID id){
        try{
            userService.delete(id);
            return ResponseEntity.ok().build();
        }
        catch (ResourceNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
    }
}
