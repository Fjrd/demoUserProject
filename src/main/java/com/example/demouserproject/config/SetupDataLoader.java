package com.example.demouserproject.config;

import com.example.demouserproject.model.Ad;
import com.example.demouserproject.model.AdCategory;
import com.example.demouserproject.model.AdStatus;
import com.example.demouserproject.model.AppUser;
import com.example.demouserproject.repository.AdRepository;
import com.example.demouserproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    UserRepository userRepository;
    AdRepository adRepository;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        AppUser user1 = AppUser.builder()
                .firstName("Ivan")
                .middleName("Ivanovich")
                .lastName("Ivanov")
                .email("ivan@email.com")
                .password("vanya123")
                .build();

        AppUser user2 = AppUser.builder()
                .firstName("Petr")
                .middleName("Petrovich")
                .lastName("Petrov")
                .email("petr@email.com")
                .password("petya123")
                .build();

        AppUser user3 = AppUser.builder()
                .firstName("Sidor")
                .middleName("Sidorovich")
                .lastName("Sidorov")
                .email("sidor@email.com")
                .password("sidorushka123")
                .build();

        Stream.of(user1, user2, user3).forEach(userRepository::save);

        Ad ad = Ad.builder()
                .owner(user1)
                .status(AdStatus.DRAFT)
                .address("SPB, Nevskiy pr., 1, 1")
                .category(AdCategory.ELECTRONICS)
                .text("iPhone 13 for free!")
                .build();

        adRepository.save(ad);

    }
}
