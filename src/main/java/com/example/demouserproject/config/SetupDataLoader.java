package com.example.demouserproject.config;

import com.example.demouserproject.model.AppUser;
import com.example.demouserproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    UserRepository userRepository;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        AppUser user = AppUser.builder()
                .id(UUID.randomUUID())
                .firstName("firstName")
                .middleName("middleName")
                .lastName("lastName")
                .email("email@email.com")
                .password("password")
                .build();
        userRepository.save(user);
    }
}
