package com.example.demouserproject.service;

import com.example.demouserproject.model.AppUser;
import com.example.demouserproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    UserRepository userRepository;

    @Transactional
    public AppUser create(AppUser user){
        return userRepository.save(user);
    }

    @Transactional
    public AppUser findByID(UUID id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id.toString()));
    }

    @Transactional
    public List<AppUser> findAll(){
        return userRepository.findAll();
    }

    @Transactional
    public AppUser update(AppUser appUser){
        if (isExists(appUser.getId())) {
            userRepository.save(appUser);
            return userRepository.findById(appUser.getId())
                    .orElseThrow(() -> new ResourceNotFoundException(appUser.getId().toString()));
        }
        else throw new ResourceNotFoundException(appUser.getId().toString());
    }

    @Transactional
    public void delete(AppUser appUser){
        userRepository.delete(appUser);
    }

    @Transactional
    public boolean isExists(UUID id){
        return userRepository.existsById(id);
    }
}
