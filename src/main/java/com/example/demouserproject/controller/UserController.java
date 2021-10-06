package com.example.demouserproject.controller;

import com.example.demouserproject.model.AppUser;
import com.example.demouserproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    UserService userService;

    @GetMapping()
    public List<AppUser> allUsers(){
        return userService.findAll();
    }

    @PostMapping
    public AppUser newUser(@RequestBody AppUser user){
        return userService.create(user);
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
    public ResponseEntity<AppUser> replaceUser(@PathVariable UUID id, @RequestBody AppUser userDetails){
        //TODO mapper
        try{
            AppUser user = userService.update(userDetails);
            return ResponseEntity.ok().body(user);
        }
        catch (ResourceNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable UUID id){
        try{
            AppUser user = userService.findByID(id);
            userService.delete(user);
            return ResponseEntity.ok().build();
        }
        catch (ResourceNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
    }
}
