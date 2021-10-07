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
    public AppUser update(UUID id, AppUser userDetails){
        if (userRepository.existsById(id)) {
            AppUser user = userDetails.toBuilder().id(id).build();
            userRepository.save(user);
            return userRepository.getById(user.getId());
        }
        else throw new ResourceNotFoundException(id.toString());
    }

    @Transactional
    public void delete(UUID id){
        if (userRepository.existsById(id)){
            AppUser user = userRepository.getById(id);
            userRepository.delete(user);
        }
        else throw new ResourceNotFoundException(id.toString());
    }
}
