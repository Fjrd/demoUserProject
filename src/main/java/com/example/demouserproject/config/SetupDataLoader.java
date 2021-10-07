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

@Component
@RequiredArgsConstructor
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    UserRepository userRepository;
    AdRepository adRepository;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        AppUser user = AppUser.builder()
                .firstName("Ivan")
                .middleName("Ivanovich")
                .lastName("Ivanov")
                .email("email@email.com")
                .password("password")
                .build();
        user = userRepository.save(user);

        Ad ad = Ad.builder()
                .owner(user)
                .status(AdStatus.DRAFT)
                .address("SPB, Nevskiy pr., 1, 1")
                .category(AdCategory.ELECTRONICS)
                .text("iPhone 13 for free!")
                .build();

        adRepository.save(ad);

    }
}
