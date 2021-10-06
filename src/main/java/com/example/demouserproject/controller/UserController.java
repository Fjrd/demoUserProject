package com.example.demouserproject.controller;

import com.example.demouserproject.model.AppUser;
import com.example.demouserproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
        AppUser user = userService.findByID(id);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<AppUser> updateUser(@PathVariable UUID id, @RequestBody AppUser userDetails){
        //TODO mapper
        AppUser user = userService.update(userDetails);
        return ResponseEntity.ok().body(user);

    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUserById(@PathVariable UUID id){
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
